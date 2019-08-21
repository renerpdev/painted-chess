/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game;

import ajedrez.code.util.Coordenada;
import ajedrez.code.util.Util;
import ajedrez.code.game.piezas.Caballo;
import ajedrez.code.game.piezas.Alfil;
import ajedrez.code.game.piezas.Peon;
import ajedrez.code.game.piezas.Dama;
import ajedrez.code.game.piezas.Rey;
import ajedrez.code.game.piezas.Pieza;
import ajedrez.code.game.piezas.Torre;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Rene
 */
public class Tablero extends JPanel {

//    JPanel temp = null;
    Color negro = Util.negras;
    Color blanco = Util.blancas;

    Color carmelita = Util.carmelita;
    Color marron = Util.marron;

    //Casillas...
    Casilla a1;
    Casilla a2;
    Casilla a3;
    Casilla a4;
    Casilla a5;
    Casilla a6;
    Casilla a7;
    Casilla a8;

    Casilla b1;
    Casilla b2;
    Casilla b3;
    Casilla b4;
    Casilla b5;
    Casilla b6;
    Casilla b7;
    Casilla b8;

    Casilla c1;
    Casilla c2;
    Casilla c3;
    Casilla c4;
    Casilla c5;
    Casilla c6;
    Casilla c7;
    Casilla c8;

    Casilla d1;
    Casilla d2;
    Casilla d3;
    Casilla d4;
    Casilla d5;
    Casilla d6;
    Casilla d7;
    Casilla d8;

    Casilla e1;
    Casilla e2;
    Casilla e3;
    Casilla e4;
    Casilla e5;
    Casilla e6;
    Casilla e7;
    Casilla e8;

    Casilla f1;
    Casilla f2;
    Casilla f3;
    Casilla f4;
    Casilla f5;
    Casilla f6;
    Casilla f7;
    Casilla f8;

    Casilla g1;
    Casilla g2;
    Casilla g3;
    Casilla g4;
    Casilla g5;
    Casilla g6;
    Casilla g7;
    Casilla g8;

    Casilla h1;
    Casilla h2;
    Casilla h3;
    Casilla h4;
    Casilla h5;
    Casilla h6;
    Casilla h7;
    Casilla h8;

    public Casilla[][] casillas;

    //piezas negras
    Peon peonN1;
    Peon peonN2;
    Peon peonN3;
    Peon peonN4;
    Peon peonN5;
    Peon peonN6;
    Peon peonN7;
    Peon peonN8;
    Caballo caballoN1;
    Caballo caballoN2;
    Torre torreN1;
    Torre torreN2;
    Alfil alfilN1;
    Alfil alfilN2;
    Dama damaN;
    Rey reyN;

    Pieza piezasNegras[];

    //piezas blancas
    Peon peonB1;
    Peon peonB2;
    Peon peonB3;
    Peon peonB4;
    Peon peonB5;
    Peon peonB6;
    Peon peonB7;
    Peon peonB8;
    Caballo caballoB1;
    Caballo caballoB2;
    Torre torreB1;
    Torre torreB2;
    Alfil alfilB1;
    Alfil alfilB2;
    Dama damaB;
    Rey reyB;

    Pieza piezasBlancas[];

    public Tablero() {
        setLayout(new GridLayout(8, 8));
        initComponents();
        addCasillas();
        setPiezas();

    }

