/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game.piezas;

import ajedrez.code.game.Casilla;
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
public class Peon extends Pieza {

    public Peon(Color c, Casilla ca) {
        super(c, ca);
//        setToolTipText(Util.idioma[34]);
        super.toolTip = Util.idioma[34];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/peonN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/peonB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);
    }

    @Override
    protected void paintComponent(Graphics f) {
//        if (!Util.usarPiezasOriginales) {
//            f.setColor(super.getColor());
//        //bolita de la cabeza
////        f.fillOval(20, 8, 10, 10);
//            //cabeza
//            f.fillOval(13, 14, 25, 25);
//            //cuerpo
//            f.fillRect(18, 20, 15, 38);
//            //base
//            f.fillArc(0, 49, 50, 45, 0, 180);
//        }
//
    }

}
