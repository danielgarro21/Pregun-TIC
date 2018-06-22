
package edu.ulatina.preguntic.accion;

import edu.ulatina.preguntic.objetos.Rol;
import edu.ulatina.preguntic.servicio.Servicio;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServicioRol extends Servicio{

    @Override
    public void conectar() {
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se puedo registrar el driver...");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se puedo conectar...");
        }
    }

    @Override
    public void accion() {
        
    }
        public List<Rol> listarRoles() {

        List<Rol> lstRoles = new ArrayList<Rol>();
            ResultSet rs = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, nombre, descripcion FROM tbl_rol";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                Rol r = new Rol(id, nombre, descripcion);
                lstRoles.add(r);
            }
        } catch (Exception ex) {
            System.out.println("No se puedo realizar la consulta de usuarios...");
        } finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!stmt.isClosed()) {
                    stmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("No pude cerrar...");
            }
        }
        return lstRoles;
    }
    
}