    public void setEmptyCasillas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Casilla c = casillas[i][j];
                c.estaEnElJake = false;
                c.habilitado = false;
                c.tapandoJake = false;
                c.tieneAmenaza = false;
                if (c.pieza != null) {//si tiene pieza
                    c.remove((Component) c.pieza);
                    c.pieza = null;
                }
            }
        }
        updateUI();
    }

    public void setNewBoard() {
        setEmptyCasillas();
        removeCasillas();
        initComponents();

        addCasillas();
    }

    void addCasillas() {

//    {
//        {a8}, {b8}, {c8}, {d8}, {e8}, {f8}, {g8}, {h8},
//        {a7}, {b7}, {c7}, {d7}, {e7}, {f7}, {g7}, {h7},
//        {a6}, {b6}, {c6}, {d6}, {e6}, {f6}, {g6}, {h6},
//        {a5}, {b5}, {c5}, {d5}, {e5}, {f5}, {g5}, {h5},
//        {a4}, {b4}, {c4}, {d4}, {e4}, {f4}, {g4}, {h4},
//        {a3}, {b3}, {c3}, {d3}, {e3}, {f3}, {g3}, {h3},
//        {a2}, {b2}, {c2}, {d2}, {e2}, {f2}, {g2}, {h2},
//        {a1}, {b1}, {c1}, {d1}, {e1}, {f1}, {g1}, {h1},};
        casillas = new Casilla[8][8];

        if (!Util.tableroInvertido) {
            casillas[0][0] = a8;
            casillas[0][1] = b8;
            casillas[0][2] = c8;
            casillas[0][3] = d8;
            casillas[0][4] = e8;
            casillas[0][5] = f8;
            casillas[0][6] = g8;
            casillas[0][7] = h8;

            casillas[1][0] = a7;
            casillas[1][1] = b7;
            casillas[1][2] = c7;
            casillas[1][3] = d7;
            casillas[1][4] = e7;
            casillas[1][5] = f7;
            casillas[1][6] = g7;
            casillas[1][7] = h7;

            casillas[2][0] = a6;
            casillas[2][1] = b6;
            casillas[2][2] = c6;
            casillas[2][3] = d6;
            casillas[2][4] = e6;
            casillas[2][5] = f6;
            casillas[2][6] = g6;
            casillas[2][7] = h6;

            casillas[3][0] = a5;
            casillas[3][1] = b5;
            casillas[3][2] = c5;
            casillas[3][3] = d5;
            casillas[3][4] = e5;
            casillas[3][5] = f5;
            casillas[3][6] = g5;
            casillas[3][7] = h5;

            casillas[4][0] = a4;
            casillas[4][1] = b4;
            casillas[4][2] = c4;
            casillas[4][3] = d4;
            casillas[4][4] = e4;
            casillas[4][5] = f4;
            casillas[4][6] = g4;
            casillas[4][7] = h4;

            casillas[5][0] = a3;
            casillas[5][1] = b3;
            casillas[5][2] = c3;
            casillas[5][3] = d3;
            casillas[5][4] = e3;
            casillas[5][5] = f3;
            casillas[5][6] = g3;
            casillas[5][7] = h3;

            casillas[6][0] = a2;
            casillas[6][1] = b2;
            casillas[6][2] = c2;
            casillas[6][3] = d2;
            casillas[6][4] = e2;
            casillas[6][5] = f2;
            casillas[6][6] = g2;
            casillas[6][7] = h2;

            casillas[7][0] = a1;
            casillas[7][1] = b1;
            casillas[7][2] = c1;
            casillas[7][3] = d1;
            casillas[7][4] = e1;
            casillas[7][5] = f1;
            casillas[7][6] = g1;
            casillas[7][7] = h1;

        } else {
            casillas[0][0] = h1;
            casillas[0][1] = g1;
            casillas[0][2] = f1;
            casillas[0][3] = e1;
            casillas[0][4] = d1;
            casillas[0][5] = c1;
            casillas[0][6] = b1;
            casillas[0][7] = a1;

            casillas[1][0] = h2;
            casillas[1][1] = g2;
            casillas[1][2] = f2;
            casillas[1][3] = e2;
            casillas[1][4] = d2;
            casillas[1][5] = c2;
            casillas[1][6] = b2;
            casillas[1][7] = a2;

            casillas[2][0] = h3;
            casillas[2][1] = g3;
            casillas[2][2] = f3;
            casillas[2][3] = e3;
            casillas[2][4] = d3;
            casillas[2][5] = c3;
            casillas[2][6] = b3;
            casillas[2][7] = a3;

            casillas[3][0] = h4;
            casillas[3][1] = g4;
            casillas[3][2] = f4;
            casillas[3][3] = e4;
            casillas[3][4] = d4;
            casillas[3][5] = c4;
            casillas[3][6] = b4;
            casillas[3][7] = a4;

            casillas[4][0] = h5;
            casillas[4][1] = g5;
            casillas[4][2] = f5;
            casillas[4][3] = e5;
            casillas[4][4] = d5;
            casillas[4][5] = c5;
            casillas[4][6] = b5;
            casillas[4][7] = a5;

            casillas[5][0] = h6;
            casillas[5][1] = g6;
            casillas[5][2] = f6;
            casillas[5][3] = e6;
            casillas[5][4] = d6;
            casillas[5][5] = c6;
            casillas[5][6] = b6;
            casillas[5][7] = a6;

            casillas[6][0] = h7;
            casillas[6][1] = g7;
            casillas[6][2] = f7;
            casillas[6][3] = e7;
            casillas[6][4] = d7;
            casillas[6][5] = c7;
            casillas[6][6] = b7;
            casillas[6][7] = a7;

            casillas[7][0] = h8;
            casillas[7][1] = g8;
            casillas[7][2] = f8;
            casillas[7][3] = e8;
            casillas[7][4] = d8;
            casillas[7][5] = c8;
            casillas[7][6] = b8;
            casillas[7][7] = a8;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                add(casillas[i][j]);
            }
        }

        setEmptyCasillas();
    }

    void removeCasillas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                remove(casillas[i][j]);
            }
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Pieza[] getPiezasNegras() {
        return piezasNegras;
    }

    public Pieza[] getPiezasBlancas() {
        return piezasBlancas;
    }

    public Coordenada getCoordenada(Casilla c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].id.equals(c.id)) {
                    return new Coordenada(i, j);
                }
            }
        }
        return null;
    }
    
     public Coordenada getCoordenada(String c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].id.equals(c)) {
                    return new Coordenada(i, j);
                }
            }
        }
        return null;
    }
   
    void setPiezas(LinkedList<Pieza> pb, LinkedList<Pieza> pn) {
        for (int i = 0; i < pb.size(); i++) {
            Pieza pi = pb.get(i);
            Coordenada coord = getCoordenada(pi.casilla);
            casillas[coord.i][coord.j].add(pi);
        }
        for (int i = 0; i < pn.size(); i++) {
            Pieza pi = pn.get(i);
            Coordenada coord = getCoordenada(pi.casilla);
            casillas[coord.i][coord.j].add(pi);
        }
        updateUI();
    }

    void initComponents() {

        a1 = new Casilla(Util.marron, this, "a1");
        a2 = new Casilla(Util.carmelita, this, "a2");
        a3 = new Casilla(Util.marron, this, "a3");
        a4 = new Casilla(Util.carmelita, this, "a4");
        a5 = new Casilla(Util.marron, this, "a5");
        a6 = new Casilla(Util.carmelita, this, "a6");
        a7 = new Casilla(Util.marron, this, "a7");
        a8 = new Casilla(Util.carmelita, this, "a8");

        b1 = new Casilla(Util.carmelita, this, "b1");
        b2 = new Casilla(Util.marron, this, "b2");
        b3 = new Casilla(Util.carmelita, this, "b3");
        b4 = new Casilla(Util.marron, this, "b4");
        b5 = new Casilla(Util.carmelita, this, "b5");
        b6 = new Casilla(Util.marron, this, "b6");
        b7 = new Casilla(Util.carmelita, this, "b7");
        b8 = new Casilla(Util.marron, this, "b8");

        c1 = new Casilla(Util.marron, this, "c1");
        c2 = new Casilla(Util.carmelita, this, "c2");
        c3 = new Casilla(Util.marron, this, "c3");
        c4 = new Casilla(Util.carmelita, this, "c4");
        c5 = new Casilla(Util.marron, this, "c5");
        c6 = new Casilla(Util.carmelita, this, "c6");
        c7 = new Casilla(Util.marron, this, "c7");
        c8 = new Casilla(Util.carmelita, this, "c8");

        d1 = new Casilla(Util.carmelita, this, "d1");
        d2 = new Casilla(Util.marron, this, "d2");
        d3 = new Casilla(Util.carmelita, this, "d3");
        d4 = new Casilla(Util.marron, this, "d4");
        d5 = new Casilla(Util.carmelita, this, "d5");
        d6 = new Casilla(Util.marron, this, "d6");
        d7 = new Casilla(Util.carmelita, this, "d7");
        d8 = new Casilla(Util.marron, this, "d8");

        e1 = new Casilla(Util.marron, this, "e1");
        e2 = new Casilla(Util.carmelita, this, "e2");
        e3 = new Casilla(Util.marron, this, "e3");
        e4 = new Casilla(Util.carmelita, this, "e4");
        e5 = new Casilla(Util.marron, this, "e5");
        e6 = new Casilla(Util.carmelita, this, "e6");
        e7 = new Casilla(Util.marron, this, "e7");
        e8 = new Casilla(Util.carmelita, this, "e8");

        f1 = new Casilla(Util.carmelita, this, "f1");
        f2 = new Casilla(Util.marron, this, "f2");
        f3 = new Casilla(Util.carmelita, this, "f3");
        f4 = new Casilla(Util.marron, this, "f4");
        f5 = new Casilla(Util.carmelita, this, "f5");
        f6 = new Casilla(Util.marron, this, "f6");
        f7 = new Casilla(Util.carmelita, this, "f7");
        f8 = new Casilla(Util.marron, this, "f8");

        g1 = new Casilla(Util.marron, this, "g1");
        g2 = new Casilla(Util.carmelita, this, "g2");
        g3 = new Casilla(Util.marron, this, "g3");
        g4 = new Casilla(Util.carmelita, this, "g4");
        g5 = new Casilla(Util.marron, this, "g5");
        g6 = new Casilla(Util.carmelita, this, "g6");
        g7 = new Casilla(Util.marron, this, "g7");
        g8 = new Casilla(Util.carmelita, this, "g8");

        h1 = new Casilla(Util.carmelita, this, "h1");
        h2 = new Casilla(Util.marron, this, "h2");
        h3 = new Casilla(Util.carmelita, this, "h3");
        h4 = new Casilla(Util.marron, this, "h4");
        h5 = new Casilla(Util.carmelita, this, "h5");
        h6 = new Casilla(Util.marron, this, "h6");
        h7 = new Casilla(Util.carmelita, this, "h7");
        h8 = new Casilla(Util.marron, this, "h8");

    }

    public void setPiezas() {

        if (!Util.tableroInvertido) {

            peonN1 = new Peon(negro, a7);
            peonN2 = new Peon(negro, b7);
            peonN3 = new Peon(negro, c7);
            peonN4 = new Peon(negro, d7);
            peonN5 = new Peon(negro, e7);
            peonN6 = new Peon(negro, f7);
            peonN7 = new Peon(negro, g7);
            peonN8 = new Peon(negro, h7);
            caballoN1 = new Caballo(negro, b8);
            caballoN2 = new Caballo(negro, g8);
            torreN1 = new Torre(negro, a8);
            torreN2 = new Torre(negro, h8);
            alfilN1 = new Alfil(negro, c8);
            alfilN2 = new Alfil(negro, f8);
            damaN = new Dama(negro, d8);
            reyN = new Rey(negro, e8);

            //piezas blancas
            peonB1 = new Peon(blanco, a2);
            peonB2 = new Peon(blanco, b2);
            peonB3 = new Peon(blanco, c2);
            peonB4 = new Peon(blanco, d2);
            peonB5 = new Peon(blanco, e2);
            peonB6 = new Peon(blanco, f2);
            peonB7 = new Peon(blanco, g2);
            peonB8 = new Peon(blanco, h2);
            caballoB1 = new Caballo(blanco, b1);
            caballoB2 = new Caballo(blanco, g1);
            torreB1 = new Torre(blanco, a1);
            torreB2 = new Torre(blanco, h1);
            alfilB1 = new Alfil(blanco, c1);
            alfilB2 = new Alfil(blanco, f1);
            damaB = new Dama(blanco, d1);
            reyB = new Rey(blanco, e1);

        } else {

            peonN1 = new Peon(negro, a7);
            peonN2 = new Peon(negro, b7);
            peonN3 = new Peon(negro, c7);
            peonN4 = new Peon(negro, d7);
            peonN5 = new Peon(negro, e7);
            peonN6 = new Peon(negro, f7);
            peonN7 = new Peon(negro, g7);
            peonN8 = new Peon(negro, h7);
            caballoN1 = new Caballo(negro, b8);
            caballoN2 = new Caballo(negro, g8);
            torreN1 = new Torre(negro, a8);
            torreN2 = new Torre(negro, h8);
            alfilN1 = new Alfil(negro, c8);
            alfilN2 = new Alfil(negro, f8);
            damaN = new Dama(negro, d8);
            reyN = new Rey(negro, e8);

            //piezas blancas
            peonB1 = new Peon(blanco, a2);
            peonB2 = new Peon(blanco, b2);
            peonB3 = new Peon(blanco, c2);
            peonB4 = new Peon(blanco, d2);
            peonB5 = new Peon(blanco, e2);
            peonB6 = new Peon(blanco, f2);
            peonB7 = new Peon(blanco, g2);
            peonB8 = new Peon(blanco, h2);
            caballoB1 = new Caballo(blanco, b1);
            caballoB2 = new Caballo(blanco, g1);
            torreB1 = new Torre(blanco, a1);
            torreB2 = new Torre(blanco, h1);
            alfilB1 = new Alfil(blanco, c1);
            alfilB2 = new Alfil(blanco, f1);
            damaB = new Dama(blanco, d1);
            reyB = new Rey(blanco, e1);
        }

        piezasNegras = new Pieza[]{
            peonN1, peonN2, peonN3, peonN4, peonN5, peonN6, peonN7, peonN8,
            torreN1, caballoN1, alfilN1, damaN, reyN, alfilN2, caballoN2, torreN2
        };

        piezasBlancas = new Pieza[]{
            peonB1, peonB2, peonB3, peonB4, peonB5, peonB6, peonB7, peonB8,
            torreB1, caballoB1, alfilB1, damaB, reyB, alfilB2, caballoB2, torreB2
        };

        //NEGRAS
        peonN1.casilla.add(peonN1);
        peonN2.casilla.add(peonN2);
        peonN3.casilla.add(peonN3);
        peonN4.casilla.add(peonN4);
        peonN5.casilla.add(peonN5);
        peonN6.casilla.add(peonN6);
        peonN7.casilla.add(peonN7);
        peonN8.casilla.add(peonN8);
        caballoN1.casilla.add(caballoN1);
        caballoN2.casilla.add(caballoN2);
        alfilN1.casilla.add(alfilN1);
        alfilN2.casilla.add(alfilN2);
        torreN1.casilla.add(torreN1);
        torreN2.casilla.add(torreN2);
        damaN.casilla.add(damaN);
        reyN.casilla.add(reyN);

        //BLANCAS
        peonB1.casilla.add(peonB1);
        peonB2.casilla.add(peonB2);
        peonB3.casilla.add(peonB3);
        peonB4.casilla.add(peonB4);
        peonB5.casilla.add(peonB5);
        peonB6.casilla.add(peonB6);
        peonB7.casilla.add(peonB7);
        peonB8.casilla.add(peonB8);
        caballoB1.casilla.add(caballoB1);
        caballoB2.casilla.add(caballoB2);
        alfilB1.casilla.add(alfilB1);
        alfilB2.casilla.add(alfilB2);
        torreB1.casilla.add(torreB1);
        torreB2.casilla.add(torreB2);
        damaB.casilla.add(damaB);
        reyB.casilla.add(reyB);

        for (int i = 0; i < 16; i++) {
            piezasBlancas[i].habilitada = false;
            piezasNegras[i].habilitada = false;
        }

        updateUI();
    }

    public Casilla getCasilla(String id) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].id.equals(id)) {
                    return casillas[i][j];
                }
            }
        }
        return null;
    }
    
   

    public void setColorToCells() {
        //blancas
        a8.setBackground(carmelita);
        c8.setBackground(carmelita);
        e8.setBackground(carmelita);
        g8.setBackground(carmelita);
        b7.setBackground(carmelita);
        d7.setBackground(carmelita);
        f7.setBackground(carmelita);
        h7.setBackground(carmelita);
        a6.setBackground(carmelita);
        c6.setBackground(carmelita);
        e6.setBackground(carmelita);
        g6.setBackground(carmelita);
        b5.setBackground(carmelita);
        d5.setBackground(carmelita);
        f5.setBackground(carmelita);
        h5.setBackground(carmelita);
        a4.setBackground(carmelita);
        c4.setBackground(carmelita);
        e4.setBackground(carmelita);
        g4.setBackground(carmelita);
        b3.setBackground(carmelita);
        d3.setBackground(carmelita);
        f3.setBackground(carmelita);
        h3.setBackground(carmelita);
        a2.setBackground(carmelita);
        c2.setBackground(carmelita);
        e2.setBackground(carmelita);
        g2.setBackground(carmelita);
        b1.setBackground(carmelita);
        d1.setBackground(carmelita);
        f1.setBackground(carmelita);
        h1.setBackground(carmelita);

        //negras
        b8.setBackground(marron);
        d8.setBackground(marron);
        f8.setBackground(marron);
        h8.setBackground(marron);
        a7.setBackground(marron);
        c7.setBackground(marron);
        e7.setBackground(marron);
        g7.setBackground(marron);
        b6.setBackground(marron);
        d6.setBackground(marron);
        f6.setBackground(marron);
        h6.setBackground(marron);
        a5.setBackground(marron);
        c5.setBackground(marron);
        e5.setBackground(marron);
        g5.setBackground(marron);
        b4.setBackground(marron);
        d4.setBackground(marron);
        f4.setBackground(marron);
        h4.setBackground(marron);
        a3.setBackground(marron);
        e3.setBackground(marron);
        b4.setBackground(marron);
        g3.setBackground(marron);
        c3.setBackground(marron);
        b2.setBackground(marron);
        d2.setBackground(marron);
        f2.setBackground(marron);
        h2.setBackground(marron);
        a1.setBackground(marron);
        c1.setBackground(marron);
        e1.setBackground(marron);
        g1.setBackground(marron);
    }

    public void habilitarCasillas(boolean habilitar) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casillas[i][j].habilitado = habilitar;
            }
        }
    }

}
