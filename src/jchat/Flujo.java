/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jchat;

/**
 *
 * @author pablonoguera
 */
import claseshijas.Estudiante;
import java.awt.Color;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jchat.Servidor.numerosMarcados;

public class Flujo extends Thread {

    Socket nsfd;
    DataInputStream FlujoLectura;
    DataOutputStream FlujoEscritura;
    String nombre;
    int[][] carton;

    public Flujo(Socket sfd, String nombre, int[][] carton) {
        this.carton = carton;

        this.nombre = nombre;
        nsfd = sfd;
        try {
            FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
        } catch (IOException ioe) {
            System.out.println("IOException(Flujo): " + ioe);
        }
    }

    public void run() {

        Servidor.usuarios.add(new Usuario(this, this.nombre, this.carton));
        broadcast(nombre + " se ha conectado");

        while (true) {
            try {
                String linea = FlujoLectura.readUTF();
                if (linea.equals("BINGO")) {
                    boolean finalizar = comprobarBingo();
                    if (finalizar) {
                        terminarBingo();
                    }
                } else {
                    if (!linea.equals("")) {
                        linea = nombre + "> " + linea;
                        broadcast(linea);
                    }

                    if (linea.contains("carton")) {
                        sendCarton(this.nombre);
                    }
                }
            } catch (IOException ioe) {
                Servidor.usuarios.removeElement(this);
                broadcast(nombre + "> se ha desconectado");
                break;
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void broadcast(String mensaje) {
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                try {
                    synchronized (f.FlujoEscritura) {
                        f.FlujoEscritura.writeUTF(mensaje);
                        f.FlujoEscritura.flush();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        }
    }

    private static String getCartonString(int[][] carton) {
        String cartonString = "carton:";
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                cartonString += String.valueOf(carton[i][j] + ",");
            }
            cartonString += ":";
        }
        return cartonString;
    }

    private void sendCarton(String name) {

        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                if (user.getNombre().equals(name)) {

                    synchronized (f.FlujoEscritura) {
                        try {
                            f.FlujoEscritura.writeUTF(getCartonString(user.getCarton()));
                            f.FlujoEscritura.flush();
                        } catch (IOException ex) {
                            Logger.getLogger(Flujo.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }

        }

    }

// Función para verificar si todas las esquinas están marcadas
    private boolean verificarCuatroEsquinas(int[][] matrix) {
        return numerosMarcados.contains(matrix[0][0])
                && numerosMarcados.contains(matrix[0][4])
                && numerosMarcados.contains(matrix[4][0])
                && numerosMarcados.contains(matrix[4][4]);
    }

// Función para verificar si los números en forma de L están marcados
    private boolean verificarL(int[][] matrix) {
        return numerosMarcados.contains(matrix[0][0])
                && numerosMarcados.contains(matrix[1][0])
                && numerosMarcados.contains(matrix[2][0])
                && numerosMarcados.contains(matrix[3][0])
                && numerosMarcados.contains(matrix[4][0])
                && numerosMarcados.contains(matrix[4][1])
                && numerosMarcados.contains(matrix[4][2])
                && numerosMarcados.contains(matrix[4][3])
                && numerosMarcados.contains(matrix[4][4]);
    }

// Función para verificar si todos los números del cartón han sido marcados
    private boolean verificarCartonCompleto(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 2 || j != 2 && !numerosMarcados.contains(matrix[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean comprobarCartones(String modoJuego, int[][] matrix) {
        if (modoJuego != null) {
            if (modoJuego.equals("4 esquinas")) {
                return verificarCuatroEsquinas(matrix);
            } else if (modoJuego.equals("L")) {
                return verificarL(matrix);
            }
        }
        return verificarCartonCompleto(matrix);
    }

    private boolean comprobarBingo() {
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                int[][] matrix = user.getCarton();

                String modoJuego = FrmServidor.modoJuegoSeleccionado;

                boolean bingo = comprobarCartones(modoJuego, matrix);

                if (bingo) {
                    try {
                        synchronized (f.FlujoEscritura) {
                            f.FlujoEscritura.writeUTF("BINGO! Has ganado.");
                            f.FlujoEscritura.flush();
                            terminarBingo();
                            
                           
                        }
                    } catch (IOException ioe) {
                        System.out.println("Error: " + ioe);
                    }
                } else {
                    try {
                        synchronized (f.FlujoEscritura) {
                            f.FlujoEscritura.writeUTF("No mienta, siga jugando.");
                            f.FlujoEscritura.flush();
                        }
                    } catch (IOException ioe) {
                        System.out.println("Error: " + ioe);
                    }
                }
            }
        }
        return false;
    }

   private void terminarBingo() {
    synchronized (Servidor.usuarios) {
        Enumeration e = Servidor.usuarios.elements();
        while (e.hasMoreElements()) {
            Usuario user = (Usuario) e.nextElement();
            Flujo f = (Flujo) user.getFlujo();
            try {
                synchronized (f.FlujoEscritura) {
                    f.FlujoEscritura.writeUTF("El juego ha terminado. ¡Gracias por jugar!");
                    f.FlujoEscritura.flush();
                }
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }
}

}
