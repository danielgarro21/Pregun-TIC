
package edu.ulatina.preguntic.tester.fernanda;

import edu.ulatina.preguntic.rol.Rol;
import java.util.ArrayList;
import java.util.List;
import edu.ulatina.preguntic.accion.ServicioRol;
import edu.ulatina.preguntic.accion.ServicioUsuario;
import edu.ulatina.preguntic.usuario.Usuario;


public class testerUsuario {

    public static void main(String[] args) {
        List<Usuario> lstUsuario= new ArrayList<>();
        ServicioUsuario su=new ServicioUsuario();
        lstUsuario=su.listarUsuarios();
        for (int i = 0; i < lstUsuario.size(); i++) {
            System.out.println(lstUsuario.get(i));
        }
        
        
        
    }
    
}
