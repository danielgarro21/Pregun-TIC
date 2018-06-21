package edu.ulatina.preguntic.accion;

import edu.ulatina.preguntic.rol.Rol;
import edu.ulatina.preguntic.servicio.Servicio;
import edu.ulatina.preguntic.usuario.Usuario;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioUsuario extends Servicio {

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

    public void eliminarUsuario() {
        Scanner sc = new Scanner(System.in);
        int carnetUsuario = 0;
        System.out.println("\n======================================Eliminar======================================\n");
        System.out.println("Ingrese el carnet del usuario a eliminar.\n");
        carnetUsuario = sc.nextInt();
        System.out.println("\n====================================================================================\n");

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM tbl_usuario" + " WHERE carnet=(?);";
            paInsertar = conn.prepareStatement(sql);
            paInsertar.setInt(1, carnetUsuario);
            paInsertar.executeUpdate();

        } catch (Exception ex) {
            System.out.println("No se pudo borrar el usuario...");
        } finally {
            try {
                if (!paInsertar.isClosed()) {
                    paInsertar.close();
                }

                if (!stmt.isClosed()) {
                    stmt.close();
                }

                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("\nNo pude cerrar...");
            }
        }

    }

    public void agregarUsuario(Usuario u) {

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO tbl_usuario (carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrera, fechaCreacion, rolUsuario, puntuacion, estado)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            paInsertar = conn.prepareStatement(sql);
            paInsertar.setInt(1, u.getCarnet());
            paInsertar.setInt(2, u.getCedula());
            paInsertar.setString(3, u.getNombre());
            paInsertar.setString(4, u.getApellido());
            paInsertar.setString(5, u.getContrasena());
            paInsertar.setString(6, u.getCorreo());
            paInsertar.setString(7, u.getTelefono());
            paInsertar.setString(8, u.getSede());
            paInsertar.setInt(9, u.getCodigoCarrera());
            paInsertar.setDate(10, u.getFechaCreacion());
            paInsertar.setInt(11, u.getRolUsuario().getId());
            paInsertar.setInt(12, u.getPuntuacion());
            paInsertar.setBoolean(13, u.isEstado());
            paInsertar.executeUpdate();

        } catch (Exception ex) {
            System.out.println("No se pudo crear el usuario...");
        } finally {
            try {
                if (!paInsertar.isClosed()) {
                    paInsertar.close();
                }

                if (!stmt.isClosed()) {
                    stmt.close();
                }

                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("\nNo pude cerrar...");
            }
        }
    }

    public List<Usuario> listarUsuarios() {
        ServicioRol sr = new ServicioRol();
        List<Rol> lstRoles = sr.listarRoles();
        List<Usuario> lstUsuarios = new ArrayList<Usuario>();
        ResultSet rs = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrera, fechaCreacion, rolUsuario, puntuacion, estado  FROM tbl_usuario";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                Rol rolUsuario=null;
                //Retrieve by column name
                int carnet = rs.getInt("carnet");
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String contrasena = rs.getString("contrasena");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String sede = rs.getString("sede");
                int codigoCarrrera = rs.getInt("codigoCarrera");
                Date fechaCreacion = rs.getDate("fechaCreacion");
                for (int i = 0; i < lstRoles.size(); i++) {
                    if (rs.getInt("rolUsuario") == lstRoles.get(i).getId()) {
                         rolUsuario = lstRoles.get(i);
                    }
                }
                int puntuacion=rs.getInt("puntuacion");
                boolean estado= rs.getBoolean("estado");
                Usuario u = new Usuario(carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrrera, fechaCreacion, rolUsuario, puntuacion, estado);
                lstUsuarios.add(u);
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
        return lstUsuarios;
    }

}
