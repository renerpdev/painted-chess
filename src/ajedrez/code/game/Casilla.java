/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game;

import ajedrez.code.game.piezas.Pieza;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Rene
 */
public class Casilla extends JPanel {

    public Pieza pieza = null;
    public Color color;
    public Tablero tablero;
    public boolean habilitado = false;
    public boolean tieneAmenaza = false;
    public boolean estaEnElJake = false;
    public boolean tapandoJake = false;
    public String id;

    public Casilla(Color c, Tablero t, String id) {
        color = c;
        tablero = t;
        setBackground(color);
        setBorder(new BevelBorder(2, Color.LIGHT_GRAY, Color.MAGENTA));
        this.id = id;
        addMouseListener(null);
        setLayout(new GridBagLayout());
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
        add(pieza);
    }

    public Pieza getPieza() {
        return pieza;
    }

    public Color getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    //@Override
    public void add(Pieza p) {
        pieza = p;
        add((Component) p);
        pieza.casilla = this;
    }

    public void clear() {
        pieza = null;
    }

    public void remove(Pieza p) {
        if (getComponentCount() != 0) {
            remove((Component) p);
            pieza = null;
        }

    }

}
