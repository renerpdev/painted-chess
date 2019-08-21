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
public class Caballo extends Pieza {

    public Caballo(Color c, Casilla ca) {
        super(c, ca);
        super.toolTip = Util.idioma[31];
            Icon ico = null;
            if (color.equals(Util.negras)) {
                //           jajajaj aqui tienes el mio
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/cabN.png"));
            } else {
                ico = new ImageIcon(getClass().getResource("/ajedrez/images/cabB.png"));
            }
            JLabel la = new JLabel(ico);
            add(la);
    }

    @Override
    protected void paintComponent(Graphics f) {
////           jajajaj aqui tienes mi caballo
//        if (!Util.usarPiezasOriginales) {
//            f.setColor(super.getColor());
//
//            //aqui hice el triangulo de la oreja
//            int[] xPoints1 = {25, 35, 35};
//            int[] yPoints1 = {8, -2, 8};
//            f.fillPolygon(xPoints1, yPoints1, 3);
//
//            //aqui hice el triangulo de la cara
//            int[] xPoints = {0, 20, 20};
//            int[] yPoints = {20, 5, 20};
//            f.fillPolygon(xPoints, yPoints, 3);
//
//            //rectangulo de la barba
//            f.fillRect(0, 20, 20, 5);
//
//            //aqui hice el rectangulo de la boca
//            int[] xPoints2 = {2, 4, 10, 25};
//            int[] yPoints2 = {33, 30, 27, 24};
////        f.fillPolygon(xPoints2,yPoints2, 4);
//
//            //rectabgulo del cuello
//            f.fillRect(20, 5, 15, 35);
//
//            //circulo de la quija
//            f.fillOval(10, 14, 15, 15);
//
//            //circulo de la panza
//            f.fillOval(15, 35, 25, 30);
//
//            //la base 
//            f.fillArc(2, 52, 48, 40, 0, 180);
//        }
//
    }

}
