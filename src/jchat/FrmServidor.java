/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jchat;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablonoguera
 */
public class FrmServidor extends javax.swing.JFrame {

    Vector nb = new Vector(75);
    boolean continuar = true;
    public static String modoJuegoSeleccionado;

    /**
     * Creates new form FrmServidor
     */
    public FrmServidor() {
        initComponents();
        modoJuegoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartón lleno", "4 esquinas","L" }));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        lblNumero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBingo = new javax.swing.JTable();
        btnTerinar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        modoJuegoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciar.setText("Iniciar Bingo");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        lblNumero.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumero.setText("?");

        tbBingo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbBingo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "16", "31", "46", "61"},
                {"2", "17", "32", "47", "62"},
                {"3", "18", "33", "48", "63"},
                {"4", "19", "34", "49", "64"},
                {"5", "20", "35", "50", "65"},
                {"6", "21", "36", "51", "66"},
                {"7", "22", "37", "52", "67"},
                {"8", "23", "38", "53", "68"},
                {"9", "24", "39", "54", "69"},
                {"10", "25", "40", "55", "70"},
                {"11", "26", "41", "56", "71"},
                {"12", "27", "42", "57", "72"},
                {"13", "28", "43", "58", "73"},
                {"14", "29", "44", "59", "74"},
                {"15", "30", "45", "60", "75"}
            },
            new String [] {
                "B", "I", "N", "G", "O"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBingo.setGridColor(new java.awt.Color(204, 204, 204));
        tbBingo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBingo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBingo.setShowGrid(true);
        tbBingo.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tbBingo);
        if (tbBingo.getColumnModel().getColumnCount() > 0) {
            tbBingo.getColumnModel().getColumn(0).setHeaderValue("B");
            tbBingo.getColumnModel().getColumn(1).setHeaderValue("I");
            tbBingo.getColumnModel().getColumn(2).setHeaderValue("N");
            tbBingo.getColumnModel().getColumn(3).setHeaderValue("G");
            tbBingo.getColumnModel().getColumn(4).setHeaderValue("O");
        }

        btnTerinar.setText("Detener Partida");
        btnTerinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerinarActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        modoJuegoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        modoJuegoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoJuegoComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnTerinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modoJuegoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTerinar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modoJuegoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        int nr = (int) (Math.random() * 76);
        if (!nb.contains(nr) && nr > 0) {
            nb.add(nr);
            try {
                    Servidor.marcarNumero(nr);
                if (continuar) {
                    broadcast(String.valueOf(nr));
                    System.out.println(nr);
                    lblNumero.setText(String.valueOf(nr));
                    lblNumero.repaint();
                    if (nr > 0 && nr < 16) {
                        tbBingo.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 15 && nr < 31) {
                        tbBingo.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 30 && nr < 46) {
                        tbBingo.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (nr > 45 && nr < 61) {
                        tbBingo.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer(nr, nb));
                    }
                    if (60 > 0 && nr < 76) {
                        tbBingo.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer(nr, nb));
                    }

                    tbBingo.repaint();
                    Thread.sleep(1000);
                }

            } catch (Exception ex) {
                System.out.println("ex: " + ex.getMessage());
            }

        }


    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnTerinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerinarActionPerformed
        continuar = false;
    }//GEN-LAST:event_btnTerinarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        continuar = true;
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void modoJuegoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoJuegoComboBoxActionPerformed
        modoJuegoSeleccionado = (String) modoJuegoComboBox.getSelectedItem();
    }//GEN-LAST:event_modoJuegoComboBoxActionPerformed
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServidor().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnTerinar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JComboBox<String> modoJuegoComboBox;
    private javax.swing.JTable tbBingo;
    // End of variables declaration//GEN-END:variables
}
