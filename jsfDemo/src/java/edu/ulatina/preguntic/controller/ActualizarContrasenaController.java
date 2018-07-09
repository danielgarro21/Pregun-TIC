/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;

import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioCorreo;
import edu.ulatina.preguntic.service.ServicioUsuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "actualizarContrasenaController")
@SessionScoped
public class ActualizarContrasenaController {
    private String correo;
    private String contrasenaVieja;
    private String contrasenaNueva;
    private List<Usuario> listaUsuario;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaVieja() {
        return contrasenaVieja;
    }

    public void setContrasenaVieja(String contrasenaVieja) {
        this.contrasenaVieja = contrasenaVieja;
    }

    public String getContrasenaNueva() {
        return contrasenaNueva;
    }

    public void setContrasenaNueva(String contrasenaNueva) {
        this.contrasenaNueva = contrasenaNueva;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
     public boolean actualizarContrasena(String correo, String contrasenaVieja, String contrasenaNueva){
         ServicioUsuario sU=new ServicioUsuario();
        boolean bandera=false;
        Usuario user=null;
         for (Usuario u : sU.listarUsuarios()) {
             if(u.getCorreo().equals(correo)){
                 user=u;
             }
         }
        
 
        
        ServicioCorreo servicioCorreo = new ServicioCorreo();
        boolean resultado;
        for (Usuario u : sU.listarUsuarios()) {
           if(u.getCorreo()==correo && u.getContrasena()==contrasenaVieja){
            user.setContrasena(contrasenaNueva);
            servicioCorreo.actualizarContrasena(user);
            bandera=true;
           }else{
            bandera=false;
            
           }
           
        }
        return bandera;

    }
    
    
}
