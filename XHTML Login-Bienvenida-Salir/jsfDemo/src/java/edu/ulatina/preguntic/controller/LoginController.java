/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;

import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.LoginService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author murip
 */

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    private String usuario;
    private String clave;
    private List<Usuario> listaUsuarios;
    
    public String ingresar(){
        LoginService loginService = new LoginService();
        
        List<Usuario> lista = loginService.buscarTodos();
        
        for(Usuario usuarioData : lista){
            if (usuarioData.getUser().equals(this.usuario) && usuarioData.getPass().equals(this.clave)){
                this.listaUsuarios = lista;
                return "SI";
            }
        }
        return "NO";
    }
    
    public void salir(){
        try{
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
            
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            +"/faces/index.xhtml?faces-redirect=true");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    
}
