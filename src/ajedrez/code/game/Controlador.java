/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game;

import ajedrez.visual.game_interface.SeleccionarNuevaPieza;
import ajedrez.visual.game_interface.Clock;
import ajedrez.visual.game_interface.AboutUs;
import ajedrez.visual.multiplayer.MultiChat;
import ajedrez.visual.multiplayer.MultiJugador;
import ajedrez.code.conection.ConexionJDBC;
import ajedrez.code.conection.DatosConexion;
import ajedrez.code.util.Moves;
import ajedrez.code.util.Coordenada;
import ajedrez.code.util.CurrentData;
import ajedrez.code.util.Util;
import ajedrez.code.util.Sound;
import ajedrez.code.util.Logger;
import ajedrez.code.game.piezas.Caballo;
import ajedrez.code.game.piezas.Alfil;
import ajedrez.code.game.piezas.Peon;
import ajedrez.code.game.piezas.Dama;
import ajedrez.code.game.piezas.Rey;
import ajedrez.code.game.piezas.Pieza;
import ajedrez.code.game.piezas.Torre;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import ajedrez.visual.game_interface.Interfaz;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import java.awt.Cursor;
import java.util.LinkedList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sourceforge.napkinlaf.NapkinLookAndFeel;
import ajedrez.visual.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Rene
 */
public final class Controlador extends Thread {

    public Tablero tablero;
    public Jugador jugador1;
    public Jugador jugador2;
    public static JTextArea logger1, logger2;
    public Interfaz frame;
    public boolean saved = true;
    public Jugador jugadorActual;
    public int piezasAtacandoAlRey = 0;
    public Casilla casillaPeonAlpasoN = null;
    public Casilla casillaPeonAlpasoB = null;
    public LinkedList<Coordenada> caminoDelJake = new LinkedList<>();
    Moves movimientos;
    Logger logLoaded = null;
    public Clock j1Timer, j2Timer;
    String title = null;
    File fileOpened = null;
    public ConexionJDBC conexion;
    public MultiChat chat;
    boolean gotoInicio = false;
    String jugadorEstaPC = "";
    DatosConexion data;

