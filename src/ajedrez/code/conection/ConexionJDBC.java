/*   Establece la conexion a la base de datos Postgre    */

package ajedrez.code.conection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConexionJDBC {     // declaracion de la clase

    // atributos
    private String host;
    private String puerto;
    private String basedato;
    private String urlJDBC;       // para concatenar host, puerto, basedato
    private String usuario ;
    private String contrasenna;
    public Connection conJDBC;        // tu conexion con JDBC
    private String estado;             // saber estado de la conexion
    

// constructor de la clase
public ConexionJDBC(String host, String puerto , String basedato ,String usuario, String contrasenna ) {
    // el this para incializar los atribtos como sabemos
    this.host = host;
    this.puerto = puerto;
    this.basedato = basedato;
    this.usuario = usuario;
    this.contrasenna = contrasenna;
    this.estado = "Driver JDBC registrado";
    // la sintaxis de la url para JDBC
    this.urlJDBC = "jdbc:postgresql://" + host + ":" + puerto + "/" + basedato ;
    // registrar el Driver JDBC , ver nota1
    try {
    Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception ex) {    // si hay error
         estado = ex.getMessage();  // lo capturo en estado
         System.out.println(estado); // imprimir por consola
        }    
     System.out.println(estado); // imprimir por consola

}

    public ConexionJDBC() {
    }

/*                       nota1
para que funcione tienes que en la ventana de Proyectos / 
clic dercho en Bibliotecas /Agregar Biblioteca / Driver JDBC PostgreSQL
*/


// metodo para conectar con JDBC devuelve String
public String conectarJDBC1()   {
    estado ="Conectado";
    try {
    // conecto con mi BD en Postgre
    conJDBC = DriverManager.getConnection(urlJDBC, usuario, contrasenna);
          } catch (Exception ex) {     // si hay error
    estado = ex.getMessage();    // lo capturo en estado
    System.out.println(estado);  // imprimir por consola
    }
    System.out.println(estado);  // imprimir por consola
    return estado;               // retorna String
}

// metodo para conectar con JDBC devuelve Connection
public Connection conectarJDBC2()   {
     estado ="Conectado";
    try {
    // conecto con mi BD en Postgre
    conJDBC = DriverManager.getConnection(urlJDBC, usuario, contrasenna);
         } catch (Exception ex) {     // si hay error
    estado = ex.getMessage();    // lo capturo en estado
    System.out.println(estado);  // imprimir por consola
    conJDBC = null;              
    return conJDBC;              // retorna null
    }
    System.out.println(estado);  // imprimir por consola
    return conJDBC;              // retorna Connection
}

// metodo para conectar con JDBC devuelve Boolean
public Boolean conectarJDBC3()   {
     estado ="Conectado";
    try {
    // conecto con mi BD en Postgre
    conJDBC = DriverManager.getConnection(urlJDBC, usuario, contrasenna);
      } catch (Exception ex) {     // si hay error
    estado = ex.getMessage();    // lo capturo en estado
    System.out.println(estado);  // imprimir por consola
    return false;                // retorna falso
    }
    System.out.println(estado);  // imprimir por consola
    return true;                 // retorna true
}

public ResultSet ejecutarConsulta(String consultaSQL) throws SQLException{
		ResultSet rs=null;
		try{
		     Statement stament=this.conJDBC.createStatement();
                     rs=stament.executeQuery(consultaSQL);
                } catch (java.sql.SQLException j) {
				return null;
		}
	  return rs;
	}

public Integer ejecutarActualizcion(String update) throws SQLException{
		int rs=0;
		try{
		     Statement stament=this.conJDBC.createStatement();
                     rs=stament.executeUpdate(update);
                } catch (java.sql.SQLException j) {
				return null;
		}
	  return rs;
	}

    public ResultSet ejecutarFuncion(String name,ArrayList<String> parametros)throws SQLException{
           CallableStatement callStoreProc;
               int cantidadParametros = parametros.size();
        String posiblesParametros = "";
        for (int marc = 0; marc < cantidadParametros; marc++) {
            posiblesParametros += "?";
            System.out.println(posiblesParametros);
            if (marc + 1 < cantidadParametros) {
                posiblesParametros += ",";
            }
        }

        callStoreProc = this.conJDBC.prepareCall("{ call " + name + "(" + posiblesParametros + ") }");

        for (int marc = 0; marc < cantidadParametros; marc++) {
            callStoreProc.setObject(marc + 1, parametros.get(marc));
        }
        ResultSet rs=callStoreProc.executeQuery();
        System.out.println("res"+ rs.getString(1));
        //resultSet = callStoreProc.executeQuery();

        //this.cerrarConexion();
        return rs;
	}

    public ResultSet ejecutarvista(String vista) throws SQLException {
      CallableStatement callStProc=this.conJDBC.prepareCall("{ call "+vista+" }");
		ResultSet resultado=callStProc.executeQuery();
	 return resultado;
    }

}
