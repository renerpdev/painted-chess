/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game.piezas;

import ajedrez.code.game.Casilla;
import ajedrez.code.game.Jugador;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Rene
 */
public class Pieza extends JPanel {

    public Color color;
    public Casilla casilla;
    public Casilla casillaInicio;
    public boolean habilitada = false;
    public Jugador jugador;
    public boolean seMovio = false;
    public String toolTip = "";
    public boolean atacandoRey = false;
    public boolean puedeCaminar = false;

    public Pieza(Color color, Casilla casilla) {
        this.color = color;
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(50, 75));
        casillaInicio = casilla;
        this.casilla = casilla;
    }

    public Color getColor() {
        return color;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla, MouseListener event) {
        this.casilla = casilla;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

}
