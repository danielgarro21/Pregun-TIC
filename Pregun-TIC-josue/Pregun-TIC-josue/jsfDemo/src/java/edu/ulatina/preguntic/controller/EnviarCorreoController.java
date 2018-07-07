/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.controller;


import edu.ulatina.preguntic.model.Usuario;
import edu.ulatina.preguntic.service.ServicioCorreo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.List;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.websocket.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Carlos Cubillo
 */
@ManagedBean(name = "enviarCorreoController")
@SessionScoped
public class EnviarCorreoController implements Serializable{
    
    
    private String correo;
    
    private List<Usuario> listaUsuario;
    
    
    
    
    public String verificacionCorreo(){

        String str;
        String to;
        String host="";
        
        ServicioCorreo servicioCorreo = new ServicioCorreo();
        boolean resultado;
        boolean bandera=false;
        List<Usuario> lista;
       
        lista = servicioCorreo.buscarTodos();
        for (Usuario u : lista) {
           if(u.getCorreo()==correo){
            bandera=true;
           }else{
            bandera=false;
            
           }
           
        }

        if(bandera=true){
            
            to=correo;

            resultado = enviarCorreoPassword(to);

            return "SI";
 
        }else{
            to="";
            return "NO";
            
        }


//        to=correo;
//        
//        resultado = enviarCorreoPassword(to);
//        if (resultado=true){
//            return "SI";
//        }else{
//            return "NO";
//        
//        }
      

    
    }
    
        
    public String verificacionCorreoDesbloqueo(){
        
        String str;
        String to;
        String host="";
        
        ServicioCorreo servicioCorreo = new ServicioCorreo();
        boolean resultado;
        boolean bandera=false;
        List<Usuario> lista;
       
        lista = servicioCorreo.buscarTodos();
        for (Usuario u : lista) {
           if(u.getCorreo()==correo){
            bandera=true;
           }else{
            bandera=false;
            
           }
           
        }

        if(bandera=true){
            
            to=correo;

            resultado = enviarCorreoDesbloqueo(to);

            return "SI";
 
        }else{
            to="";
            return "NO";
            
        }

    
    }
     
 
    public boolean enviarCorreoPassword(String to){

        String username="PregunticOriginal.Ulatina@gmail.com";
        String password="k64hbDz9#";
        String from;
        from=username;
        String token;

        boolean res=false;
        Properties props=new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug","true");
        

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(username,password);
                }
        });

        token=ContrasenaAleatoriaController.getPassword(
		ContrasenaAleatoriaController.MINUSCULAS+
		ContrasenaAleatoriaController.MAYUSCULAS+
		ContrasenaAleatoriaController.ESPECIALES,10);

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Recuperación de contraseña Preguntic");
            message.setText("Su código temporal para recuperar la contraseña es: " + token);
            Transport.send(message);
            
            //System.out.println("Se ha enviado el mensaje correctamente...");
        
        }catch(MessagingException e){
        
            throw new RuntimeException(e);
        }
            res=true;
            return res;

        }
     
     
     
     public boolean enviarCorreoAceptacionTerminos(String to){

        String username="PregunticOriginal.Ulatina@gmail.com";
        String password="k64hbDz9#";
        String from;
        from=username;
        String token;

        boolean res=false;
        Properties props=new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug","true");
        

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(username,password);
                }
        });

      

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("PregunTIC Aceptacion de Terminos y Condiciones");
            message.setText("Este es un correo de confirmacion que indica que usted ha aceptado los terminos y las condiciones del sistema. Ya puede ingresar a su cuenta. ");
            message.setText("Team PregunTIC");
            Transport.send(message);
            
        
        }catch(MessagingException e){
        
            throw new RuntimeException(e);
        }
            res=true;
            return res;

        }
     
     
       public boolean enviarCorreoDesbloqueo(String to){

        String username="PregunticOriginal.Ulatina@gmail.com";
        String password="k64hbDz9#";
        String from;
        from=username;
        String token;

        boolean res=false;
        Properties props=new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug","true");
        

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(username,password);
                }
        });

                token=ContrasenaAleatoriaController.getPassword(
		ContrasenaAleatoriaController.MINUSCULAS+
		ContrasenaAleatoriaController.MAYUSCULAS+
		ContrasenaAleatoriaController.ESPECIALES,10);
      

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("PregunTIC Aceptacion de Terminos y Condiciones");
            message.setText("Su cuenta ha sido desbloqueada. Ingrese de nuevo a la pagina con la siguiente contraseña: " + token);
            message.setText("Team PregunTIC");
            Transport.send(message);
            
        
        }catch(MessagingException e){
        
            throw new RuntimeException(e);
        }
            res=true;
            return res;

        }
     
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
        public List<Usuario> getListaUsuarios() {
        return listaUsuario;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuario = listaUsuarios;
    }
    
      public String recuperarContrasena(){
        
        return "OLVIDAR"; 
    
    
    }
      
    public String desbloqueoCuenta(){
        
        return "DESBLOQUEO";
    
    
    }

    
}
