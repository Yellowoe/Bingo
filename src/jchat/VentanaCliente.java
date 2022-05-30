/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jchat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablonoguera
 */
public class VentanaCliente extends javax.swing.JFrame {

    static Socket sfd = null;
    static DataInputStream EntradaSocket;
    static DataOutputStream SalidaSocket;
    static HashSet<String> usersName;
    static DefaultListModel listModel;
    static DefaultTableModel tableModel;
    static ArrayList numeros = new ArrayList();
    static Vector nb = new Vector(75);
    static boolean b=true;
    /**
     * Creates new form VentanaCliente
     */
    public VentanaCliente() {
        this.usersName = new HashSet();
        listModel = new DefaultListModel();
        tableModel = new DefaultTableModel();

        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextAreaMensajes = new javax.swing.JTextArea();
        txtIngreso = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        btnEnviar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtextAreaMensajes.setEditable(false);
        jtextAreaMensajes.setColumns(20);
        jtextAreaMensajes.setRows(5);
        jScrollPane1.setViewportView(jtextAreaMensajes);

        txtIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIngresoKeyPressed(evt);
            }
        });

        tablero.setBackground(new java.awt.Color(204, 204, 204));
        tablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "B", "I", "N", "G", "o"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablero.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablero);
        if (tablero.getColumnModel().getColumnCount() > 0) {
            tablero.getColumnModel().getColumn(0).setResizable(false);
            tablero.getColumnModel().getColumn(0).setPreferredWidth(60);
            tablero.getColumnModel().getColumn(1).setResizable(false);
            tablero.getColumnModel().getColumn(2).setResizable(false);
            tablero.getColumnModel().getColumn(3).setResizable(false);
            tablero.getColumnModel().getColumn(4).setResizable(false);
        }

        jScrollPane2.setViewportView(listaUsuarios);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jButton1.setText("Pedir Carton");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String texto = txtIngreso.getText();
        txtIngreso.setText("");
        try {
            SalidaSocket.writeUTF(texto);
            SalidaSocket.flush();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            String texto = txtIngreso.getText();
            txtIngreso.setText("");
            try {
                SalidaSocket.writeUTF(texto);
                SalidaSocket.flush();
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }//GEN-LAST:event_txtIngresoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            SalidaSocket.writeUTF("carton");
            SalidaSocket.flush();
           
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
        String nameInput = JOptionPane.showInputDialog("ingrese su nombre");

        //tablero.setModel(tableModel);
        try {
            sfd = new Socket("localhost", 8000);

            EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));

            SalidaSocket.writeUTF(nameInput);
            SalidaSocket.flush();

        } catch (UnknownHostException uhe) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada.");
            System.exit(1);
        }
        while (true) {
            try {
                String linea = EntradaSocket.readUTF();
                

                if (linea.contains("carton")) {

                    //  carton:5,28,43,47,71,:6,29,36,59,68,:1,26,34,57,70,:9,21,30,54,73,:13,18,44,53,67,:
                    String[] filas = linea.split(":");
                    for (int i = 1; i < filas.length; i++) {
                        String[] nums = filas[i].split(",");

                        for (int j = 0; j < nums.length; j++) {
                           
                            numeros.add(nums[j]);
                        }
                       
                        // System.out.println(nums[i]);
                    }

                }else{
                    jtextAreaMensajes.append(linea + "\n");
                }
                
                System.out.println();
            
//////                
//                usersName.add(linea.split(" ")[0].replace(">", ""));
//                listModel.removeAllElements();
//                
//               
//                usersName.forEach((item) -> listModel.addElement(item));
//              
//                
//                listaUsuarios.setModel(listModel);
//
                if (!numeros.isEmpty() && b ) {
                    System.out.println("re model");
                 b=false;
                tablero.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {numeros.get(0), numeros.get(1), numeros.get(2), numeros.get(3), numeros.get(4)},
                            {numeros.get(5), numeros.get(6), numeros.get(7), numeros.get(8), numeros.get(9)},
                            {numeros.get(10), numeros.get(11), numeros.get(12), numeros.get(13), numeros.get(14)},
                            {numeros.get(15), numeros.get(16), numeros.get(17), numeros.get(18), numeros.get(19)},
                            {numeros.get(20), numeros.get(21), numeros.get(22), numeros.get(23), numeros.get(24)}
                            
                        },
                        new String[]{
                            "B", "I", "N", "G", "O"
                        }
                ));
                }
                 
                   if (isNumeric(linea)) {
                       int nr = Integer.parseInt(linea);
                       nb.add(nr);
                    if (nr > 0 && nr < 16) {
                        tablero.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 15 && nr < 31) {
                        tablero.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 30 && nr < 46) {
                        tablero.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 45 && nr < 61) {
                        tablero.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 60 && nr < 76) {
                        tablero.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    tablero.repaint();
                }
                
                   
            } catch (IOException ioe) {
                System.exit(1);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea jtextAreaMensajes;
    private static javax.swing.JList<String> listaUsuarios;
    private static javax.swing.JTable tablero;
    private javax.swing.JTextField txtIngreso;
    // End of variables declaration//GEN-END:variables
}
