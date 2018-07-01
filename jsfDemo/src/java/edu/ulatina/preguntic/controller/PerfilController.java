/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;
import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



@ManagedBean(name = "perfilController")
@SessionScoped
public class PerfilController implements Serializable{
   private Usuario usuarioLogeado;
   
   
   public String mostrarPerfil(){
       String mostrarPerfil="VERPERFIL";
       return mostrarPerfil;
   }
   public String regresarAlMenu(){
        String regresar="REGRESARMENUPERFIL"; 
        return regresar;
   }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        
                this.usuarioLogeado = usuarioLogeado;
           
    }
   
   
}
