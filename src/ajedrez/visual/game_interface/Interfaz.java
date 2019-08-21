/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.visual.game_interface;

import ajedrez.code.conection.ConexionJDBC;
import ajedrez.code.game.Controlador;
import ajedrez.code.util.CurrentData;
import ajedrez.code.conection.DatosConexion;
import ajedrez.code.game.Jugador;
import ajedrez.code.util.Sound;
import ajedrez.code.util.Util;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rene
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form contr
     */
    Controlador controlador;

    public Interfaz(String jugador1Nombre, String jugador2Nombre, boolean pc1, boolean pc2) {//nuevo juego
        Sound.init();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ajedrez/images/app_icon.png")));
        setCursor(new Cursor(3));
        initComponents();
//        jMenuBar1.setVisible(false);
        jButton3.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem11.setVisible(false);
        jMenuItem3.setVisible(false);
        jMenuItem8.setVisible(false);

        jMenuItem1.setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle(Util.idioma[29]);
        Jugador jug1 = new Jugador(jugador1Nombre, Util.blancas, pc1);
        Jugador jug2 = new Jugador(jugador2Nombre, Util.negras, pc2);
        controlador = new Controlador(jug1, jug2, this, null, null, null);

    }

    public Interfaz(Jugador j1, Jugador j2, ConexionJDBC conex, DatosConexion data) {//multiplayer
        Sound.init();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ajedrez/images/app_icon.png")));
        setCursor(new Cursor(3));
        initComponents();
//        jMenuBar1.setVisible(false);
        jButton3.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem11.setVisible(false);
        jMenuItem8.setVisible(false);

        jMenuItem1.setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle(Util.idioma[29]);

        controlador = new Controlador(j1, j2, this, null, conex, data);

    }

    public Interfaz(CurrentData cd, String address) {//cargar juego
        Sound.init();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ajedrez/images/app_icon.png")));
        setCursor(new Cursor(3));
        initComponents();
        setLanguage();
//        jMenuBar1.setVisible(false);
        jButton3.setVisible(false);
        jButton1.setVisible(false);
//        jMenuItem11.setVisible(false);
        jMenuItem8.setVisible(false);
        jMenuItem11.setVisible(false);
        jMenuItem3.setVisible(false);
        jMenuItem1.setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle(Util.idioma[29]);
        Jugador jug1 = cd.getJ1();
        Jugador jug2 = cd.getJ2();
        controlador = new Controlador(jug1, jug2, this, address, null, null);
        controlador.getTablero().setEmptyCasillas();
        controlador.openFile(cd, address);

    }

    void setLanguage() {
        jLabel2.setText(Util.idioma[24]);
        jLabel3.setText(Util.idioma[25]);
        jLabel5.setText(Util.idioma[24]);
        jLabel6.setText(Util.idioma[25]);

        jMenu1.setText(Util.idioma[16]);
        jMenuItem2.setText(Util.idioma[18]);
        jMenu2.setText(Util.idioma[21]);
        jMenuItem5.setText(Util.idioma[23]);
        jMenuItem7.setText(Util.idioma[30]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        j1Nombre = new javax.swing.JLabel();
        j1color = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        j1piezas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j1Comidas = new javax.swing.JLabel();
        j1Timer = new ajedrez.visual.game_interface.Clock();
        jLabel7 = new javax.swing.JLabel();
        j2Nombre = new javax.swing.JLabel();
        j2color = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        j2piezas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        j2Comidas = new javax.swing.JLabel();
        j2Timer = new ajedrez.visual.game_interface.Clock();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        log2 = new javax.swing.JTextArea();
        numeraciones2 = new ajedrez.visual.game_interface.Numeraciones();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem12.setText("jMenuItem12");

        jMenuItem13.setText("jMenuItem13");

        jMenuItem14.setText("jMenuItem14");

        jMenuItem15.setText("jMenuItem15");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PAINTED CHESS 1.0");
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        j1Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j1Nombre.setText("Jugador1");
        jPanel1.add(j1Nombre);

        j1color.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(j1color);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText(Util.idioma[24]);
        jPanel1.add(jLabel2);

        j1piezas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        j1piezas.setText("0");
        jPanel1.add(j1piezas);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText(Util.idioma[25]);
        jPanel1.add(jLabel3);

        j1Comidas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        j1Comidas.setText("0");
        jPanel1.add(j1Comidas);
        jPanel1.add(j1Timer);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("||");
        jLabel7.setEnabled(false);
        jPanel1.add(jLabel7);

        j2Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j2Nombre.setText("Jugador2");
        jPanel1.add(j2Nombre);

        j2color.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(j2color);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText(Util.idioma[24]);
        jPanel1.add(jLabel5);

        j2piezas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        j2piezas.setText("0");
        jPanel1.add(j2piezas);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText(Util.idioma[25]);
        jPanel1.add(jLabel6);

        j2Comidas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        j2Comidas.setText("0");
        jPanel1.add(j2Comidas);
        jPanel1.add(j2Timer);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Undo.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Redo.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        log2.setEditable(false);
        log2.setColumns(13);
        log2.setRows(1);
        log2.setEnabled(false);
        log2.setOpaque(false);
        jScrollPane2.setViewportView(log2);

        jPanel2.add(jScrollPane2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);
        getContentPane().add(numeraciones2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        log1.setEditable(false);
        log1.setColumns(13);
        log1.setRows(1);
        log1.setEnabled(false);
        log1.setOpaque(false);
        jScrollPane1.setViewportView(log1);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        jMenu1.setText(Util.idioma[16]);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Clean.png"))); // NOI18N
        jMenuItem6.setText(Util.idioma[86]);
        jMenuItem6.setEnabled(false);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Save.png"))); // NOI18N
        jMenuItem2.setText(Util.idioma[18]);
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Verify.png"))); // NOI18N
        jMenuItem11.setText(Util.idioma[26]);
        jMenuItem11.setEnabled(false);
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Mail.png"))); // NOI18N
        jMenuItem3.setText("CHAT");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Pause.png"))); // NOI18N
        jMenuItem17.setText(Util.idioma[87]);
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Media-Play.png"))); // NOI18N
        jMenuItem1.setText(Util.idioma[88]);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Documents.png"))); // NOI18N
        jMenuItem8.setText(Util.idioma[70]);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/House.png"))); // NOI18N
        jMenuItem16.setText(Util.idioma[81]);
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(Util.idioma[21]);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Information.png"))); // NOI18N
        jMenuItem4.setText(Util.idioma[22]);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Help(1).png"))); // NOI18N
        jMenuItem5.setText(Util.idioma[23]);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Rook.png"))); // NOI18N
        jMenuItem7.setText(Util.idioma[30]);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

        controlador.closeGame();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        controlador.saveGame();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        controlador.loadLogger();

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        controlador.exportLogger();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/History_of_chess"));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        controlador.prevPlay();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        System.out.println(evt.getKeyCode());
        if (key == 27) {//ESCAPE
//            controlador.goToStartMenu();
        } else if (key == 112) {//F1 ayuda del juego

        } else if (key == 83) {//S salvar juego
            controlador.saveGame();
        } else if (key == 122) {//F11 historia del ajedrez

        } else if (key == 123) {//F12 copyRight
            controlador.showCopyRight();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        controlador.goToStartMenu();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        controlador.nextPlay();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        controlador.resetGame();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        controlador.playGame();
        System.out.println("play");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:

        controlador.pauseGame();
        System.out.println("pausa");
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        controlador.chat.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        controlador.showCopyRight();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://github.com/2rhop/painted-chess"));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
//            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Interfaz().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel j1Comidas;
    public javax.swing.JLabel j1Nombre;
    public javax.swing.JPanel j1Timer;
    public javax.swing.JPanel j1color;
    public javax.swing.JLabel j1piezas;
    public javax.swing.JLabel j2Comidas;
    public javax.swing.JLabel j2Nombre;
    public javax.swing.JPanel j2Timer;
    public javax.swing.JPanel j2color;
    public javax.swing.JLabel j2piezas;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    public javax.swing.JMenuItem jMenuItem17;
    public javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JMenuItem jMenuItem7;
    public javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public javax.swing.JTextArea log1;
    public javax.swing.JTextArea log2;
    public ajedrez.visual.game_interface.Numeraciones numeraciones2;
    // End of variables declaration//GEN-END:variables
}