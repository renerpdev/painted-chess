/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.util;

import ajedrez.code.game.Casilla;
import ajedrez.code.game.Jugador;
import java.io.Serializable;

/**
 *
 * @author Rene
 */
public class CurrentData implements Serializable {

    public Jugador j1;
    public Jugador j2;
    public Jugador jact;
    public Casilla peonAlPasoN, peonAlPasoB;
    public String logger1, logger2;
    public boolean mostrarJugada;
    public boolean tableroInvertido;
    public boolean tiempoTerminado;
    public int minMax, hourMax;

    public CurrentData(Jugador j1, Jugador j2, Jugador jact, String logger1, String logger2, boolean mostrarJugada, boolean tableroInvertido, boolean tiempoTerminado, int minMax, int hourMax, Casilla peonAlPasoN, Casilla peonAlPasoB) {
        this.j1 = j1;
        this.j2 = j2;
        this.jact = jact;
        this.logger1 = logger1;
        this.logger2 = logger2;
        this.mostrarJugada = mostrarJugada;
        this.tableroInvertido = tableroInvertido;
        this.tiempoTerminado = tiempoTerminado;
        this.minMax = minMax;
        this.hourMax = hourMax;
        this.peonAlPasoB = peonAlPasoB;
        this.peonAlPasoN = peonAlPasoN;
//        if (jact.nombre.equals(j1.nombre)) {
//            System.out.println("j1");
//            j2.movimientos-=2;
//        } else {
//            System.out.println("j2");
//            j1.movimientos-=2;
//        }

    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public Jugador getJact() {
        return jact;
    }

}
