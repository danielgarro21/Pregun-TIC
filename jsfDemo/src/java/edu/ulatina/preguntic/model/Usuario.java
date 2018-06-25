/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.model;

import java.sql.Date;

/**
 *
 * @author murip
 */
public class Usuario {
    private int carnet;
  private int cedula;
  private String nombre;
  private String apellido;
  private String contrasena;
  private String correo;
  private String telefono;
  private String sede;
  private int codigoCarrera;
  private Date fechaCreacion;
  private Rol rolUsuario;
  private int puntuacion;
  private boolean estado;

    public Usuario(int carnet, int cedula, String nombre, String apellido, String contrasena, String correo, String telefono, String sede, int codigoCarrera, Date fechaCreacion, Rol rolUsuario, int puntuacion, boolean estado) {
        this.carnet = carnet;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.sede = sede;
        this.codigoCarrera = codigoCarrera;
        this.fechaCreacion = fechaCreacion;
        this.rolUsuario = rolUsuario;
        this.puntuacion = puntuacion;
        this.estado = estado;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String estadoActual;
        boolean tempEstado=this.estado;
        if(tempEstado==true){
            estadoActual="Activo";
        }else{
            estadoActual="Inactivo";
        }
      StringBuffer sb = new StringBuffer();
        sb.append("==================================Perfil=====================================\n");
        sb.append("Carnet: " + this.carnet);
        sb.append("\n");
        sb.append("Cedula: " + this.cedula);
        sb.append("\n");
        sb.append("Nombre: " + this.nombre);
        sb.append("\n");
        sb.append("Apellido: " + this.apellido);
        sb.append("\n");
        sb.append("Contrasena: " + "****");
        sb.append("\n");
        sb.append("Correo:" + this.correo);
        sb.append("\n");
        sb.append("Telefono: " + this.telefono);
        sb.append("\n");
        sb.append("Sede: " + this.sede);
        sb.append("\n");
        sb.append("Codigo de carrera: " + this.codigoCarrera);
        sb.append("\n");
        sb.append("Fecha de creacion: " + this.fechaCreacion);
        sb.append("\n");
        sb.append("Rol: \n" + this.rolUsuario);
        sb.append("\n");
        sb.append("Puntuacion: " + this.puntuacion);
        sb.append("\n");
        sb.append("Estado: " + estadoActual);
        sb.append("\n=============================================================================");
        return sb.toString();
    }
  
  
  
    
}
