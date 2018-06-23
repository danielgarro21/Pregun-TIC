/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.service;

import edu.ulatina.preguntic.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author murip
 */
public class LoginService {
    //Aquí van todas las clases que van a interacturas con la base de datos
    
    public List<Usuario> buscarTodos(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario usuario = new Usuario("Bernal", "admin");
        usuarios.add(usuario);
        
        usuario = new Usuario("Cinthia", "admin");
        usuarios.add(usuario);
        
        usuario = new Usuario("José", "admin");
        usuarios.add(usuario);
        
        usuario = new Usuario("Mariana", "admin");
        usuarios.add(usuario);
        
        return usuarios;
    }
}
