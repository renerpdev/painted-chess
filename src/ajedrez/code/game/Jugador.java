/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game;

import ajedrez.code.game.piezas.Rey;
import ajedrez.code.game.piezas.Pieza;
import java.awt.Color;
import java.awt.Cursor;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Rene
 */
public class Jugador implements Serializable {

    public String nombre;
    public LinkedList<Pieza> piezas;
    public Color color;
    public int piezasComidas = 0;
    public boolean PC, juegaPorRed;
    public Rey rey;
    public int seg, min, hour;
    int movimientos;

    public Jugador(String nombre, Color color, boolean pc) {
        this.nombre = nombre;
        this.color = color;
        piezas = new LinkedList<Pieza>();
        PC = pc;
        seg = 0;
        min = 0;
        hour = 0;
        movimientos = 1;
        juegaPorRed = false;

    }

    public Jugador(String nombre, Color color, boolean pc, boolean juegaPorRed) {
        this.nombre = nombre;
        this.color = color;
        piezas = new LinkedList<Pieza>();
        PC = pc;
        seg = 0;
        min = 0;
        hour = 0;
        movimientos = 1;
        this.juegaPorRed = juegaPorRed;
    }

    public void perderPieza(Pieza p) {
        piezas.remove(p);

    }

    public void setTime(int seg, int min, int hour) {
        this.min = min;
        this.seg = seg;
        this.hour = hour;

    }

    public void comerPieza() {
        piezasComidas++;
    }

    public boolean isPC() {
        return PC;
    }

    public void setPC(boolean PC) {
        this.PC = PC;
    }

    public void habilitarPiezas(boolean b) {
        for (int i = 0; i < piezas.size(); i++) {
            piezas.get(i).setHabilitada(b);
            piezas.get(i).setCursor(new Cursor(0));
            piezas.get(i).puedeCaminar = false;
        }
    }

    public void setPiezas(Pieza[] p) {
        for (int i = 0; i < 16; i++) {
            p[i].setJugador(this);
            if (p[i] instanceof Rey) {
                rey = (Rey) p[i];
            }
            piezas.add(p[i]);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPiezas() {
        return piezas.size();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPiezasComidas() {
        return piezasComidas;
    }

    public void setPiezasComidas(int piezasComidas) {
        this.piezasComidas = piezasComidas;
    }

}
