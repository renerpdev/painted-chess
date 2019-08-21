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
import java.awt.Graphics2D;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Rene
 */
public class Torre extends Pieza  {

    public Torre(Color c, Casilla ca) {
        super(c, ca);
//        setToolTipText(Util.idioma[32]);
        super.toolTip = Util.idioma[32];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/torN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/torB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);
    }

    @Override
    protected void paintComponent(Graphics f) {
         
//
//        if (!Util.usarPiezasOriginales) {
////
//            f.setColor(super.getColor());
//
//            //primer bloque de la torre
//            f.fillRect(1, 2, 11, 10);
//            //segundo bloque de la torre
//            f.fillRect(14, 2, 10, 10);
//            //tercer bloque de la torre
//            f.fillRect(26, 2, 10, 10);
//            //cuarto bloque de la torre
//            f.fillRect(38, 2, 10, 10);
//            //cabeza
//            f.fillRect(5, 8, 40, 20);
//            //cuerpo
//            f.fillRect(13, 28, 25, 38);
//            //base
//            f.fillArc(0, 47, 50, 50, 0, 180);
//        }
    }

}
