/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.util;

import java.io.Serializable;

/**
 *
 * @author Rene
 */
public class Logger implements Serializable {

    public String j1Nombre;
    public String j2Nombre;
    public String[] j1_moves;
    public String[] j2_moves;

    public Logger(String j1Nombre, String j2Nombre, String[] j1_moves, String[] j2_moves) {
        this.j1Nombre = j1Nombre;
        this.j2Nombre = j2Nombre;
        this.j1_moves = j1_moves;
        this.j2_moves = j2_moves;
    }

    public String getJ1Nombre() {
        return j1Nombre;
    }

    public String getJ2Nombre() {
        return j2Nombre;
    }

    public String[] getJ1_moves() {
        return j1_moves;
    }

    public String[] getJ2_moves() {
        return j2_moves;
    }

}
