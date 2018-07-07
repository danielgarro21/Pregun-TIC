
package edu.ulatina.preguntic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public abstract class Servicio {
    protected String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    protected String DB_URL = "jdbc:mysql://localhost:3306/preguntic";
    //  Database credentials
    protected String USER = "root";
    protected String PASS = "Eyy71fn4";
    protected PreparedStatement paInsertar;
    protected Connection conn = null;
    protected Statement stmt = null;

    
    
    
    
    public abstract void conectar();
}
