/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;

import com.mysql.cj.x.protobuf.Mysqlx;
import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioUsuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    private int carnet;
    private String contrasena;
    private List<Usuario> listaUsuarios;
    
    public String ingresar(){
       String aux="NO";
        ServicioUsuario sLogin= new ServicioUsuario();
        
        Usuario usuarioLogearse=sLogin.LoginUsuario(carnet, contrasena);
        this.listaUsuarios=sLogin.listarUsuarios();
        if(usuarioLogearse!=null){
            aux = "SI";
            }
        if((usuarioLogearse!=null)&&(sLogin.verificarFechaContrasena(carnet)<60)){
             aux="CADUCOCONTRASENA" ;  
            }
        return aux;
    }
    public String mandarRegistro(){
        return "REGISTRO";
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
    public Usuario recuperarUsuario(){
        Usuario usuarioLogeado=null;
        for (Usuario u : listaUsuarios) {
            if(this.carnet==u.getCarnet()){
                usuarioLogeado=u;
            }
        }
        return usuarioLogeado;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    
}
