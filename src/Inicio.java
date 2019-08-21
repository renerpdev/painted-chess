
import ajedrez.code.util.Util;
import ajedrez.visual.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sourceforge.napkinlaf.NapkinLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rene
 */
public class Inicio {

    public static void main(String[] args) {
       
        try {            
            UIManager.setLookAndFeel(new NapkinLookAndFeel());
            Util.setIdioma();
            new SeleccionarIdioma();
        } catch (UnsupportedLookAndFeelException ex) {
        }
//   
        
//         try {
//            UIManager.setLookAndFeel(new WindowsLookAndFeel());
//            Util.setIdioma();
//            new Interfaz("jug1","jug2",false,false);
//        } catch (UnsupportedLookAndFeelException ex) {
//        }
//        
    }
    
    

}
