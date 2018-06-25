/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;


import edu.ulatina.preguntic.model.Rol;
import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioRol;
import edu.ulatina.preguntic.service.ServicioUsuario;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



@ManagedBean(name = "registroController")
@SessionScoped
public class RegistroController implements Serializable{
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
    
    public String registro(){
        ServicioUsuario sRegistro= new ServicioUsuario();
        ServicioRol sRolRegistro= new ServicioRol();
        this.fechaCreacion=Date.valueOf(LocalDate.now());
        this.rolUsuario=sRolRegistro.listarRoles().get(0);
        this.puntuacion=0;
        this.estado=false;
        Usuario registarUsuario=new Usuario(carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrera, fechaCreacion, rolUsuario, puntuacion, estado);
        sRegistro.agregarUsuario(registarUsuario);
        for (Usuario u : sRegistro.listarUsuarios()) {
           if(u.getCarnet()==carnet){
            return "SI";
        }else{
        return "NO";
        } 
        }
            
        
       return "NO";
    }
    public String acuerdosYLicencias(){
        return "ACUERDOSYLICENCIAS";
    }

    public RegistroController() {
    }
    
    public RegistroController(int carnet, int cedula, String nombre, String apellido, String contrasena, String correo, String telefono, String sede, int codigoCarrera, Date fechaCreacion, Rol rolUsuario, int puntuacion, boolean estado) {
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
    
    
}
