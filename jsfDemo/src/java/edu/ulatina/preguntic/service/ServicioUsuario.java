package edu.ulatina.preguntic.service;

import edu.ulatina.preguntic.model.Rol;
import edu.ulatina.preguntic.model.Usuario;
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

    public void eliminarUsuario() {
        Scanner sc = new Scanner(System.in);
        int carnetUsuario;
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

    public Usuario LoginUsuario(int carnet, String contrasena) {
        List<Usuario> lstUsuarios = this.listarUsuarios();
        Usuario usuarioLogearse = null;
        for (Usuario u : lstUsuarios) {
            if (u.getCarnet() == carnet && u.getContrasena().equals(contrasena)) {
                usuarioLogearse = u;
            }
        }

        return usuarioLogearse;

    }

    public void modificarUsuario(Usuario uActualizado, int carnetModificar) {
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE tbl_usuario SET carnet=(?), cedula=(?), nombre=(?), apellido=(?), contrasena=(?), correo=(?), telefono=(?), sede=(?), codigoCarrera=(?), fechaCreacion=(?), rolUsuario=(?), puntuacion=(?), estado=(?) WHERE carnet=(?)";
            paInsertar = conn.prepareStatement(sql);
            paInsertar.setInt(1, uActualizado.getCarnet());
            paInsertar.setInt(2, uActualizado.getCedula());
            paInsertar.setString(3, uActualizado.getNombre());
            paInsertar.setString(4, uActualizado.getApellido());
            paInsertar.setString(5, uActualizado.getContrasena());
            paInsertar.setString(6, uActualizado.getCorreo());
            paInsertar.setString(7, uActualizado.getTelefono());
            paInsertar.setString(8, uActualizado.getSede());
            paInsertar.setInt(9, uActualizado.getCodigoCarrera());
            paInsertar.setDate(10, uActualizado.getFechaCreacion());
            paInsertar.setInt(11, uActualizado.getRolUsuario().getId());
            paInsertar.setInt(12, uActualizado.getPuntuacion());
            paInsertar.setBoolean(13, uActualizado.isEstado());
            paInsertar.setInt(14, uActualizado.getCarnet());
            paInsertar.executeUpdate();

        } catch (Exception ex) {
            System.out.println("\nNo se pudo Modificar el usuario...");
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
                Rol rolUsuario = null;
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
                int puntuacion = rs.getInt("puntuacion");
                boolean estado = rs.getBoolean("estado");
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
