/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.game;

/**
 *
 * @author Rene
 */
public class PC implements Runnable{

    Controlador controlador;
    

    public PC(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {
    }
    
    
}
