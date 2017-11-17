/*
 * Copyright (C) 2017 Miky Mikusher
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */





package cv.mikusher.network;





import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Miky Mikusher
 */
public class HostInformation extends javax.swing.JFrame {

    private String host;
    private int    timeOutinMillis = 10000;





    /**
     * Creates new form tes
     */
    public HostInformation() {

        initComponents();
        this.setLocationRelativeTo(null);
        jtResultado.setEditable(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jThost = new javax.swing.JTextField();
        jbGo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Host Information");

        jLabel1.setText("HOST INFORMATION");

        jLabel2.setText("http://");

        jbGo.setText("GO");
        jbGo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jbGoActionPerformed(evt);
            }
        });

        jLabel3.setText("Resulte");

        jtResultado.setColumns(20);
        jtResultado.setRows(5);
        jScrollPane1.setViewportView(jtResultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addGroup(jPanel1Layout.createSequentialGroup()
                                                                             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                    .addComponent(jLabel1)
                                                                                                    .addComponent(jLabel3)
                                                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                                           .addComponent(jLabel2)
                                                                                                                           .addGap(2, 2, 2)
                                                                                                                           .addComponent(jThost,
                                                                                                                                         javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                         236,
                                                                                                                                         javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                           .addComponent(jbGo))
                                                                                                    .addComponent(jScrollPane1))
                                                                             .addGap(0, 8, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                           .addComponent(jLabel1)
                                                                           .addGap(18, 18, 18)
                                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                         .addComponent(jLabel2)
                                                                                                                         .addComponent(jThost,
                                                                                                                                       javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                       javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                       javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                  .addComponent(jbGo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                                           .addGap(18, 18, 18)
                                                                           .addComponent(jLabel3)
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addGroup(layout.createSequentialGroup()
                                                      .addContainerGap()
                                                      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents





    private void jbGoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbGoActionPerformed

        // TODO add your handling code here:
        String enderecoText = (String) jThost.getText();

        try {
            printAddressDetails(enderecoText);
            InetAddress addr = InetAddress.getByName(host);
            jtResultado.setText("Host '" + host + "' details starts..." + '\n' + "Host  IP  Address: " + addr.getHostAddress() + '\n' + "Canonical  Host  Name: " + addr.getCanonicalHostName() + '\n'
                                + "Local Address: " + addr.isSiteLocalAddress() + '\n' + "Multicast: " + addr.isMulticastAddress() + '\n' + "isReachable(): " + addr.isReachable(this.timeOutinMillis)
                                + '\n' + "isLoopbackAddress(): " + addr.isLoopbackAddress());
        } catch (IOException ex) {
            Logger.getLogger(HostInformation.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jbGoActionPerformed





    // não é mais necessario, mas pode manter para validação no outPut
    public void printAddressDetails(String host) throws UnknownHostException, IOException {

        this.host = host;
        InetAddress addr = InetAddress.getByName(host);

        System.out.println("Host '" + host + "' details starts...");
        System.out.println("Host  IP  Address: " + addr.getHostAddress());
        System.out.println("Canonical  Host  Name: " + addr.getCanonicalHostName());

        System.out.println("isReachable(): " + addr.isReachable(this.timeOutinMillis));
        System.out.println("isLoopbackAddress(): " + addr.isLoopbackAddress());
        System.out.println("");
    }





    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(HostInformation.class.getName())
                                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HostInformation.class.getName())
                                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HostInformation.class.getName())
                                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HostInformation.class.getName())
                                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HostInformation().setVisible(true);

            }
        });
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel      jLabel1;
    private javax.swing.JLabel      jLabel2;
    private javax.swing.JLabel      jLabel3;
    private javax.swing.JPanel      jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField  jThost;
    private javax.swing.JButton     jbGo;
    private javax.swing.JTextArea   jtResultado;
    // End of variables declaration//GEN-END:variables
}
