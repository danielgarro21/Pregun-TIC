/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
import edu.ulatina.preguntic.model.Rol;
import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioRol;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServicioCorreo extends Servicio{
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
    
    
    public List<Usuario> buscarTodos() {

        List<Usuario> lstUsuario = new ArrayList<Usuario>();
            ResultSet rs = null;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT correo FROM tbl_usuario";
            rs = stmt.executeQuery(sql);

            //STEP 3.1: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                String correo = rs.getString("correo");

                Usuario u = null;
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
        return lstUsuario;
    }
     public int actualizarUsuarioEstado(Usuario usuario) {

        int cantRegistrosActualizo = 0;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE tbl_usuario SET estado = '" + usuario.isEstado() + "' WHERE correo=" + usuario.getCorreo();
            System.out.println(sql);
            cantRegistrosActualizo = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No se puedo realizar la consulta de usuarios...");
        } finally {
            try {
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
        return cantRegistrosActualizo;
    }
       public int actualizarContrasena(Usuario user) {

        int cantRegistrosActualizo = 0;
        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE tbl_usuario SET contrasena = '" + user.getContrasena() + "' WHERE correo=" + user.getCorreo();
            System.out.println(sql);
            cantRegistrosActualizo = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No se puedo realizar la consulta de usuarios...");
        } finally {
            try {
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
        return cantRegistrosActualizo;
    }

    
    
}
