/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ajedrez.code.conection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rene
 */
public class DatosConexion {
    public String servidor,invitado;
    public boolean mostrar_jug,server_blancas=true,esServidor;
    public int minutos,index_pieza;

    public DatosConexion(String servidor, String invitado, boolean mostrar_jug, int index_pieza,int minutos,boolean esServidor) {
        this.servidor = servidor;
        this.invitado = invitado;
        this.mostrar_jug = mostrar_jug;
        if (index_pieza==1) {
            server_blancas=false;
        }
        this.minutos = minutos;
        this.esServidor=esServidor;
        this.index_pieza=index_pieza;
    }

    public static Object[][] getTableFomResultSet(ResultSet result) {

        ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>(0);
        ArrayList<String> temp;
        int i, j;

        try {

            while (result.next()) {

                temp = new ArrayList<String>();
                for (i = 1; true; ++i) {
                    try {
                        temp.add(result.getString(i));
                    } catch (Exception e) {
                        break;
                    }
                }
                table.add(temp);
            }
        } catch (SQLException ex) {
        }

        int fil = table.size();
        int col = table.get(0).size();
        Object[][] res = new Object[fil][col];

        for (i = 0; i < fil; ++i) {
            for (j = 0; j < col; ++j) {
                res[i][j] = table.get(i).get(j);
            }
        }
        return res;

    }
    
}
