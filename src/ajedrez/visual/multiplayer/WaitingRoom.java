/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.visual.multiplayer;

import ajedrez.code.conection.ConexionJDBC;
import ajedrez.code.conection.DatosConexion;
import ajedrez.code.game.Jugador;
import ajedrez.code.util.Sound;
import ajedrez.code.util.Util;
import ajedrez.visual.game_interface.Interfaz;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rene
 */
public class WaitingRoom extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form WaitingRoom
     */
    Thread t;
    ConexionJDBC miConexion;
    DatosConexion data;

    public WaitingRoom(DatosConexion d, ConexionJDBC conex) {
        setCursor(new Cursor(3));
        initComponents();
        if (!d.esServidor) {
            jButton1.setVisible(false);
        }
        data = d;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ajedrez/images/app_icon.png")));
        Sound.init();
        setVisible(true);
//        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);

        t = new Thread(this);

        miConexion = conex;
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        j1p = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        j2p = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Util.idioma[104]);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Util.idioma[105], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(189, 72));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j1p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/peonB.png"))); // NOI18N
        jPanel1.add(j1p, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 48));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("nombre servidor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 230, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Util.idioma[106], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(189, 72));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j2p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/peonN.png"))); // NOI18N
        jPanel4.add(j2p, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("nombre inivtado");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 230, -1));

        jButton1.setText(Util.idioma[9]);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (Util.showQuestion(Util.idioma[112], Util.idioma[28]) == 0) {

            try {
                if (data.esServidor) {
                    ResultSet rs = miConexion.ejecutarConsulta("DELETE FROM conection");
                    rs = miConexion.ejecutarConsulta("DELETE FROM data_negras");
                    rs = miConexion.ejecutarConsulta("DELETE FROM data_blancas");
                    rs = miConexion.ejecutarConsulta("DELETE FROM controlador");
                } else {
                    ResultSet rs2 = miConexion.ejecutarConsulta("UPDATE conection SET invitado='" + "" + "'");
                    dispose();
                    new MultiJugador();
                    t.stop();
                }

            } catch (SQLException ex) {
                Util.showError(ex.toString());
            }
        }
    }//GEN-LAST:event_formWindowClosing

    void interrumpirConexion() {
        Util.showError(Util.idioma[108]);
        dispose();
        new MultiJugador();
        t.stop();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            ResultSet rs2 = miConexion.ejecutarConsulta("UPDATE conection SET comenzo=" + true + "");
        } catch (SQLException ex) {
            Util.showError(ex.toString());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(WaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(WaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(WaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(WaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WaitingRoom().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel j1p;
    private javax.swing.JLabel j2p;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    boolean comenzo = false;
 

    @Override
    public void run() {
        while (true) {
            try {
                ResultSet rs1 = miConexion.ejecutarConsulta("SELECT * FROM conection WHERE id='1'");
                Object[][] sel = DatosConexion.getTableFomResultSet(rs1);
                String serv = (String) sel[0][0];
                String inv = (String) sel[0][1];
                String com = (String) sel[0][5];
                String pieza = (String) sel[0][6];

                if (pieza.equals("1")) {                
                    j1p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/peonN.png")));
                    j2p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/peonB.png")));
                }
                if (com.equals("t")) {
                    comenzo = true;
                }
                jLabel1.setText((serv.equals("") ? "-----" : serv));
                jLabel3.setText((inv.equals("") ? "-----" : inv));
                if (!jLabel1.getText().equals("-----") && !jLabel3.getText().equals("-----")) {
                   
                    jButton1.setEnabled(true);
                    setCursor(new Cursor(0));
                } else {
                   
                    setCursor(new Cursor(3));
                    jButton1.setEnabled(false);
                }
                if (comenzo) {
                    String mostr_jug = (String) sel[0][2];
                    boolean mostrarJug = false;
                    if (mostr_jug.toLowerCase().equals("t")) {
                        mostrarJug = true;
                    }
                    int time = Integer.parseInt((String) sel[0][4]);
                    setGame(serv, inv, time, mostrarJug, Integer.parseInt(pieza));
                }
            } catch (Exception ex) {
//                Logger.getLogger(WaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
                interrumpirConexion();
            }
        }
    }

    private void setGame(String serv, String inv, int minutes, boolean mostrarJug, int pieza) {
        try {
            Util.mostrarPosibleJugada = mostrarJug;
            int hor = 0;
            int min = minutes;
            if (min > 59) {
                hor = 1;
                min = min - 60;
            }
            Util.min = min;
            Util.hour = hor;
            dispose();
            Jugador jug1, jug2;
            if (pieza == 0) {//blancas
                jug1 = new Jugador(serv, Util.blancas, false);
                jug2 = new Jugador(inv, Util.negras, false);
                if (data.esServidor) {
                    jug2.juegaPorRed = true;

                } else {
                    jug1.juegaPorRed = true;
                }
            } else {//negras
                jug1 = new Jugador(inv, Util.blancas, false);
                jug2 = new Jugador(serv, Util.negras, false);
                if (data.esServidor) {
                    jug1.juegaPorRed = true;

                } else {
                    jug2.juegaPorRed = true;
                }

            }

            if (data.esServidor && pieza == 1) {
                Util.tableroInvertido = true;
            } else if (!data.esServidor && pieza == 0) {
                Util.tableroInvertido = true;
            } else {
                Util.tableroInvertido = false;
            }
            ResultSet rs = miConexion.ejecutarConsulta("DELETE FROM conection");
            rs = miConexion.ejecutarConsulta("DELETE FROM data");
            rs = miConexion.ejecutarConsulta("DELETE FROM controlador");
            ResultSet rs2 = miConexion.ejecutarConsulta("INSERT INTO data (casilla_inicio,casilla_fin,peonalpaso,casillacomida_pap,piezaenmeta,piezacambiada) VALUES('" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "')");
            rs2 = miConexion.ejecutarConsulta("INSERT INTO controlador (chat,logger) VALUES('" + "" + "','" + "" + "')");
            new Interfaz(jug1, jug2, miConexion, data);
            System.out.println(jug1.getNombre() + " " + jug1.juegaPorRed);
            System.out.println(jug2.getNombre() + " " + jug2.juegaPorRed);
            System.out.println("piezas " + pieza);
            System.out.println("tab invert " + Util.tableroInvertido);
            t.stop();
        } catch (SQLException ex) {
            Util.showError(ex.toString());
        }

    }
}