    public Controlador(Jugador jugador1, Jugador jugador2, Interfaz frame, String address, ConexionJDBC conexion, DatosConexion data) {
        Sound.init();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugadorActual = jugador1;
        chat = new MultiChat(this);

        try {
            UIManager.setLookAndFeel(new NapkinLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Util.showError(ex.toString());
        }
        tablero = new Tablero();

        logger1 = new JTextArea();
        logger2 = new JTextArea();
        this.frame = frame;
        refreshFrame();
        setEvents();
        movimientos = new Moves(this);
        frame.setCursor(new Cursor(0));

        if (conexion != null) {
            jugadorEstaPC = ((jugador1.juegaPorRed) ? jugador2.nombre : jugador1.nombre);
            this.data = data;
            String cs = ((!data.esServidor) ? Util.idioma[113] : Util.idioma[114]);
            frame.setTitle(frame.getTitle() + " - " + cs);
//            chat.setVisible(true);
            this.conexion = conexion;
            frame.jMenuItem2.setVisible(false);
            frame.jMenuItem11.setVisible(false);

        }
        if (address == null) {
            refreshPlayers();
        } else {
            fileOpened = new File(address);
        }

        startGame();

    }

    public void setTextoChat(String g) {
        try {
            ResultSet rs2 = conexion.ejecutarConsulta("UPDATE controlador SET chat='" + jugadorEstaPC + ": " + g + "'");
        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            Util.showError(ex.toString());
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    void refreshPlayers() {
        jugador1.setPiezas(tablero.piezasBlancas);
        frame.j1Nombre.setFont(new Font("Segoe UI", 1, 14));
        frame.j2Nombre.setFont(new Font("Segoe UI", 1, 14));
        jugador2.setPiezas(tablero.piezasNegras);
        jugadorActual = jugador2;
        next();
    }

    void setActualPlayer() {
        frame.j1Nombre.setText(getJugador1().getNombre());
        frame.j2Nombre.setText(getJugador2().getNombre());
        if (jugadorActual.nombre.equals(jugador1.nombre)) {
            j2Timer.play();
            j1Timer.pause();
            frame.j2Nombre.setForeground(Util.walking);
            frame.j1Nombre.setForeground(Util.killing);
            casillaPeonAlpasoN = null;
            jugadorActual = jugador2;
            if (!jugadorActual.isPC()) {
                jugador2.habilitarPiezas(true);
            }

            jugador1.habilitarPiezas(false);

        } else {
            j2Timer.pause();
            j1Timer.play();
            frame.j1Nombre.setForeground(Util.walking);
            frame.j2Nombre.setForeground(Util.killing);
            casillaPeonAlpasoB = null;
            jugadorActual = jugador1;
            if (!jugadorActual.isPC()) {
                jugador1.habilitarPiezas(true);
            }

            jugador2.habilitarPiezas(false);

        }

        tablero.setColorToCells();
    }

    void refreshFrame() {
        j1Timer = (Clock) frame.j1Timer;
        j2Timer = (Clock) frame.j2Timer;
        j1Timer.setTimer();
        j2Timer.setTimer();
        jugadorActual = jugador2;
        setActualPlayer();

        frame.j1Comidas.setText("" + getJugador1().getPiezasComidas());
        frame.j1color.setBackground(getJugador1().getColor());
        frame.j1piezas.setText("" + getJugador1().getCantPiezas());
        setSavedGame(true);
        frame.j2Comidas.setText("" + getJugador2().getPiezasComidas());
        frame.j2color.setBackground(getJugador2().getColor());
        frame.j2piezas.setText("" + getJugador2().getCantPiezas());

        frame.numeraciones2.boardArea.add(tablero, BorderLayout.CENTER);
        logger1 = frame.log1;
        logger2 = frame.log2;

//        frame.add(logger,BorderLayout.EAST);
    }

    File createDefaultDir_Logger() {
        JFileChooser fc = new JFileChooser();
        File data = new File(fc.getCurrentDirectory().getPath() + "\\Painted Chess - Data");
        File logg = new File(data.getPath() + "\\Logger");

        if (!data.exists()) {
            data.mkdir();
        }
        if (!logg.exists()) {
            logg.mkdir();
        }

        return logg;
    }

    File createDefaultDir_Save() {
        JFileChooser fc = new JFileChooser();
        File data = new File(fc.getCurrentDirectory().getPath() + "\\Painted Chess - Data");
        File save = new File(data.getPath() + "\\Saves");

        if (!data.exists()) {
            data.mkdir();
        }
        if (!save.exists()) {
            save.mkdir();
        }

        return save;
    }

    public void exportLogger() {
        File logg = createDefaultDir_Logger();
        try {
            String fileName = "\\" + jugador1.nombre + "-" + jugador2.nombre + "(Logger).pchl";
            File file = new File(logg.getPath() + fileName);

            if (file != null) {
                if (fileOpened != null) {
                    String nameFO = fileOpened.getName();
                    nameFO = nameFO.replace(".", ",");
                    String ar[] = nameFO.split(",");
                    String nameF = file.getName();
                    String addrF = file.getAbsolutePath();
                    addrF = addrF.substring(0, addrF.length() - nameF.length());
                    file = new File(addrF + ar[0] + ".pchl");
                }
                FileOutputStream fos = new FileOutputStream(file);
                if (fos != null) {
                    ObjectOutputStream ob = new ObjectOutputStream(fos);
                    ob.writeObject(new Logger(jugador1.nombre, jugador2.nombre, logger1.getText().split("\n"), logger2.getText().split("\n")));
                }

            }
            Util.showAdvice(Util.idioma[40] + ":\n" + file.getAbsolutePath(), Util.idioma[14]);
            frame.jMenuItem11.setEnabled(false);

        } catch (FileNotFoundException ex) {
            Util.showError(ex.toString());
        } catch (IOException ex) {
            Util.showError(ex.toString());
        } catch (NullPointerException ex) {
            Util.showError(ex.toString());

        }
    }

    public void newGame() {
        if (!saved) {//si no esta salvado el juego
            int quest = Util.showQuestion(Util.idioma[50], Util.idioma[17]);
            if (quest == 0) {
                endGame();
                frame.dispose();
                try {
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                    Util.setDafaultOptions();
                    new NuevoJuego();
                } catch (UnsupportedLookAndFeelException ex) {
                    Util.showError(ex.toString());
                }
            }
        } else {
            endGame();
            frame.dispose();
            try {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
                Util.setDafaultOptions();
                new NuevoJuego();
            } catch (UnsupportedLookAndFeelException ex) {
                Util.showError(ex.toString());
            }
        }
    }

    public void resetGame() {
        if (!saved) {//si no esta salvado el juego
            int quest = Util.showQuestion(Util.idioma[85], Util.idioma[17]);
            if (quest == 0) {
                if (conexion != null) {
                    try {
                        ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET reset='" + true + "'");
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    reset();
                }

            }
        } else {
            if (conexion != null) {
                try {
                    ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET reset='" + true + "'");
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                reset();
            }

        }

    }

    void reset() {
        Sound.resetGame();
        frame.jMenuItem1.setVisible(false);
        frame.jMenuItem17.setVisible(true);
        frame.jMenuItem17.setEnabled(true);
        frame.jMenuItem11.setEnabled(false);
        piezasAtacandoAlRey = 0;
        casillaPeonAlpasoN = null;
        casillaPeonAlpasoB = null;
        logger1.setText("");
        logger2.setText("");
        setSavedGame(true);
        Util.tiempoTerminado = false;
        Util.piezaTemporal = null;
        Util.piezaSeleccionada = false;
        Util.piezaCambiada = null;
        Util.win = false;
        j1Timer.reSet();
        j2Timer.reSet();
        tablero.setNewBoard();
        tablero.setPiezas();
        setEvents();
        String n1 = jugador1.getNombre();
        String n2 = jugador2.getNombre();
        boolean pc1 = jugador1.PC;
        boolean pc2 = jugador2.PC;
        boolean multijug1 = jugador1.juegaPorRed;
        boolean multijug2 = jugador2.juegaPorRed;
        jugador1 = new Jugador(n1, Util.blancas, pc1);
        jugador2 = new Jugador(n2, Util.blancas, pc2);
        jugador1.juegaPorRed = multijug1;
        jugador2.juegaPorRed = multijug2;
        jugador1.setPiezas(tablero.piezasBlancas);
        jugador2.setPiezas(tablero.piezasNegras);
        jugadorActual = jugador2;
        tablero.updateUI();
        next();

        if (conexion != null) {
            try {
                ResultSet rs = conexion.ejecutarConsulta("UPDATE data SET casilla_inicio='" + "" + "',casilla_fin='" + "" + "',enrosque='" + -1 + "',peonalpaso='" + "" + "',casillacomida_pap='" + "" + "',piezaenmeta='" + "" + "',piezacambieda='" + "" + "',min1='" + -1 + "',seg1='" + -1 + "',hor1='" + -1 + "',min2='" + -1 + "',seg2='" + -1 + "',hor2='" + -1 + "'");
                rs = conexion.ejecutarConsulta("UPDATE controlador SET pausa='" + false + "',play='" + false + "',juego_terminado='" + false + "',reset='" + false + "',chat='" + "" + "',logger='" + "" + "',jug1_semovio='" + false + "',jug2_semovio='" + false + "'");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void goToStartMenu() {
        if (conexion != null) {//si esta conectado por la red
            if (Util.showQuestion(Util.idioma[110], Util.idioma[28]) == 0) {
                gotoInicio = true;
                deleteAllTables();
                endGame();
                frame.dispose();
                try {
                    UIManager.setLookAndFeel(new NapkinLookAndFeel());
                    Util.setDafaultOptions();
                    new StartMenu();
                } catch (UnsupportedLookAndFeelException ex) {
                    Util.showError(ex.toString());
                }
                stop();
            }
        } else {
            if (!saved) {//si no esta salvado el juego
                int quest = Util.showQuestion(Util.idioma[83], Util.idioma[82]);
                if (quest == 0) {
                    endGame();
                    frame.dispose();
                    try {
                        UIManager.setLookAndFeel(new NapkinLookAndFeel());
                        Util.setDafaultOptions();
                        new StartMenu();
                    } catch (UnsupportedLookAndFeelException ex) {
                        Util.showError(ex.toString());
                    }
                    stop();

                }
            } else {
                endGame();
                frame.dispose();
                try {
                    UIManager.setLookAndFeel(new NapkinLookAndFeel());
                    Util.setDafaultOptions();
                    new StartMenu();
                } catch (UnsupportedLookAndFeelException ex) {
                    Util.showError(ex.toString());
                }
                stop();

            }
        }
    }

    public void showCopyRight() {
        Sound.advice();
        new AboutUs(frame, true).setVisible(true);
    }

    public void loadLogger() {
        if (!saved) {//si no esta salvado el juego
            int quest = Util.showQuestion(Util.idioma[42], Util.idioma[43]);
            if (quest == 0) {
                load();
            }
        } else {
            load();
        }
    }

    public void load() {
        JFileChooser fc = new JFileChooser();
        FileFilter ff = new FileNameExtensionFilter("Painted Chess Logger", "pchl");
        fc.setFileFilter(ff);
        File dir = new File(fc.getCurrentDirectory().getPath() + "\\Painted Chess - Data\\Logger\\");
        fc.setCurrentDirectory(dir);
        int value = fc.showOpenDialog(frame);
        if (value == 0) {
            frame.setCursor(new Cursor(3));
            File file = fc.getSelectedFile();
            if (file != null) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    if (fis != null) {
                        ObjectInputStream obi = new ObjectInputStream(fis);

                        logLoaded = (Logger) obi.readObject();
                        frame.jButton3.setVisible(true);
                        frame.jButton3.setEnabled(false);
                        frame.jButton1.setVisible(true);
                        frame.jMenuItem11.setEnabled(false);
                        frame.jMenuItem2.setEnabled(false);
                        frame.j1Timer.setVisible(false);
                        frame.j2Timer.setVisible(false);
                        frame.j1Nombre.setText(logLoaded.j1Nombre);
                        frame.j2Nombre.setText(logLoaded.j2Nombre);
                        tablero.setNewBoard();
                        tablero.setPiezas();
                        setTitleToFrame(file.getAbsolutePath());
                        logger1.setText("");
                        logger2.setText("");

                    }

                } catch (FileNotFoundException ex) {
                    Util.showError(Util.idioma[44]);
                } catch (IOException ex) {
                    Util.showError(Util.idioma[44]);
                } catch (ClassNotFoundException ex) {
                    Util.showError(Util.idioma[44]);
                } finally {
                    frame.setCursor(new Cursor(0));
                }
            }
        }

    }

//    public void nextPlay() {
//        String txt = "", play = "";
//        if (logLoaded.index < logLoaded.play.length - 1) {
//            logLoaded.index++;
//            for (int i = 0; i < logLoaded.index; i++) {
//                txt += logLoaded.play[i] + "\n";
//            }
//            play = logLoaded.play[logLoaded.index].split(" ")[1];
//            if (!txt.equals("")) {
//                logger1.setText(txt);
//
//            }
//            if (logLoaded.index == logLoaded.play.length - 1) {
//                frame.jButton1.setEnabled(false);
//            } else {
//                frame.jButton1.setEnabled(true);
//                frame.jButton3.setEnabled(true);
//            }
//
//        }
//
//    }
//    public void prevPlay() {
//        String txt = "", play = "";
//
//        if (logLoaded.index > 0) {
//            logLoaded.index--;
//            for (int i = 0; i < logLoaded.index; i++) {
//                txt += logLoaded.play[i] + "\n";
//            }
//            play = logLoaded.play[logLoaded.index].split(" ")[1];
//            if (!txt.equals("")) {
//                logger1.setText(txt);
//            }
//            if (logLoaded.index == 0) {
//                frame.jButton3.setEnabled(false);
//            } else {
//                frame.jButton3.setEnabled(true);
//                frame.jButton1.setEnabled(true);
//            }
//
//        }
//
//    }
    public void saveGame() {
        if (!saved) {
            File file = createDefaultDir_Save();
            try {
                String fileName = "\\" + jugador1.nombre + "-" + jugador2.nombre + "(save).pchs";
                file = new File(file.getAbsolutePath() + fileName);
            } catch (NullPointerException ex) {
                Util.showError(ex.toString());

            }
            if (file != null) {
                try {

                    if (fileOpened != null) {
                        file = fileOpened;
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    if (fos != null) {
                        ObjectOutputStream ob = new ObjectOutputStream(fos);
                        jugador1.setTime(j1Timer.seg, j1Timer.min, j1Timer.hour);
                        jugador2.setTime(j2Timer.seg, j2Timer.min, j2Timer.hour);

                        ob.writeObject(new CurrentData(jugador1, jugador2, jugadorActual, logger1.getText(), logger2.getText(), Util.mostrarPosibleJugada, Util.tableroInvertido, Util.tiempoTerminado, j1Timer.minMax, j1Timer.hourMax, casillaPeonAlpasoN, casillaPeonAlpasoB));
                        setTitleToFrame(file.getAbsolutePath());
                        setSavedGame(true);
                        frame.jMenuItem6.setEnabled(true);
                        Util.showAdvice(Util.idioma[40] + ":\n" + file.getAbsolutePath(), Util.idioma[14]);
                    }

                } catch (IOException ex) {
                    Util.showError(ex.toString());
                } catch (NullPointerException ex) {
                    Util.showError(ex.toString());

                }

            }

        }
    }

    public void openGame() {
        if (!saved) {//si no esta salvado el juego
            int quest = Util.showQuestion(Util.idioma[42], Util.idioma[43]);
            if (quest == 0) {
                open();
            }
        } else {
            open();
        }
    }

    void deleteAllTables() {
        try {
            ResultSet rs = conexion.ejecutarConsulta("DELETE FROM data");
            rs = conexion.ejecutarConsulta("DELETE FROM controlador");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeGame() {
        if (conexion != null) {//si esta conectado por la red
            if (Util.showQuestion(Util.idioma[110], Util.idioma[28]) == 0) {
                deleteAllTables();
                System.exit(0);
            }
        } else {

            if (!saved) {//si no esta salvado el juego
                if (Util.showQuestion(Util.idioma[27], Util.idioma[28]) == 0) {
                    System.exit(0);
                }

            } else {
                System.exit(0);
            }
        }
    }

    public void openFile(CurrentData cd, String address) {
        frame.jButton3.setVisible(false);
        frame.jButton1.setVisible(false);
        frame.jMenuItem11.setEnabled(true);
        frame.j1Timer.setVisible(true);
        frame.j2Timer.setVisible(true);
        Util.mostrarPosibleJugada = cd.mostrarJugada;
        Util.tableroInvertido = cd.tableroInvertido;
        Util.tiempoTerminado = cd.tiempoTerminado;
        casillaPeonAlpasoB = cd.peonAlPasoB;
        casillaPeonAlpasoN = cd.peonAlPasoN;

        tablero.setNewBoard();
        frame.numeraciones2.invert();
        setEvents();
        jugador1 = cd.j1;
        jugador2 = cd.j2;
        j1Timer.setTime(jugador1.seg, jugador1.min, jugador1.hour, cd.minMax, cd.hourMax);
        j2Timer.setTime(jugador2.seg, jugador2.min, jugador2.hour, cd.minMax, cd.hourMax);

        logger1.setText(cd.logger1);
        logger2.setText(cd.logger2);
        jugadorActual = cd.jact.nombre.equals(jugador1.nombre) ? jugador2 : jugador1;

        frame.j1Comidas.setText("" + getJugador1().getPiezasComidas());
        frame.j1piezas.setText("" + getJugador1().getCantPiezas());
        frame.j1color.setBackground(jugador1.getColor());
        frame.j2Comidas.setText("" + getJugador2().getPiezasComidas());
        frame.j2piezas.setText("" + getJugador2().getCantPiezas());
        frame.j2color.setBackground(jugador2.getColor());

        for (int i = 0; i < jugador1.piezas.size(); i++) {
            Pieza p = jugador1.piezas.get(i);

            eventPieza(p);
            Coordenada co = tablero.getCoordenada(p.casilla);
            Casilla c = tablero.casillas[co.i][co.j];
            c.add((Component) p);
            c.pieza = p;
            p.casilla.pieza = null;
            p.casilla = c;

        }
        for (int i = 0; i < jugador2.piezas.size(); i++) {
            Pieza p = jugador2.piezas.get(i);

            eventPieza(p);
            Coordenada co = tablero.getCoordenada(p.casilla);
            Casilla c = tablero.casillas[co.i][co.j];
            c.add((Component) p);
            c.pieza = p;
            p.casilla.pieza = null;
            p.casilla = c;

        }
        setTitleToFrame(address);
        tablero.updateUI();
        setSavedGame(true);

        frame.setCursor(new Cursor(0));
        if (!Util.tiempoTerminado) {
            playGame();
            next();
        } else {
            Util.showWarning(jugadorActual.nombre + " " + Util.idioma[56], Util.idioma[79]);
            endGame();
        }
    }

    void open() {
        JFileChooser fc = new JFileChooser();
        FileFilter ff = new FileNameExtensionFilter("Painted Chess Saves", "pchs");
        fc.setFileFilter(ff);
        File dir = new File(fc.getCurrentDirectory().getPath() + "\\Painted Chess - Data\\Saves\\");
        fc.setCurrentDirectory(dir);
        int value = fc.showOpenDialog(frame);
        if (value == 0) {
            frame.setCursor(new Cursor(3));
            File file = fc.getSelectedFile();
            if (file != null) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    if (fis != null) {
                        ObjectInputStream obi = new ObjectInputStream(fis);
                        CurrentData cd = (CurrentData) obi.readObject();
                        openFile(cd, file.getAbsolutePath());
                        fis.close();

                    }
                } catch (FileNotFoundException ex) {
                    Util.showError(Util.idioma[44]);
                } catch (IOException ex) {
                    Util.showError(Util.idioma[44]);
                } catch (ClassNotFoundException ex) {
                    Util.showError(Util.idioma[44]);
                } finally {
                    frame.setCursor(new Cursor(0));
                }
            }
        }

    }

    public void setSavedGame(boolean saved) {
        if (saved) {
            frame.jMenuItem2.setEnabled(false);
            frame.jMenuItem6.setEnabled(false);
//            frame.jMenuItem11.setEnabled(false);
            this.saved = true;
        } else {
            frame.jMenuItem2.setEnabled(true);
            frame.jMenuItem6.setEnabled(true);
            frame.jMenuItem11.setEnabled(true);
            this.saved = false;
        }
    }

    void hidePopupMenus() {
        if (frame.jMenu1.isPopupMenuVisible()) {
            frame.jMenu1.setPopupMenuVisible(false);
        } else if (frame.jMenu2.isPopupMenuVisible()) {
            frame.jMenu2.setPopupMenuVisible(false);
        }
        frame.jMenu1.setSelected(false);
        frame.jMenu2.setSelected(false);
    }

    void startGame() {
//        Sound.soundTrak();

        Util.tiempoTerminado = false;
        j1Timer.play();
        start();
    }

    public void pauseGame() {
        if (conexion != null) {
            setPauseToTable(true);
        } else {
            pauseAction();
        }

    }

    void setPauseToTable(boolean pause) {
        try {
            if (pause) {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET pausa='" + true + "'");
            } else {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET play='" + true + "'");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void pauseAction() {
        Sound.pause();
        title = frame.getTitle();
        frame.jMenuItem17.setVisible(false);
        frame.jMenuItem1.setVisible(true);
        frame.setTitle(Util.idioma[89]);
        j1Timer.pause();
        j2Timer.pause();
        frame.jMenuItem6.setEnabled(false);
        jugadorActual.habilitarPiezas(false);
        tablero.habilitarCasillas(false);
        tablero.setColorToCells();
    }

    public void playGame() {
        if (conexion != null) {
            setPauseToTable(false);
        } else {
            playAction();
        }

    }

    void playAction() {
        Sound.play();
        if (title != null) {
            frame.setTitle(title);
        }
        frame.jMenuItem17.setVisible(true);
        frame.jMenuItem1.setVisible(false);
        title = null;
        frame.jMenuItem6.setEnabled(true);
        if (jugadorActual.equals(jugador1)) {
            j1Timer.play();
            j2Timer.pause();

        } else {
            j2Timer.play();
            j1Timer.pause();
        }
        if (jugadorActual.isPC() || jugadorActual.juegaPorRed) {
            jugadorActual.habilitarPiezas(false);
        } else {
            jugadorActual.habilitarPiezas(true);
        }
        tablero.habilitarCasillas(false);
        tablero.setColorToCells();
        setCanWalk();

    }

    public void endGame() {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET juego_terminado='" + true + "'");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            end();
        }

    }

    void end() {
        frame.jMenuItem2.setEnabled(true);
        frame.setCursor(new Cursor(0));
        setSavedGame(false);
        j1Timer.pause();
        j2Timer.pause();
        jugador1.habilitarPiezas(false);
        jugador2.habilitarPiezas(false);
        frame.jMenuItem17.setEnabled(false);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Util.tiempoTerminado) {
                    Util.showWarning(jugadorActual.nombre + " " + Util.idioma[56], Util.idioma[79]);
                    Util.tiempoTerminado = false;
                    endGame();
                }
                if (conexion != null) {//si esta desde la red
                    DB_settings();
                } else if (jugadorActual.isPC()) {
                    frame.setCursor(new Cursor(3));
                    setSavedGame(true);

                    //--------pruebas de mov de pc para el jake pastor, para las negras!!!
                    System.out.println("la pc esta pensando una jugada.....");
                    Thread.sleep(1000);
                    PC_IA();
                    System.out.println("ya termino");
                    //---------------------------------------------------------------
                    frame.jMenuItem2.setEnabled(true);
                    frame.setCursor(new Cursor(0));
                    setSavedGame(false);
                    next();
                }
            }

        } catch (InterruptedException ex) {
            Util.showError(ex.toString());
        }
    }

    void PC_IA() {//aqui se hacen los movimientos de la pc

    }

    void DB_settings() {
        try {
            ResultSet rs1 = conexion.ejecutarConsulta("SELECT * FROM controlador");
            Object[][] sel = DatosConexion.getTableFomResultSet(rs1);
            boolean reset = (String.valueOf(sel[0][1]).toLowerCase().equals("t"));
            String chattxt = (String) sel[0][2];
            String logger = (String) sel[0][3];

            boolean j1_semovio = (String.valueOf(sel[0][4]).toLowerCase().equals("t"));
            boolean j2_semovio = (String.valueOf(sel[0][5]).toLowerCase().equals("t"));
            boolean pausa = (String.valueOf(sel[0][6]).toLowerCase().equals("t"));
            boolean play = (String.valueOf(sel[0][7]).toLowerCase().equals("t"));
            boolean juegoTerminado = (String.valueOf(sel[0][8]).toLowerCase().equals("t"));

            rs1 = conexion.ejecutarConsulta("SELECT * FROM data");
            Object[][] selec = DatosConexion.getTableFomResultSet(rs1);
            int min1 = Integer.parseInt((String) selec[0][8]);
            int seg1 = Integer.parseInt((String) selec[0][9]);
            int hor1 = Integer.parseInt((String) selec[0][10]);
            int min2 = Integer.parseInt((String) selec[0][11]);
            int seg2 = Integer.parseInt((String) selec[0][12]);
            int hor2 = Integer.parseInt((String) selec[0][13]);

            if (pausa) {
                pauseAction();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET pausa='" + false + "'");
            }
            if (play) {
                playAction();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET play='" + false + "'");
            }

            if (reset) {
                reset();
                tablero.updateUI();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET reset='" + false + "'");
            }

            if (juegoTerminado) {
                end();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET juego_terminado='" + false + "'");
            }

            if (!chattxt.equals("")) {
                chat.area.append(chattxt + "\n");
                chat.show();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET chat='" + "" + "'");
            }

            if (min1 != -1 && seg1 != -1 && hor1 != -1 && min2 != -1 && seg2 != -1 && hor2 != -1) {
                j2Timer.setTime(seg2, min2, hor2, j2Timer.minMax, j2Timer.hourMax);
                j1Timer.setTime(seg1, min1, hor1, j1Timer.minMax, j1Timer.hourMax);
                ResultSet rs = conexion.ejecutarConsulta("UPDATE data SET min1='" + -1 + "',seg1='" + -1 + "',hor1='" + -1 + "',min2='" + -1 + "',seg2='" + -1 + "',hor2='" + -1 + "'");
            }

            if (j1_semovio) {
                nextTurn();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET jug1_semovio='" + false + "'");
                if (!logger.equals("")) {
                    logger1.append(logger + "\n");
                    rs1 = conexion.ejecutarConsulta("UPDATE controlador SET logger='" + "" + "'");
                }
            } else if (j2_semovio) {
                nextTurn();
                rs1 = conexion.ejecutarConsulta("UPDATE controlador SET jug2_semovio='" + false + "'");
                if (!logger.equals("")) {
                    logger2.append(logger + "\n");
                    rs1 = conexion.ejecutarConsulta("UPDATE controlador SET logger='" + "" + "'");
                }
            }

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            deleteAllTables();
            interrumpirConexion();
        }
    }

    Pieza getPiezaCambiada(String piezacambiada, Casilla ca) {
        if (piezacambiada.equals("dama")) {
            return new Dama(jugadorActual.color, ca);
        } else if (piezacambiada.equals("torre")) {
            return new Torre(jugadorActual.color, ca);
        } else if (piezacambiada.equals("alfil")) {
            return new Alfil(jugadorActual.color, ca);
        }
        return new Caballo(jugadorActual.color, ca);
    }

    void moveOtherPlayer() {
        try {
            ResultSet rs1 = conexion.ejecutarConsulta("SELECT * FROM data");
            Object[][] selec = DatosConexion.getTableFomResultSet(rs1);
            String casilla_ini = (String) selec[0][0];
            String casilla_fin = (String) selec[0][1];
            int enrosque = Integer.parseInt((String) selec[0][3]);
            String peonAlpaso = (String) selec[0][4];
            String casillaComidaPAP = (String) selec[0][5];
            String piezaenmeta = (String) selec[0][6];
            String piezacambiada = (String) selec[0][7];

            if (jugadorActual.juegaPorRed) {

                if (enrosque == 0) {//enrosque corto
                    if (jugadorActual.color.equals(Util.blancas)) {
                        tablero.g1.habilitado = true;
                        tablero.f1.habilitado = true;
                        mover(tablero.e1.pieza, tablero.g1);
                        mover(tablero.h1.pieza, tablero.f1);
                    } else {
                        tablero.g8.habilitado = true;
                        tablero.f8.habilitado = true;
                        mover(tablero.e8.pieza, tablero.g8);
                        mover(tablero.h8.pieza, tablero.f8);
                    }
                    rs1 = conexion.ejecutarConsulta("UPDATE data SET enrosque='" + -1 + "'");
                } else if (enrosque == 1) {//enrosque largo
                    if (jugadorActual.color.equals(Util.blancas)) {
                        tablero.c1.habilitado = true;
                        tablero.d1.habilitado = true;
                        mover(tablero.e1.pieza, tablero.c1);
                        mover(tablero.a1.pieza, tablero.d1);
                    } else {
                        tablero.c8.habilitado = true;
                        tablero.d8.habilitado = true;
                        mover(tablero.e8.pieza, tablero.c8);
                        mover(tablero.a8.pieza, tablero.d8);
                    }
                    rs1 = conexion.ejecutarConsulta("UPDATE data SET enrosque='" + -1 + "'");
                } else if (!peonAlpaso.equals("")) {//si hay jugada peon al paso
                    Casilla cc = tablero.getCasilla(peonAlpaso);
                    if (jugadorActual.color.equals(Util.blancas)) {
                        casillaPeonAlpasoB = cc;
                    } else {
                        casillaPeonAlpasoN = cc;
                    }
                    rs1 = conexion.ejecutarConsulta("UPDATE data SET peonalpaso='" + "" + "'");

                }
                if (!casilla_ini.equals("") && !casilla_fin.equals("")) {//si movio otra ficha
                    Casilla ini = tablero.getCasilla(casilla_ini);
                    Casilla fin = tablero.getCasilla(casilla_fin);
                    fin.habilitado = true;
                    movePiezaToCasilla(fin, ini.pieza);
                    rs1 = conexion.ejecutarConsulta("UPDATE data SET casilla_inicio='" + "" + "',casilla_fin='" + "" + "'");

                    if (!piezaenmeta.equals("")) {
                        System.out.println(piezaenmeta + " " + piezacambiada);
                        Casilla c = tablero.getCasilla(piezaenmeta);
                        Pieza t = getPiezaCambiada(piezacambiada, c);
                        t.casilla = c;
                        t.jugador = jugadorActual;
                        eventPieza(t);
                        Pieza p = c.pieza;
                        c.remove(p);
                        Pieza pi;
                        jugadorActual.piezas.remove(p);
                        jugadorActual.piezas.add(t);
                        c.add(t);
                        rs1 = conexion.ejecutarConsulta("UPDATE data SET piezaenmeta='" + "" + "',piezacambiada='" + "" + "'");
                    } else if (!casillaComidaPAP.equals("")) {
                        Casilla ccpap = tablero.getCasilla(casillaComidaPAP);
                        Pieza p = ccpap.pieza;
                        p.jugador.perderPieza(p);
                        jugadorActual.comerPieza();
                        ccpap.remove(p);
                        rs1 = conexion.ejecutarConsulta("UPDATE data SET casillacomida_pap='" + "" + "'");
                    }
                }

            }

        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            deleteAllTables();
        }

    }

    public void interrumpirConexion() {
        chat.dispose();
        Util.showError(Util.idioma[108], Util.idioma[101]);
        frame.dispose();
        if (gotoInicio) {
            try {
                UIManager.setLookAndFeel(new NapkinLookAndFeel());
                new StartMenu();
            } catch (UnsupportedLookAndFeelException ex) {
            }
        } else {
            try {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
                new MultiJugador();
            } catch (UnsupportedLookAndFeelException ex) {
            }
        }

        endGame();
        stop();
    }

    public void next() {
        setDanger();
        jugadorActual.rey.estaEnjake = false;
        tablero.habilitarCasillas(false);
        Util.piezaTemporal = null;
        setActualPlayer();
        if (jugadorActual.isPC() || jugadorActual.juegaPorRed) {
            jugadorActual.habilitarPiezas(false);
        }
        setCanWalk();
//        colorearAmenazadas();

        frame.j1Comidas.setText("" + getJugador1().getPiezasComidas());
        frame.j1piezas.setText("" + getJugador1().getCantPiezas());
        frame.j2Comidas.setText("" + getJugador2().getPiezasComidas());
        frame.j2piezas.setText("" + getJugador2().getCantPiezas());

        if (jugadorActual.rey.estaEnjake) {
            if (noHayMovimientos()) {//jake mate
                if (jugador1.nombre.equals(jugadorActual.nombre)) {
                    jugadorActual = jugador2;
                } else {
                    jugadorActual = jugador1;
                }
                updateLogger("++");
                if (jugador1.nombre.equals(jugadorActual.nombre)) {
                    jugadorActual = jugador2;
                } else {
                    jugadorActual = jugador1;
                }

                if (jugadorActual.nombre.equals(jugador1.nombre)) {
                    setJakeMate(jugador1, jugador2);
                } else {
                    setJakeMate(jugador2, jugador1);

                }
                endGame();

            } else {//jake
                if (jugador1.nombre.equals(jugadorActual.nombre)) {
                    jugadorActual = jugador2;
                } else {
                    jugadorActual = jugador1;
                }
                updateLogger("+");
                if (jugador1.nombre.equals(jugadorActual.nombre)) {
                    jugadorActual = jugador2;
                } else {
                    jugadorActual = jugador1;
                }
                if (!jugadorActual.isPC()) {
                    if (conexion != null) {
                        if (jugadorActual.nombre.equals(jugadorEstaPC)) {
                            Util.showJake(" (" + jugadorActual.nombre + ") " + Util.idioma[122]);
                        }
                    } else {
                        Util.showJake(Util.idioma[48] + " (" + jugadorActual.nombre + ") " + Util.idioma[49]);
                    }
                }
            }
        } else if (noHayMovimientos()) {//rey ahogado
            endGame();
            Util.showError(jugadorActual.nombre + " " + Util.idioma[66], Util.idioma[55]);
        }
        tablero.updateUI();
    }

    public void nextTurn() {
        if (conexion != null) {
            moveOtherPlayer();
            next();
            updateTableForTimer();
        } else {
            next();
        }

    }

    void setJakeMate(Jugador j1, Jugador j2) {
        j1Timer.pause();
        j2Timer.pause();
        if (j1.isPC() && !j2.isPC()) {
            Util.win = true;
            Util.showJakeMate(j2.nombre);
        } else if (!j1.isPC() && j2.isPC()) {
            Util.win = false;
            Util.showJakeMate(j1.nombre);
        } else if (j1.isPC() && j2.isPC()) {
            Util.win = true;
            Util.showJakeMate(j2.nombre);
        } else if (j1.juegaPorRed && !j2.juegaPorRed) {
            Util.win = true;
            Util.showJakeMate(j2.nombre);
        } else if (!j1.juegaPorRed && j2.juegaPorRed) {
            Util.win = false;
            Util.showJakeMate(j1.nombre);
        } else {
            Util.win = true;
            Util.showJakeMate(j2.nombre);
        }
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    void updateLogger(String c) {
        String log1[] = logger1.getText().split("\n");
        String log2[] = logger2.getText().split("\n");
        String l = "";
        if (jugador1.nombre.equals(jugadorActual.nombre)) {
            l = log1[log1.length - 1];
            if (!l.contains("+")) {
                logger1.setText("");
                for (int i = 0; i < log1.length - 1; i++) {
                    refreshLogger(log1[i]);
                }

            }
        } else {
            l = log2[log2.length - 1];
            if (!l.contains("+")) {
                logger2.setText("");
                for (int i = 0; i < log2.length - 1; i++) {
                    refreshLogger(log2[i]);
                }

            }
        }

        refreshLogger(l + c);

    }

    boolean noHayMovimientos() {
        for (int i = 0; i < jugadorActual.piezas.size(); i++) {
            if (jugadorActual.piezas.get(i).puedeCaminar) {
                return false;
            }
        }

        return true;
    }

    public void setTitleToFrame(String address) {
//        String fileName = "\\" + jugador1.nombre + "-" + jugador2.nombre + "(save).pchs";
        frame.setTitle(Util.idioma[29] + "     " + address);

    }

    void movePiezaToCasilla(Casilla c, Pieza p) {
        if (c.habilitado) {
            updateTableForMove(p.casilla.id, c.id);
            if (c.pieza != null) {//si tiene pieza la casilla
                if (!c.pieza.getColor().equals(p.getColor())) {//al comer
                    p.casilla.remove(p);
                    c.pieza.jugador.perderPieza(c.pieza);
                    setLogger_Meals(p, c, c.pieza);
                    c.remove(c.pieza);
//                  p.casilla.remove(p);
                    c.pieza = p;
                    c.pieza.casilla = c;
                    c.pieza.seMovio = true;
                    c.add((Component) c.pieza);
                    c.pieza.jugador.comerPieza();
                    setSavedGame(false);
                    Sound.eat();

                    jugadorActual.movimientos++;

                }
            } else {
                setLogger_Move(p, c);
                mover(p, c);
                jugadorActual.movimientos++;
            }
            tablero.setColorToCells();
            Util.piezaSeleccionada = false;
            tablero.habilitarCasillas(false);
            tablero.updateUI();
        }

    }

    void mover(Pieza p, Casilla c) {
        setSavedGame(false);
        p.casilla.remove(p);
        c.pieza = p;
        c.pieza.casilla = c;
        c.pieza.seMovio = true;
        c.add((Component) c.pieza);
        Sound.move();

    }

    void setLogger_Move(Pieza p, Casilla actual) {
        setDanger();
        if (p instanceof Peon) {
            refreshLogger(jugadorActual.movimientos + ":" + p.casilla.id + "" + actual.id);
        } else if (p instanceof Torre) {
            refreshLogger(jugadorActual.movimientos + ":" + "T" + p.casilla.id + "" + actual.id);
        } else if (p instanceof Dama) {
            refreshLogger(jugadorActual.movimientos + ":" + "D" + p.casilla.id + "" + actual.id);
        } else if (p instanceof Rey) {
            refreshLogger(jugadorActual.movimientos + ":" + "R" + p.casilla.id + "" + actual.id);
        } else if (p instanceof Alfil) {
            refreshLogger(jugadorActual.movimientos + ":" + "A" + p.casilla.id + "" + actual.id);
        } else if (p instanceof Caballo) {
            refreshLogger(jugadorActual.movimientos + ":" + "C" + p.casilla.id + "" + actual.id);
        }
    }

    void refreshLogger(String n) {
        if (conexion == null) {
            if (jugador1.nombre.equals(jugadorActual.nombre)) {
                logger1.append(n + "\n");

            } else {
                logger2.append(n + "\n");

            }
        } else {
            updateTableForLogger(n);
        }
    }

    void setLogger_Meals(Pieza p, Casilla actual, Pieza pp) {
        String piezaComida = "A";
        if (pp instanceof Torre) {
            piezaComida = "T";
        } else if (pp instanceof Dama) {
            piezaComida = "D";
        } else if (pp instanceof Caballo) {
            piezaComida = "C";
        } else if (pp instanceof Peon) {
            piezaComida = "";
        }
        if (p instanceof Peon) {
            refreshLogger(jugadorActual.movimientos + ":" + "" + p.casilla.id + "x" + piezaComida + actual.id);
        } else if (p instanceof Torre) {
            refreshLogger(jugadorActual.movimientos + ":" + "T" + p.casilla.id + "x" + piezaComida + actual.id);
        } else if (p instanceof Dama) {
            refreshLogger(jugadorActual.movimientos + ":" + "D" + p.casilla.id + "x" + piezaComida + actual.id);
        } else if (p instanceof Rey) {
            refreshLogger(jugadorActual.movimientos + ":" + "R" + p.casilla.id + "x" + piezaComida + actual.id);
        } else if (p instanceof Alfil) {
            refreshLogger(jugadorActual.movimientos + ":" + "A" + p.casilla.id + "x" + piezaComida + actual.id);
        } else if (p instanceof Caballo) {
            refreshLogger(jugadorActual.movimientos + ":" + "C" + p.casilla.id + "x" + piezaComida + actual.id);
        }

    }

    public boolean isOnBoard(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public void setEvents() {

        for (int i = 0; i < 8; i++) {
            eventPieza(tablero.piezasBlancas[i]);
            eventPieza(tablero.piezasNegras[i]);
            for (int j = 0; j < 8; j++) {
                eventCasilla(tablero.casillas[i][j]);
            }
        }
        for (int i = 8; i < 16; i++) {
            eventPieza(tablero.piezasBlancas[i]);
            eventPieza(tablero.piezasNegras[i]);

        }
    }

    public void eventPieza(Pieza p) {
        p.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Casilla c = p.casilla;
                hidePopupMenus();
                if (e.getButton() == 1) {
                    if (p.puedeCaminar) {
                        if (p.isHabilitada() && !p.jugador.isPC()) {
                            tablero.habilitarCasillas(false);
                            Util.piezaTemporal = p;
                            Util.piezaSeleccionada = true;
                            tablero.setColorToCells();
                            p.casilla.setBackground(Util.seleccion);
                            paintWay(Util.piezaTemporal.getCasilla());
                            tablero.updateUI();
                        }
                    } else {
                        moveAction(c);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                p.setToolTipText(p.toolTip);
                if (p.isHabilitada() && !p.jugador.isPC() && p.puedeCaminar) {
                    p.setCursor(new Cursor(12));
                } else {
                    p.setCursor(new Cursor(0));
                }
                tablero.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Pieza pt = Util.piezaTemporal;
                if (pt != null) {
                    if (!Util.piezaSeleccionada) {
                        tablero.setColorToCells();
                        tablero.updateUI();
                    }
                }

            }
        });
    }

    void moveAction(Casilla c) {
        Pieza p = Util.piezaTemporal;
        if (p != null) {
            if (c.isHabilitado()) {
                Coordenada cor = tablero.getCoordenada(p.casilla);
                if (p instanceof Rey) {
                    Rey r = (Rey) p;
                    if (!p.seMovio && !r.estaEnjake) {//si el rey no se ha movido de su casilla original y no esta en jake
                        if (p.color.equals(Util.blancas)) {//si se mueve un rey blanco
                            if (!Util.tableroInvertido && c.equals(tablero.casillas[7][6])) {//enrosque corto para las blancas
                                setShortRoll(cor.i, cor.j, p);
                            } else if (!Util.tableroInvertido && c.equals(tablero.casillas[7][2])) { //enrosque largo para las blancas
                                setLargeRoll(cor.i, cor.j, p);
                            } else if (Util.tableroInvertido && c.equals(tablero.casillas[0][1])) {//enrosque corto para las blancas
                                setShortRoll(cor.i, cor.j, p);
                            } else if (Util.tableroInvertido && c.equals(tablero.casillas[0][5])) { //enrosque largo para las blancas
                                setLargeRoll(cor.i, cor.j, p);
                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }

                        } else if (p.color.equals(Util.negras)) {//si se mueve un rey negro
                            if (!Util.tableroInvertido && c.equals(tablero.casillas[0][6])) {//enrosque corto para las negras
                                setShortRoll(cor.i, cor.j, p);
                            } else if (!Util.tableroInvertido && c.equals(tablero.casillas[0][2])) { //enrosque largo para las negras
                                setLargeRoll(cor.i, cor.j, p);
                            } else if (Util.tableroInvertido && c.equals(tablero.casillas[7][1])) {//enrosque corto para las negras
                                setShortRoll(cor.i, cor.j, p);
                            } else if (Util.tableroInvertido && c.equals(tablero.casillas[7][5])) { //enrosque largo para las negras
                                setLargeRoll(cor.i, cor.j, p);
                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }
                        }
                    } else {
                        movePiezaToCasilla(c, p);
                        updatetableForJugMovio();
                        if (conexion == null) {
                            nextTurn();
                        }
                    }

                } else if (p instanceof Peon) {
                    Coordenada cord = tablero.getCoordenada(c);
                    if (!Util.tableroInvertido) {
                        if (p.color.equals(Util.blancas)) {//si se mueve un peon blanco
                            if (p.casillaInicio.id.equals(p.casilla.id) && cord.i == 4) {//si el peon esta en la casilla de inicio y la casilla seleccionada es dos filas arriba
                                casillaPeonAlpasoB = tablero.casillas[cord.i + 1][cord.j];
                                updateTablePeonAlPaso(casillaPeonAlpasoB.id);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 2 && casillaPeonAlpasoN != null && c.id.equals(casillaPeonAlpasoN.id)) {//si el peon llego a la fila 2
                                Casilla cc = tablero.casillas[cord.i + 1][cord.j];
                                updateTableCasillaComidaPAP(cc.id);
                                cc.pieza.jugador.perderPieza(cc.pieza);
                                p.jugador.comerPieza();
                                frame.j1Comidas.setText("" + getJugador1().getPiezasComidas());
                                frame.j2piezas.setText("" + getJugador2().getCantPiezas());
                                cc.remove(cc.pieza);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                updateLogger("x" + tablero.casillas[cord.i + 1][cord.j].id);
                                Sound.eat();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 0) {//si el peon llego a la fila 0
                                Pieza pp = Util.piezaTemporal;
                                movePiezaToCasilla(c, p);
                                Util.piezaTemporal = pp;
                                SeleccionarNuevaPieza s = new SeleccionarNuevaPieza(frame, true);
                                Pieza t = Util.piezaCambiada;
                                updateTableForPiezaEnMeta(t, c.id);
                                updatetableForJugMovio();
                                t.casilla = c;
                                eventPieza(t);
                                c.remove(p);
                                Pieza pi;
                                jugador1.piezas.remove(p);
                                jugador1.piezas.add(t);
                                c.add(t);
                                tablero.updateUI();
                                if (conexion == null) {
                                    nextTurn();
                                }

                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }
                        } else if (p.color.equals(Util.negras)) {//si se mueve un peon negro
                            if (p.casillaInicio.id.equals(p.casilla.id) && cord.i == 3) {
                                casillaPeonAlpasoN = tablero.casillas[cord.i - 1][cord.j];
                                updateTablePeonAlPaso(casillaPeonAlpasoN.id);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 5 && casillaPeonAlpasoB != null && c.id.equals(casillaPeonAlpasoB.id)) {//si el peon llego a la fila 5
                                Casilla cc = tablero.casillas[cord.i - 1][cord.j];
                                updateTableCasillaComidaPAP(cc.id);
                                cc.pieza.jugador.perderPieza(cc.pieza);
                                p.jugador.comerPieza();
                                frame.j1piezas.setText("" + getJugador1().getCantPiezas());
                                frame.j2Comidas.setText("" + getJugador2().getPiezasComidas());
                                cc.remove(cc.pieza);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                updateLogger("x" + tablero.casillas[cord.i - 1][cord.j].id);
                                Sound.eat();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 7) {//si el peon esta en la fila 7
                                Pieza pp = Util.piezaTemporal;
                                movePiezaToCasilla(c, p);
                                Util.piezaTemporal = pp;
                                SeleccionarNuevaPieza s = new SeleccionarNuevaPieza(frame, true);
                                Pieza t = Util.piezaCambiada;
                                updateTableForPiezaEnMeta(t, c.id);
                                updatetableForJugMovio();
                                t.casilla = c;
                                eventPieza(t);
                                c.remove(p);
                                Pieza pi;
                                jugador2.piezas.remove(p);
                                jugador2.piezas.add(t);
                                c.add(t);
                                tablero.updateUI();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }
                        }
                    } else {
                        if (p.color.equals(Util.blancas)) {//si se mueve un peon blanco
                            if (p.casillaInicio.id.equals(p.casilla.id) && cord.i == 3) {//si el peon esta en la casilla de inicio y la casilla seleccionada es dos filas arriba
                                casillaPeonAlpasoB = tablero.casillas[cord.i - 1][cord.j];
                                updateTablePeonAlPaso(casillaPeonAlpasoB.id);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 5 && casillaPeonAlpasoN != null && c.id.equals(casillaPeonAlpasoN.id)) {//si el peon llego a la fila 2
                                Casilla cc = tablero.casillas[cord.i - 1][cord.j];
                                updateTableCasillaComidaPAP(cc.id);
                                cc.pieza.jugador.perderPieza(cc.pieza);
                                p.jugador.comerPieza();
                                frame.j1Comidas.setText("" + getJugador1().getPiezasComidas());
                                frame.j2piezas.setText("" + getJugador2().getCantPiezas());
                                cc.remove(cc.pieza);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                updateLogger("x" + tablero.casillas[cord.i - 1][cord.j].id);
                                Sound.eat();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 7) {//si el peon llego a la fila 7
                                Pieza pp = Util.piezaTemporal;
                                movePiezaToCasilla(c, p);
                                Util.piezaTemporal = pp;
                                SeleccionarNuevaPieza s = new SeleccionarNuevaPieza(frame, true);
                                Pieza t = Util.piezaCambiada;
                                updateTableForPiezaEnMeta(t, c.id);
                                updatetableForJugMovio();
                                t.casilla = c;
                                eventPieza(t);
                                c.remove(p);
                                Pieza pi;
                                jugador1.piezas.remove(p);
                                jugador1.piezas.add(t);
                                c.add(t);
                                tablero.updateUI();
                                if (conexion == null) {
                                    nextTurn();
                                }

                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }
                        } else if (p.color.equals(Util.negras)) {//si se mueve un peon negro
                            if (p.casillaInicio.id.equals(p.casilla.id) && cord.i == 4) {
                                casillaPeonAlpasoN = tablero.casillas[cord.i + 1][cord.j];
                                updateTablePeonAlPaso(casillaPeonAlpasoN.id);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 2 && casillaPeonAlpasoB != null && c.id.equals(casillaPeonAlpasoB.id)) {//si el peon llego a la fila 5
                                Casilla cc = tablero.casillas[cord.i + 1][cord.j];
                                updateTableCasillaComidaPAP(cc.id);
                                cc.pieza.jugador.perderPieza(cc.pieza);
                                p.jugador.comerPieza();
                                frame.j1piezas.setText("" + getJugador1().getCantPiezas());
                                frame.j2Comidas.setText("" + getJugador2().getPiezasComidas());
                                cc.remove(cc.pieza);
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                updateLogger("x" + tablero.casillas[cord.i + 1][cord.j].id);
                                Sound.eat();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else if (cord.i == 0) {//si el peon esta en la fila 0
                                Pieza pp = Util.piezaTemporal;
                                movePiezaToCasilla(c, p);
                                Util.piezaTemporal = pp;
                                SeleccionarNuevaPieza s = new SeleccionarNuevaPieza(frame, true);
                                Pieza t = Util.piezaCambiada;
                                updateTableForPiezaEnMeta(t, c.id);
                                updatetableForJugMovio();
                                t.casilla = c;
                                eventPieza(t);
                                c.remove(p);
                                Pieza pi;
                                jugador2.piezas.remove(p);
                                jugador2.piezas.add(t);
                                c.add(t);
                                tablero.updateUI();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            } else {
                                movePiezaToCasilla(c, p);
                                updatetableForJugMovio();
                                if (conexion == null) {
                                    nextTurn();
                                }
                            }
                        }
                    }

                } else {
                    movePiezaToCasilla(c, p);
                    updatetableForJugMovio();
                    if (conexion == null) {
                        nextTurn();
                    }
                }

            } else {
                tablero.setColorToCells();
                tablero.habilitarCasillas(false);
                tablero.updateUI();
            }
        }

    }

    public void eventCasilla(Casilla c) {
        c.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hidePopupMenus();
                if (e.getButton() == 1) {
                    moveAction(c);
                } else {
                    tablero.setColorToCells();
                    tablero.habilitarCasillas(false);
                    tablero.updateUI();

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                c.setToolTipText(c.id);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public void colorearAmenazadas() {//borrar este metodo despues...
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.casillas[i][j].tieneAmenaza) {
                    tablero.casillas[i][j].setBackground(Util.killing);
                }

            }
        }
        tablero.updateUI();
    }

    public void colorearCanWalk() {//borrar este metodo despues...
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.casillas[i][j].pieza != null && tablero.casillas[i][j].pieza.puedeCaminar) {
                    tablero.casillas[i][j].setBackground(Util.killing);
                }

            }
        }
        tablero.updateUI();
    }

    public void colorearAtacandoAlRey() {//borrar este metodo despues...
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.casillas[i][j].tapandoJake) {
                    tablero.casillas[i][j].setBackground(Util.killing);
                }

            }
        }
        tablero.updateUI();
    }

