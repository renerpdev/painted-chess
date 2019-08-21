/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game.piezas;

import ajedrez.code.game.Casilla;
import ajedrez.code.game.piezas.Pieza;
import ajedrez.code.util.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Rene
 */
public class Alfil extends Pieza {

    public Alfil(Color c, Casilla ca) {
        super(c, ca);
//        setToolTipText(Util.idioma[36]);
        super.toolTip = Util.idioma[36];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/alfN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/alfB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);
    }
//
    @Override
    protected void paintComponent(Graphics f) {
////
//        if (!Util.usarPiezasOriginales) {
//            f.setColor(super.getColor());
//            //puntica de la cabeza
//            f.fillOval(23, 0, 5, 12);
//            //primera bola de la cabeza
//            f.fillOval(18, 5, 15, 17);
//            //bola de la cabeza
//            f.fillOval(15, 10, 21, 20);
//            //cuerpo
//            f.fillRect(19, 20, 13, 38);
//            //adorno de la base
//            f.fillOval(10, 47, 30, 15);
//            //base
//            f.fillArc(0, 52, 50, 40, 0, 180);
//        }
//
    }

}
