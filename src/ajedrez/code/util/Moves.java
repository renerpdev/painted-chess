/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.util;

import ajedrez.code.game.Controlador;
import ajedrez.code.game.PC;

/**
 *
 * @author Rene
 */
public class Moves {

    public Threat_Moves threat;
    public Paint_Moves paint;
    public PC pc;
    public CanWalk canWalk;

    public Moves(Controlador controlador) {
        threat = new Threat_Moves(controlador);
        paint = new Paint_Moves(controlador);
        canWalk = new CanWalk(controlador);
        pc = new PC(controlador);
    }

}