    public void clear_AllDanger() {
        piezasAtacandoAlRey = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero.casillas[i][j].tieneAmenaza = false;
                tablero.casillas[i][j].estaEnElJake = false;
                tablero.casillas[i][j].tapandoJake = false;
            }
        }
        caminoDelJake.removeAll(caminoDelJake);
    }

    public void setDanger() {
        clear_AllDanger();
        LinkedList<Pieza> l = jugadorActual.piezas;
        for (int i = 0; i < l.size(); i++) {
            setCasillasAmenazadas(l.get(i));
        }

        for (int i = 0; i < caminoDelJake.size(); i++) {//cambiar mas adelante
            Coordenada co = caminoDelJake.get(i);
            tablero.casillas[co.i][co.j].estaEnElJake = true;
        }

    }

    public void setCasillasAmenazadas(Pieza p) {
        Coordenada cor = tablero.getCoordenada(p.casilla);
        int i = cor.i;
        int j = cor.j;
        if (p instanceof Peon) {
            movimientos.threat.getAmenazasPeon(i, j, p);
        } else if (p instanceof Torre) {
            movimientos.threat.getAmenazasTorre(i, j, p);
        } else if (p instanceof Dama) {
            movimientos.threat.getAmenazasDama(i, j, p);
        } else if (p instanceof Rey) {
            movimientos.threat.getAmenazasRey(i, j);
        } else if (p instanceof Alfil) {
            movimientos.threat.getAmenazasAlfil(i, j, p);
        } else if (p instanceof Caballo) {
            movimientos.threat.getAmenazasCaballo(i, j, p);
        }
    }

    public boolean isShortRoll(int i, int j) {
        Rey rey = (Rey) Util.piezaTemporal;
        if (!rey.seMovio && !rey.estaEnjake) {//si no se movio el rey y no esta en jake
            if (!Util.tableroInvertido) {
                Casilla c = tablero.casillas[i][j + 1];
                Casilla c2 = tablero.casillas[i][j + 2];
                Casilla c3 = tablero.casillas[i][j + 3];//torre
                if (c.pieza == null && c2.pieza == null && c3.pieza != null) {//si hay espacio
                    if (!c.tieneAmenaza && !c.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza) {//si no hay amenza en el tramo
                        if ((c3.pieza instanceof Torre) && !c3.pieza.seMovio) {
                            if (!c3.pieza.seMovio) {//no se movio la torre
                                if (Util.mostrarPosibleJugada && !jugadorActual.PC) {
                                    c2.setBackground(Util.walking);
                                    c.setBackground(Util.walking);
                                }
                                c.habilitado = true;
                                c2.habilitado = true;
                                return true;
                            }
                        }
                    }
                }
            } else {
                Casilla c = tablero.casillas[i][j - 1];
                Casilla c2 = tablero.casillas[i][j - 2];
                Casilla c3 = tablero.casillas[i][j - 3];//torre
                if (c.pieza == null && c2.pieza == null && c3.pieza != null) {//si hay espacio
                    if (!c.tieneAmenaza && !c.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza) {//si no hay amenza en el tramo
                        if ((c3.pieza instanceof Torre) && !c3.pieza.seMovio) {
                            if (!c3.pieza.seMovio) {//no se movio la torre
                                if (Util.mostrarPosibleJugada && !jugadorActual.PC) {
                                    c2.setBackground(Util.walking);
                                    c.setBackground(Util.walking);
                                }
                                c.habilitado = true;
                                c2.habilitado = true;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isLargeRoll(int i, int j) {
        Rey rey = (Rey) Util.piezaTemporal;
        if (!rey.seMovio && !rey.estaEnjake) {//si no se movio el rey y no esta en jake
            if (!Util.tableroInvertido) {
                Casilla c = tablero.casillas[i][j - 1];
                Casilla c1 = tablero.casillas[i][j - 2];
                Casilla c2 = tablero.casillas[i][j - 3];
                Casilla c3 = tablero.casillas[i][j - 4];//torre

                if (c.pieza == null && c1.pieza == null && c2.pieza == null && c3.pieza != null) {//si hay espacio
                    if (!c.tieneAmenaza && !c1.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza) {//si no hay amenza en el tramo
                        if ((c3.pieza instanceof Torre) && !c3.pieza.seMovio) {
                            if (!c3.pieza.seMovio) {//no se movio la torre
                                if (Util.mostrarPosibleJugada && !jugadorActual.PC) {
                                    c1.setBackground(Util.walking);
                                    c.setBackground(Util.walking);
                                }
                                c.habilitado = true;
                                c1.habilitado = true;
                                return true;
                            }
                        }
                    }
                }
            } else {
                Casilla c = tablero.casillas[i][j + 1];
                Casilla c1 = tablero.casillas[i][j + 2];
                Casilla c2 = tablero.casillas[i][j + 3];
                Casilla c3 = tablero.casillas[i][j + 4];//torre

                if (c.pieza == null && c1.pieza == null && c2.pieza == null && c3.pieza != null) {//si hay espacio
                    if (!c.tieneAmenaza && !c1.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza) {//si no hay amenza en el tramo
                        if ((c3.pieza instanceof Torre) && !c3.pieza.seMovio) {
                            if (!c3.pieza.seMovio) {//no se movio la torre
                                if (Util.mostrarPosibleJugada && !jugadorActual.PC) {
                                    c1.setBackground(Util.walking);
                                    c.setBackground(Util.walking);
                                }
                                c.habilitado = true;
                                c1.habilitado = true;
                                return true;
                            }
                        }
                    }
                }
            }

        }
        return false;
    }

    void setShortRoll(int i, int j, Pieza p) {
        if (!Util.tableroInvertido) {
            Casilla c = tablero.casillas[i][j + 1];//enrosque torre
            Casilla c2 = tablero.casillas[i][j + 2];//enrrosque rey
            Casilla c3 = tablero.casillas[i][j + 3];//torre
            if (!c.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza && c3.pieza != null) {

                mover(p, c2);
                c.habilitado = true;
                mover(c3.pieza, c);
                refreshLogger(jugadorActual.movimientos + ":" + "0-0");
            }
        } else {
            Casilla c = tablero.casillas[i][j - 1];//enrosque torre
            Casilla c2 = tablero.casillas[i][j - 2];//enrrosque rey
            Casilla c3 = tablero.casillas[i][j - 3];//torre
            if (!c.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza && c3.pieza != null) {

                mover(p, c2);
                c.habilitado = true;
                mover(c3.pieza, c);
                refreshLogger(jugadorActual.movimientos + ":" + "0-0");
            }
        }
        jugadorActual.movimientos++;
        updateTableForRoll(0);
        updatetableForJugMovio();
        if (conexion == null) {
            nextTurn();
        }

    }

    void updatetableForJugMovio() {

        if (conexion != null) {
            try {
                if (jugadorActual.nombre.equals(jugador1.nombre)) {
                    ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET jug1_semovio='" + true + "'");
                } else {
                    ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET jug2_semovio='" + true + "'");

                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void updateTableForMove(String casilla_ini, String casilla_fin) {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET casilla_inicio='" + casilla_ini + "', casilla_fin='" + casilla_fin + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void updateTableForLogger(String logger) {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE controlador SET logger='" + logger + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void updateTableForRoll(int roll) {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET enrosque='" + roll + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void updateTableForTimer() {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET min1='" + j1Timer.min + "',seg1='" + j1Timer.seg + "',hor1='" + j1Timer.hour + "',min2='" + j2Timer.min + "',seg2='" + j2Timer.seg + "',hor2='" + j2Timer.hour + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void updateTableForPiezaEnMeta(Pieza p, String piezaenmeta) {
        if (conexion != null) {
            String pc = "caballo";
            if (p instanceof Torre) {
                pc = "torre";
            } else if (p instanceof Dama) {
                pc = "dama";
            } else if (p instanceof Alfil) {
                pc = "alfil";
            }
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET piezacambiada='" + pc + "',piezaenmeta='" + piezaenmeta + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    void updateTablePeonAlPaso(String casilla) {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET peonalpaso='" + casilla + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void updateTableCasillaComidaPAP(String casillaComPAP) {
        if (conexion != null) {
            try {
                ResultSet rs1 = conexion.ejecutarConsulta("UPDATE data SET casillacomida_pap='" + casillaComPAP + "'");

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void setLargeRoll(int i, int j, Pieza p) {
        if (!Util.tableroInvertido) {
            Casilla c = tablero.casillas[i][j - 1];//casilla al lado del rey
            Casilla c1 = tablero.casillas[i][j - 2];//enrosque torre
            Casilla c2 = tablero.casillas[i][j - 3];//enrrosque rey
            Casilla c3 = tablero.casillas[i][j - 4];//torre
            if (!c.tieneAmenaza && !c1.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza && c3.pieza != null) {

                mover(p, c1);
                c.habilitado = true;
                mover(c3.pieza, c);
                refreshLogger(jugadorActual.movimientos + ":" + "0-0-0");

            }
        } else {
            Casilla c = tablero.casillas[i][j + 1];//casilla al lado del rey
            Casilla c1 = tablero.casillas[i][j + 2];//enrosque torre
            Casilla c2 = tablero.casillas[i][j + 3];//enrrosque rey
            Casilla c3 = tablero.casillas[i][j + 4];//torre
            if (!c.tieneAmenaza && !c1.tieneAmenaza && !c2.tieneAmenaza && !c3.tieneAmenaza && c3.pieza != null) {

                mover(p, c1);
                c.habilitado = true;
                mover(c3.pieza, c);
                refreshLogger(jugadorActual.movimientos + ":" + "0-0-0");
            }
        }
        jugadorActual.movimientos++;
        updateTableForRoll(1);
        updatetableForJugMovio();
        if (conexion == null) {
            nextTurn();
        }
    }

    void setCasillaTapandoJake(LinkedList<Coordenada> lc) {
        for (int i = 0; i < lc.size(); i++) {
            Coordenada co = lc.get(i);
            tablero.casillas[co.i][co.j].tapandoJake = true;
        }
    }

    //------------------PAINT-------------------------------
    void paintWay(Casilla c) {
        Coordenada cor = tablero.getCoordenada(c);
//        if (!tablero.casillas[arr[0]][arr[1]].tapandoJake) {
        paintPath(cor.i, cor.j, Util.piezaTemporal);
//        }

    }

    void paintPath(int i, int j, Pieza p) {
        if (p instanceof Peon) {
            movimientos.paint.paintPath_PEON(i, j, p);
        } else if (p instanceof Torre) {
            movimientos.paint.paintPath_TORRE(i, j, p);
        } else if (p instanceof Dama) {
            movimientos.paint.paintPath_DAMA(i, j, p);
        } else if (p instanceof Rey) {
            movimientos.paint.paintPath_REY(i, j);
        } else if (p instanceof Alfil) {
            movimientos.paint.paintPath_ALFIL(i, j, p);
        } else if (p instanceof Caballo) {
            movimientos.paint.paintPath_CABALLO(i, j, p);
        }
    }

    void setCanWalk() {
        for (int i = 0; i < jugadorActual.piezas.size(); i++) {
            Pieza p = jugadorActual.piezas.get(i);
            Coordenada cor = tablero.getCoordenada(p.casilla);
            if (p instanceof Peon) {
                movimientos.canWalk.canWalk_PEON(cor.i, cor.j, p);
            } else if (p instanceof Rey) {
                movimientos.canWalk.canWalk_REY(cor.i, cor.j, p);
            } else if (p instanceof Dama) {
                movimientos.canWalk.canWalk_DAMA(cor.i, cor.j, p);
            } else if (p instanceof Torre) {
                movimientos.canWalk.canWalk_TORRE(cor.i, cor.j, p);
            } else if (p instanceof Alfil) {
                movimientos.canWalk.canWalk_ALFIL(cor.i, cor.j, p);
            } else if (p instanceof Caballo) {
                movimientos.canWalk.canWalk_CABALLO(cor.i, cor.j, p);
            }
        }
    }

}
