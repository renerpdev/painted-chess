/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.util;

import ajedrez.code.game.piezas.Pieza;
import ajedrez.visual.SeleccionarIdioma;
import ajedrez.visual.multiplayer.MultiJugador;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rene
 */
public class Util {

    public static Color negras = Color.BLACK;
    public static Color blancas = Color.decode("#AABEB8");
    public static Color marron = Color.decode("#B86432");
    public static Color carmelita = Color.decode("#FFCE9E");
    public static Color killing = Color.decode("#B72D34");
    public static Color seleccion = Color.decode("#F7C3F3");
    public static Color walking = Color.decode("#3AB68F");
    public static Pieza piezaTemporal = null;
    public static boolean piezaSeleccionada = false;
    public static boolean mostrarPosibleJugada = true;
    public static Pieza piezaCambiada = null;
    public static boolean win = false;
    public static boolean multiusuario = false;
    public static boolean tiempoTerminado = false;
    public static boolean tableroInvertido = false;
    public static int min = 15;
    public static int hour = 0;
    public static MultiJugador multijugador;

    //----------
    //-----------
    public static String idioma[] = new String[200];

    //----------------------------------
    public static void setDafaultOptions() {
        negras = Color.BLACK;
        blancas = Color.decode("#AABEB8");
        marron = Color.decode("#B86432");
        carmelita = Color.decode("#FFCE9E");
        killing = Color.decode("#B72D34");
        seleccion = Color.decode("#F7C3F3");
        walking = Color.decode("#3AB68F");
        piezaTemporal = null;
        piezaSeleccionada = false;
        mostrarPosibleJugada = false;
    }

    public static void setIdioma() {
        try {
            RandomAccessFile ran = new RandomAccessFile(new File("lang\\ES.txt"), "rw");
            String line = ran.readLine();
            int i = 0;
            while (line != null) {
                idioma[i++] = line;
                line = ran.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeleccionarIdioma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SeleccionarIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean validarIP(String ip) {
        if (ip.toLowerCase().equals("localhost")) {
            return true;
        }
        if (ip.contains(".")) {
            ip = ip.replace(".", ",");
            String[] ar = ip.split(",");
            if (ar.length == 4) {
                if (!ar[0].startsWith("0")) {
                    for (int i = 0; i < 4; i++) {
                        try {
                            int n = Integer.parseInt(ar[i]);
                            if (n < 0 || n > 255) {
                                return false;
                            }
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;

    }

    public static void showWarning(String text, String title) {
        Sound.warning();
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.CANCEL_OPTION);
    }

    public static void showWarning(String text) {
        Sound.warning();
        JOptionPane.showMessageDialog(null, text, Util.idioma[14], JOptionPane.CANCEL_OPTION);
    }

    public static void showAdvice(String text, String title) {
        Sound.advice();
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showAdvice(String text) {
        Sound.advice();
        JOptionPane.showMessageDialog(null, text, Util.idioma[14], JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String text, String title) {
        Sound.error();
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showError(String text) {
        Sound.error();
        JOptionPane.showMessageDialog(null, text, Util.idioma[45], JOptionPane.ERROR_MESSAGE);
    }

    public static void showJakeMate(String player) {
        if (win) {
            Sound.win();
            JOptionPane.showMessageDialog(null, Util.idioma[90] + " " + player + " " + Util.idioma[57], Util.idioma[59], JOptionPane.INFORMATION_MESSAGE);

        } else {
            Sound.lost();
            JOptionPane.showMessageDialog(null, Util.idioma[91] + " " + player + " " + Util.idioma[56], Util.idioma[59], JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showJake(String text) {
        Sound.jake();
        JOptionPane.showMessageDialog(null, text, Util.idioma[73], JOptionPane.ERROR_MESSAGE);
    }

    public static int showQuestion(String text, String title) {
        Sound.quest();
        return JOptionPane.showConfirmDialog(null, text, title, JOptionPane.OK_CANCEL_OPTION);
    }

}
