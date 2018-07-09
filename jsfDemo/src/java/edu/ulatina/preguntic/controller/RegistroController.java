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
    private Date fechaCaducacion;
    
    public String registro(){
        ServicioUsuario sRegistro= new ServicioUsuario();
        ServicioRol sRolRegistro= new ServicioRol();
        boolean bandera=false;
        this.fechaCreacion=Date.valueOf(LocalDate.now());
        this.rolUsuario=sRolRegistro.listarRoles().get(0);
        this.puntuacion=0;
        this.estado=false;
        this.fechaCaducacion=Date.valueOf(LocalDate.now());
        Usuario registarUsuario=new Usuario(carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrera, fechaCreacion, rolUsuario, puntuacion, estado, fechaCaducacion);
        sRegistro.agregarUsuario(registarUsuario);
        
        for (Usuario u : sRegistro.listarUsuarios()) {
           if(u.getCarnet()==carnet){
            bandera=true;
            }
           
        }
        if(bandera=true){
            return "SI";
            }else{
        return "NO";
        } 
    }
    public String acuerdosYLicencias(){
        return "ACUERDOSYLICENCIAS";
    }
    public void mostrarAcuerdos(){
        String acuerdos= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt tortor vel leo commodo, in tempus enim varius. Etiam ut dolor dui. Vestibulum posuere nisi et mi sollicitudin convallis. Proin sagittis justo est, in fringilla nunc iaculis at. In ante nisi, varius vel porttitor sed, egestas id dui. Vivamus non commodo ex. Duis convallis risus purus, a semper tortor elementum a. Praesent ornare egestas eros, in scelerisque nisl congue hendrerit. Aliquam non efficitur nisi.\n"
                + "\n"
                + "Nulla eget dapibus nisl. Fusce congue, libero eu convallis sollicitudin, urna nibh tincidunt mauris, id consequat diam massa ac ipsum. Duis vulputate, lectus sit amet molestie iaculis, lectus elit auctor ex, vel sagittis mi risus varius lectus. Nunc hendrerit, enim quis convallis egestas, ante lacus lobortis tellus, nec eleifend est arcu id lorem. Ut tempus elit felis. Maecenas eleifend augue id feugiat imperdiet. Suspendisse hendrerit, tellus id mattis congue, erat justo laoreet justo, sit amet facilisis justo ex in risus. Curabitur fringilla porta iaculis. Nunc hendrerit consequat est at fringilla. Sed nec sem ipsum. Pellentesque a mi ac lectus egestas interdum et a sem. Sed sodales urna enim, vel mollis urna semper sit amet. Integer diam quam, faucibus eu nisl ac, sagittis interdum urna. Sed dictum a velit hendrerit vestibulum. Aliquam sed accumsan quam. Cras non tristique urna, id volutpat turpis.\n"
                + "\n"
                + "Nulla viverra dui ac porttitor porta. Cras vel elit blandit lacus commodo scelerisque. Aenean auctor risus eget hendrerit rutrum. Proin vitae sodales risus, vitae imperdiet neque. Nullam pellentesque nunc risus, id commodo quam imperdiet id. Fusce elementum lectus nisi, ac suscipit purus congue at. Nulla consectetur venenatis odio sed consectetur. Quisque vel turpis vel tortor accumsan faucibus ac quis nunc. Maecenas sit amet metus erat. Maecenas sodales vestibulum purus id venenatis. Aliquam id ex ante. Donec ut odio nisi.\n"
                + "\n"
                + "Sed vitae diam quis enim rutrum commodo. Nunc nec felis ultricies nulla maximus euismod sit amet et velit. Vestibulum sollicitudin, urna sed facilisis cursus, odio ex laoreet elit, nec ultricies augue risus non turpis. Quisque gravida massa non dui consectetur rhoncus. Sed eget odio quis felis sollicitudin gravida. Morbi ullamcorper molestie volutpat. Morbi ligula nulla, semper eget condimentum ac, consectetur in neque. Donec at diam nibh.\n"
                + "\n"
                + "Curabitur pellentesque sodales augue vel commodo. Donec mollis in nisl ac dignissim. Phasellus velit purus, condimentum ut neque sit amet, aliquam pulvinar lorem. Nulla facilisi. Phasellus vitae nisl nisi. Cras pellentesque tincidunt nulla. Etiam eros nunc, tincidunt non dolor id, suscipit euismod quam. Morbi pellentesque elit ligula, vitae porta urna gravida at.\n"
                + "\n"
                + "Pellentesque ipsum diam, ultrices sed odio a, blandit bibendum justo. Praesent mi erat, accumsan vel ornare in, luctus eget felis. Quisque aliquet sed lectus at suscipit. Donec id diam quam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc ultrices, arcu eget placerat egestas, urna nisi pharetra libero, id bibendum purus mauris eget sem. In vestibulum mattis lacus a consequat. Ut vehicula gravida nulla a consequat. Maecenas id velit pharetra urna ornare cursus et eget ligula. Quisque sapien ex, interdum vitae urna nec, convallis sollicitudin lectus. Cras placerat massa felis, sit amet ultrices ligula condimentum sed. Vivamus at fermentum sem. Donec sed accumsan enim. Proin convallis vehicula purus ut laoreet. Nunc auctor bibendum nunc, non hendrerit mauris pretium sit amet.\n"
                + "\n"
                + "Nam id condimentum est. Vestibulum condimentum viverra erat eget mollis. Pellentesque sed maximus eros. Duis efficitur scelerisque ligula. Vestibulum id finibus lorem, ac sodales lorem. Phasellus feugiat est sit amet elit auctor consectetur. Suspendisse molestie, metus vel accumsan luctus, felis mi maximus enim, faucibus ornare lacus purus et massa. Nullam egestas lectus in nulla maximus, vitae maximus lacus tincidunt. Donec pulvinar viverra tempus. Fusce sit amet lorem at arcu volutpat accumsan quis at orci.\n"
                + "\n"
                + "Suspendisse ultricies, urna ac porttitor vehicula, dui enim sodales nibh, ut suscipit sem est at mauris. Cras quis libero sed velit consequat sodales. Fusce eget consectetur massa. Praesent id arcu quis nisl viverra porttitor ullamcorper at mi. Vestibulum consequat lacus et accumsan aliquet. Donec a interdum felis. Vestibulum sit amet felis odio. Quisque eget rhoncus ex. Curabitur feugiat tincidunt erat quis pellentesque.\n"
                + "\n"
                + "Vivamus ac vulputate nibh, sed fringilla metus. Proin ex nisi, sagittis sit amet dignissim in, egestas ut mi. Etiam aliquam elit vel fermentum luctus. Pellentesque sit amet sapien accumsan, lacinia diam in, tempus massa. Ut turpis leo, mollis id interdum et, consequat non odio. Donec aliquet sit amet tortor placerat consequat. Nunc vel egestas velit, vel faucibus tellus. Mauris nec orci eget nulla lobortis lacinia ut eu tortor. Cras accumsan laoreet felis a scelerisque.\n"
                + "\n"
                + "Pellentesque varius massa eu nibh suscipit vulputate. Proin sit amet eros at nulla fringilla dapibus consequat euismod justo. Vivamus ornare fermentum nisl, at ornare massa placerat at. Etiam cursus, ligula quis dictum finibus, urna ipsum porta lectus, vitae elementum neque felis nec eros. Aliquam luctus, nibh at faucibus fermentum, sapien odio imperdiet lorem, non sodales tellus massa ac arcu. Donec augue nulla, accumsan quis sagittis quis, auctor in est. Donec finibus leo nunc, vitae condimentum sem efficitur nec. Integer a efficitur est, quis hendrerit nisl. Curabitur at orci dapibus, bibendum justo eu, maximus felis. Sed quis consequat nisl. Etiam venenatis nisi sed dolor mollis, eget facilisis velit lacinia. Aenean ultrices in tortor non sagittis.\n"
                + "\n"
                + "Donec nunc arcu, tempor quis diam vel, vestibulum sagittis enim. Sed luctus massa justo, a euismod odio eleifend non. Morbi consequat volutpat ante at iaculis. Quisque quis neque eget enim venenatis placerat. Quisque non est sed massa finibus fringilla. Curabitur porta pretium odio eget pharetra. Fusce scelerisque fermentum odio, id maximus enim ullamcorper nec. Donec ipsum augue, tempor eget velit quis, faucibus condimentum sem. Vivamus libero libero, consectetur sit amet arcu ac, posuere pharetra nisl. Vivamus consectetur posuere blandit. Fusce ac justo lobortis, auctor massa vitae, egestas nisl.";
    }
    public void mostrarLicencias(){
      String licencias= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt tortor vel leo commodo, in tempus enim varius. Etiam ut dolor dui. Vestibulum posuere nisi et mi sollicitudin convallis. Proin sagittis justo est, in fringilla nunc iaculis at. In ante nisi, varius vel porttitor sed, egestas id dui. Vivamus non commodo ex. Duis convallis risus purus, a semper tortor elementum a. Praesent ornare egestas eros, in scelerisque nisl congue hendrerit. Aliquam non efficitur nisi.\n"
                + "\n"
                + "Nulla eget dapibus nisl. Fusce congue, libero eu convallis sollicitudin, urna nibh tincidunt mauris, id consequat diam massa ac ipsum. Duis vulputate, lectus sit amet molestie iaculis, lectus elit auctor ex, vel sagittis mi risus varius lectus. Nunc hendrerit, enim quis convallis egestas, ante lacus lobortis tellus, nec eleifend est arcu id lorem. Ut tempus elit felis. Maecenas eleifend augue id feugiat imperdiet. Suspendisse hendrerit, tellus id mattis congue, erat justo laoreet justo, sit amet facilisis justo ex in risus. Curabitur fringilla porta iaculis. Nunc hendrerit consequat est at fringilla. Sed nec sem ipsum. Pellentesque a mi ac lectus egestas interdum et a sem. Sed sodales urna enim, vel mollis urna semper sit amet. Integer diam quam, faucibus eu nisl ac, sagittis interdum urna. Sed dictum a velit hendrerit vestibulum. Aliquam sed accumsan quam. Cras non tristique urna, id volutpat turpis.\n"
                + "\n"
                + "Nulla viverra dui ac porttitor porta. Cras vel elit blandit lacus commodo scelerisque. Aenean auctor risus eget hendrerit rutrum. Proin vitae sodales risus, vitae imperdiet neque. Nullam pellentesque nunc risus, id commodo quam imperdiet id. Fusce elementum lectus nisi, ac suscipit purus congue at. Nulla consectetur venenatis odio sed consectetur. Quisque vel turpis vel tortor accumsan faucibus ac quis nunc. Maecenas sit amet metus erat. Maecenas sodales vestibulum purus id venenatis. Aliquam id ex ante. Donec ut odio nisi.\n"
                + "\n"
                + "Sed vitae diam quis enim rutrum commodo. Nunc nec felis ultricies nulla maximus euismod sit amet et velit. Vestibulum sollicitudin, urna sed facilisis cursus, odio ex laoreet elit, nec ultricies augue risus non turpis. Quisque gravida massa non dui consectetur rhoncus. Sed eget odio quis felis sollicitudin gravida. Morbi ullamcorper molestie volutpat. Morbi ligula nulla, semper eget condimentum ac, consectetur in neque. Donec at diam nibh.\n"
                + "\n"
                + "Curabitur pellentesque sodales augue vel commodo. Donec mollis in nisl ac dignissim. Phasellus velit purus, condimentum ut neque sit amet, aliquam pulvinar lorem. Nulla facilisi. Phasellus vitae nisl nisi. Cras pellentesque tincidunt nulla. Etiam eros nunc, tincidunt non dolor id, suscipit euismod quam. Morbi pellentesque elit ligula, vitae porta urna gravida at.\n"
                + "\n"
                + "Pellentesque ipsum diam, ultrices sed odio a, blandit bibendum justo. Praesent mi erat, accumsan vel ornare in, luctus eget felis. Quisque aliquet sed lectus at suscipit. Donec id diam quam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc ultrices, arcu eget placerat egestas, urna nisi pharetra libero, id bibendum purus mauris eget sem. In vestibulum mattis lacus a consequat. Ut vehicula gravida nulla a consequat. Maecenas id velit pharetra urna ornare cursus et eget ligula. Quisque sapien ex, interdum vitae urna nec, convallis sollicitudin lectus. Cras placerat massa felis, sit amet ultrices ligula condimentum sed. Vivamus at fermentum sem. Donec sed accumsan enim. Proin convallis vehicula purus ut laoreet. Nunc auctor bibendum nunc, non hendrerit mauris pretium sit amet.\n"
                + "\n"
                + "Nam id condimentum est. Vestibulum condimentum viverra erat eget mollis. Pellentesque sed maximus eros. Duis efficitur scelerisque ligula. Vestibulum id finibus lorem, ac sodales lorem. Phasellus feugiat est sit amet elit auctor consectetur. Suspendisse molestie, metus vel accumsan luctus, felis mi maximus enim, faucibus ornare lacus purus et massa. Nullam egestas lectus in nulla maximus, vitae maximus lacus tincidunt. Donec pulvinar viverra tempus. Fusce sit amet lorem at arcu volutpat accumsan quis at orci.\n"
                + "\n"
                + "Suspendisse ultricies, urna ac porttitor vehicula, dui enim sodales nibh, ut suscipit sem est at mauris. Cras quis libero sed velit consequat sodales. Fusce eget consectetur massa. Praesent id arcu quis nisl viverra porttitor ullamcorper at mi. Vestibulum consequat lacus et accumsan aliquet. Donec a interdum felis. Vestibulum sit amet felis odio. Quisque eget rhoncus ex. Curabitur feugiat tincidunt erat quis pellentesque.\n"
                + "\n"
                + "Vivamus ac vulputate nibh, sed fringilla metus. Proin ex nisi, sagittis sit amet dignissim in, egestas ut mi. Etiam aliquam elit vel fermentum luctus. Pellentesque sit amet sapien accumsan, lacinia diam in, tempus massa. Ut turpis leo, mollis id interdum et, consequat non odio. Donec aliquet sit amet tortor placerat consequat. Nunc vel egestas velit, vel faucibus tellus. Mauris nec orci eget nulla lobortis lacinia ut eu tortor. Cras accumsan laoreet felis a scelerisque.\n"
                + "\n"
                + "Pellentesque varius massa eu nibh suscipit vulputate. Proin sit amet eros at nulla fringilla dapibus consequat euismod justo. Vivamus ornare fermentum nisl, at ornare massa placerat at. Etiam cursus, ligula quis dictum finibus, urna ipsum porta lectus, vitae elementum neque felis nec eros. Aliquam luctus, nibh at faucibus fermentum, sapien odio imperdiet lorem, non sodales tellus massa ac arcu. Donec augue nulla, accumsan quis sagittis quis, auctor in est. Donec finibus leo nunc, vitae condimentum sem efficitur nec. Integer a efficitur est, quis hendrerit nisl. Curabitur at orci dapibus, bibendum justo eu, maximus felis. Sed quis consequat nisl. Etiam venenatis nisi sed dolor mollis, eget facilisis velit lacinia. Aenean ultrices in tortor non sagittis.\n"
                + "\n"
                + "Donec nunc arcu, tempor quis diam vel, vestibulum sagittis enim. Sed luctus massa justo, a euismod odio eleifend non. Morbi consequat volutpat ante at iaculis. Quisque quis neque eget enim venenatis placerat. Quisque non est sed massa finibus fringilla. Curabitur porta pretium odio eget pharetra. Fusce scelerisque fermentum odio, id maximus enim ullamcorper nec. Donec ipsum augue, tempor eget velit quis, faucibus condimentum sem. Vivamus libero libero, consectetur sit amet arcu ac, posuere pharetra nisl. Vivamus consectetur posuere blandit. Fusce ac justo lobortis, auctor massa vitae, egestas nisl.";  
    }
    public void regresarRegistro(){
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
                            +"/faces/Registro.xhtml?faces-redirect=true");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void regresarLogin(){
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
