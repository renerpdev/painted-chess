/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.visual.game_interface;

import ajedrez.code.game.piezas.Alfil;
import ajedrez.code.game.piezas.Caballo;
import ajedrez.code.game.piezas.Dama;
import ajedrez.code.game.piezas.Pieza;
import ajedrez.code.game.piezas.Torre;
import ajedrez.code.util.Util;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Rene
 */
public class SeleccionarNuevaPieza extends javax.swing.JDialog {

    /**
     * Creates new form SelectNewPieza
     */
    public SeleccionarNuevaPieza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);        
        pack();
        setResizable(false);

    }

    public void setPiezaCambiada(Pieza p) {
        p.setJugador(Util.piezaTemporal.getJugador());
        Util.piezaCambiada = p;
        dispose();
    }

    public void setColors() {
        System.out.println("fd");
        if (Util.blancas.equals(Util.piezaTemporal.getColor())) {//si es una pieza blanca
            tor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/torB.png")));
            dama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/damaB.png")));
            alf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/alfB.png")));
            cab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/cabB.png")));
        }
        container.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        ca = new javax.swing.JPanel();
        cab = new javax.swing.JLabel();
        to = new javax.swing.JPanel();
        tor = new javax.swing.JLabel();
        al = new javax.swing.JPanel();
        alf = new javax.swing.JLabel();
        alf = new javax.swing.JLabel();
        da = new javax.swing.JPanel();
        dama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Util.idioma[47]);
        setIconImage(null);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        ca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                caMousePressed(evt);
            }
        });
        ca.setLayout(new java.awt.GridLayout(1, 0));

        if(Util.piezaTemporal.getColor().equals(Util.blancas)){
            cab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/cabB.png")));
        }else{
            cab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/cabN.png")));
        }
        ca.add(cab);

        container.add(ca);

        to.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        to.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        to.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toMousePressed(evt);
            }
        });
        to.setLayout(new java.awt.GridLayout(1, 0));

        if(Util.piezaTemporal.getColor().equals(Util.blancas)){
            tor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/torB.png")));
        }else{
            tor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/torN.png")));
        }
        to.add(tor);

        container.add(to);

        al.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        al.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                alMousePressed(evt);
            }
        });
        al.setLayout(new java.awt.GridLayout(1, 0));

        if(Util.piezaTemporal.getColor().equals(Util.blancas)){
            alf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/alfB.png")));
        }else{
            alf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/alfN.png")));// NOI18N
        }
        al.add(alf);

        container.add(al);

        da.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        da.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        da.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                daMousePressed(evt);
            }
        });
        da.setLayout(new java.awt.GridLayout(1, 0));

        if(Util.piezaTemporal.getColor().equals(Util.blancas)){
            dama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/damaB.png")));
        }else{
            dama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/damaN.png")));
        }
        da.add(dama);

        container.add(da);

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMousePressed
        // TODO add your handling code here:
        Dama p = new Dama(Util.piezaTemporal.getColor(), Util.piezaTemporal.getCasilla());
        p.setJugador(Util.piezaTemporal.getJugador());
        setPiezaCambiada(p);
    }//GEN-LAST:event_daMousePressed

    private void alMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alMousePressed
        // TODO add your handling code here:
        Alfil p = new Alfil(Util.piezaTemporal.getColor(), Util.piezaTemporal.getCasilla());
        p.setJugador(Util.piezaTemporal.getJugador());
        setPiezaCambiada(p);
    }//GEN-LAST:event_alMousePressed

    private void toMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMousePressed
        // TODO add your handling code here:
        Torre p = new Torre(Util.piezaTemporal.getColor(), Util.piezaTemporal.getCasilla());
        p.setJugador(Util.piezaTemporal.getJugador());
        setPiezaCambiada(p);
    }//GEN-LAST:event_toMousePressed

    private void caMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caMousePressed
        // TODO add your handling code here:
        Caballo p = new Caballo(Util.piezaTemporal.getColor(), Util.piezaTemporal.getCasilla());
        p.setJugador(Util.piezaTemporal.getJugador());
        setPiezaCambiada(p);
    }//GEN-LAST:event_caMousePressed

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
            java.util.logging.Logger.getLogger(SeleccionarNuevaPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarNuevaPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarNuevaPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarNuevaPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SeleccionarNuevaPieza dialog = new SeleccionarNuevaPieza(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel al;
    private javax.swing.JLabel alf;
    private javax.swing.JPanel ca;
    private javax.swing.JLabel cab;
    private javax.swing.JPanel container;
    private javax.swing.JPanel da;
    private javax.swing.JLabel dama;
    private javax.swing.JPanel to;
    private javax.swing.JLabel tor;
    // End of variables declaration//GEN-END:variables
}
