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
 * @author Cyrax
 */
public class Dama extends Pieza {

    public Dama(Color c, Casilla ca) {
        super(c, ca);
//        setToolTipText(Util.idioma[33]);
        super.toolTip = Util.idioma[33];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/damaN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/damaB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);

    }
//
    @Override
    protected void paintComponent(Graphics f) {
//        if (!Util.usarPiezasOriginales) {
//            f.setColor(super.getColor());
//
//            //punta de la corona
//            f.fillOval(22, 1, 5, 8);
//            //primer ovalo de la corona
//            f.fillOval(12, 4, 15, 10);
//            //segunda ovalo de la corona
//            f.fillOval(23, 4, 15, 10);
//            //cabeza
//            f.fillOval(14, 8, 21, 20);
//            //garganta
//            f.fillOval(14, 23, 21, 10);
//            //cuerpo
//            f.fillRect(18, 25, 15, 38);
//            //ovalo base
//            f.fillOval(10, 49, 30, 15);
//            //base
//            f.fillArc(0, 55, 50, 35, 0, 180);
//        }
//
    }

}
