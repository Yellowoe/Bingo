
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author Martín, Carlos, Gregory
 */
public class client extends Frame implements ActionListener{

    static Socket sfd = null;
    static DataInputStream EntradaSocket;
    static DataOutputStream SalidaSocket;
    static TextField salida;
    static TextArea entrada;
    String texto;
    private static final String VIDEO_FILE = "video_received.mp4";

    public client() {
        setTitle("BINGO GAME");
        setSize(550, 400);
        salida = new TextField(30);
        salida.addActionListener(this);

        entrada = new TextArea();
        entrada.setEditable(false);

        add("South", salida);
        add("Center", entrada);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        texto = salida.getText();
        salida.setText("");
        try {
            SalidaSocket.writeUTF(texto);
            SalidaSocket.flush();
        } catch (IOException ioe) {
            System.out.println("Error mensaje ");
            System.out.println("Error: " + ioe);
        }
    }

    public boolean handleEvent(Event e) {
        if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            if (sfd != null) {
                try {
                    sfd.close();
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
                this.dispose();
            }
        }
        return true;
    }

    
    public static void main(String[] args)  {
         client cliente = new client();
        try {
            sfd = new Socket("172.17.47.74", 8000);
            EntradaSocket = new DataInputStream(
                    new BufferedInputStream(sfd.getInputStream()));
            SalidaSocket = new DataOutputStream(
                    new BufferedOutputStream(sfd.getOutputStream()));
            System.out.println("Conectado al servidor.");
        } catch (UnknownHostException uhe) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Comunicacion rechazada.");
            System.exit(1);
        }
        while (true) {
            try {
                //Recibimos del servidor
                String linea = EntradaSocket.readUTF();
                //Comprueba si tiene identificador
                if (linea.equals("#")) {     
                    System.out.println("Video recibido y guardado como "
                            + VIDEO_FILE);
                    //Recibimos y lo guardamos como VIDEO_FILE
                    FileOutputStream fileOutputStream = 
                            new FileOutputStream(VIDEO_FILE);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = EntradaSocket.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                    fileOutputStream.close();
                    
                    
       //Abrir el archivo de video con el reproductor multimedia predeterminado
                    File videoFile = new File(VIDEO_FILE);
                    Desktop.getDesktop().open(videoFile);

    //Esperar hasta que el reproductor multimedia termine de reproducir el video
                    try {
                        while (Desktop.getDesktop()
                                .isSupported(Desktop.Action.OPEN)) {
                        Thread.sleep(100);
                    }
                    } catch (Exception e) {
                        System.out.println("Error");
                    }

              //Eliminar el archivo de video temporal después de la reproducción
                    Files.deleteIfExists(Paths.get(VIDEO_FILE));
                    System.out.println("Reproducción de video finalizada.");
                    
                } else{
                    entrada.append(linea + "\n");
                }
            } catch (IOException ioe) {
                System.exit(1);
            }
        }
        
    }
}