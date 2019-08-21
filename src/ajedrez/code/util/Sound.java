package ajedrez.code.util;

import java.applet.*;
import java.io.File;
import java.net.*;

//Clase para los Sonidos...
public final class Sound {

    public static AudioClip warning, conected, disconected, beep, creditos, multi, eat, jake, error, lost, win, move, soundTrak, quest, advice, resetGame, play, pause;

    public static void init() {
        try {
            eat = Applet.newAudioClip(new File("audio/eat.wav").toURI().toURL());
            warning = Applet.newAudioClip(new File("audio/warning.wav").toURI().toURL());
            win = Applet.newAudioClip(new File("audio/win.wav").toURI().toURL());
            lost = Applet.newAudioClip(new File("audio/lost.wav").toURI().toURL());
            jake = Applet.newAudioClip(new File("audio/jake.wav").toURI().toURL());
            error = Applet.newAudioClip(new File("audio/error.wav").toURI().toURL());
            move = Applet.newAudioClip(new File("audio/move.wav").toURI().toURL());
            soundTrak = Applet.newAudioClip(new File("audio/soundTrack.wav").toURI().toURL());
            advice = Applet.newAudioClip(new File("audio/advice.wav").toURI().toURL());
            quest = Applet.newAudioClip(new File("audio/quest.wav").toURI().toURL());
            resetGame = Applet.newAudioClip(new File("audio/resetGame.wav").toURI().toURL());
            play = Applet.newAudioClip(new File("audio/play.wav").toURI().toURL());
            pause = Applet.newAudioClip(new File("audio/pause.wav").toURI().toURL());
            creditos = Applet.newAudioClip(new File("audio/creditos.wav").toURI().toURL());
            beep = Applet.newAudioClip(new File("audio/beep.wav").toURI().toURL());
            conected = Applet.newAudioClip(new File("audio/conected.wav").toURI().toURL());
            disconected = Applet.newAudioClip(new File("audio/disconected.wav").toURI().toURL());
        } catch (MalformedURLException mue) {
        }
    }

    public static void conected() {
        conected.play();
    }

    public static void beep() {
        beep.play();
    }

    public static void jake() {
        jake.play();
    }

    public static void disconected() {
        disconected.play();
    }

    public static void warning() {
        warning.play();
    }

    public static void multi() {
        multi.loop();
    }

    public static void creditos() {
        creditos.loop();
    }

    public static void resetGame() {
        resetGame.play();
    }

    public static void error() {
        error.play();
    }

    public static void play() {
        play.play();
    }

    public static void pause() {
        pause.play();
    }

    public static void quest() {
        quest.play();
    }

    public static void advice() {
        advice.play();
    }

    public static void soundTrak() {
        soundTrak.loop();
    }

    public static void move() {
        move.play();
    }

    public static void lost() {
        lost.play();
    }

    public static void win() {
        win.play();
    }

    public static void eat() {
        eat.play();
    }
}
