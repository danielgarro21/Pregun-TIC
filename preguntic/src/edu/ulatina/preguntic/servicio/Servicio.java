
package edu.ulatina.preguntic.servicio;

import edu.ulatina.preguntic.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public abstract class Servicio{
    protected String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    protected String DB_URL = "jdbc:mysql://localhost:3306/preguntic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //  Database credentials
    protected String USER = "root";
    protected String PASS = "1shotykillhead";
    protected PreparedStatement paInsertar;
    protected Connection conn = null;
    protected Statement stmt = null;

    
    
    
    
    public abstract void conectar();
    
    public abstract void accion();
    }

