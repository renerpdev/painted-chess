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
public class Coordenada  implements Serializable{
    public int i;
    public int j;

    public Coordenada(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    
}
