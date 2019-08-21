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
public class Rey extends Pieza {

    public boolean estaEnjake = false;

    public Rey(Color c, Casilla ca) {
        super(c, ca);
//        setToolTipText(Util.idioma[35]);
        super.toolTip = Util.idioma[35];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/reyN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/reyB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);

    }

    @Override
    protected void paintComponent(Graphics f) {
//        if (!Util.usarPiezasOriginales) {
//            f.setColor(super.getColor());
//
//            //linea vertical de la cruz
//            f.fillRect(23, 0, 3, 10);
//            //linea horizontal de la cruz
//            f.fillRect(20, 3, 10, 3);
//            //cabeza
//            f.fillOval(14, 8, 21, 20);
//            //garganta
//            f.fillOval(14, 22, 22, 10);
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
