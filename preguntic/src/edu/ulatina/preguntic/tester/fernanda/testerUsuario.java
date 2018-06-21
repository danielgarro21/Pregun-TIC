
package edu.ulatina.preguntic.tester.fernanda;


import edu.ulatina.preguntic.accion.ServicioRol;
import edu.ulatina.preguntic.accion.ServicioUsuario;
import edu.ulatina.preguntic.objetos.Rol;
import edu.ulatina.preguntic.objetos.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class testerUsuario {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

     public static void mostrarMenu() {
        out.println("\n===========================================================");
        //Ver lista de usuarios
        out.println("1.Ver la lista de usuarios.");
        //Insertar un usuario
        out.println("2.Insertar un usuario.");
        //Eliminar un usuario
        out.println("3.Eliminar un usuario.");
        //Modificar un usuario
        out.println("4.Modificar un usuario.");
        //Salir del programa
        out.println("5.Salir.");
        out.println("===========================================================\n");
    }

    public static int leerOpcion() throws java.io.IOException {
        //lee la Opcion Ingresada Por El Usuario
        int opcion;
        out.println("\n===========================================================\n");
        out.print("Seleccione su opción:\n");
        opcion = Integer.parseInt(in.readLine());
        out.println("\n===========================================================\n");

        return opcion;
    }

    public static boolean ejecutarAccionMenuInicio(int opcion) throws java.io.IOException {
        //Scanner Utilizado Para Leer Dentro De La Consola Segun El tipo De Dato Sea Necesario
        Scanner sc = new Scanner(System.in);
        //entero Para Guardar La Opcion Elegida
        boolean noSalir = true;

        switch (opcion) {

            case 1: //Ver la lista de usuario
                ServicioUsuario sVerUsuario = new ServicioUsuario();
                for (Usuario u : sVerUsuario.listarUsuarios()) {
                    System.out.println(u);
                }
                break;

            case 2://Insertar un usuario
                ServicioUsuario sAgregarUsuario = new ServicioUsuario();
                ServicioRol sAgregarRolAUsuario= new ServicioRol();
                List<Rol> lstRoles=sAgregarRolAUsuario.listarRoles();
                out.print("\n===========================================================\n");
                out.print("Ingrese su carnet.\n");
                int carnet=sc.nextInt();
                out.print("Ingrese su cedula.\n");
                int cedula=sc.nextInt();
                out.print("Ingrese su nombre.\n");
                String nombre=in.readLine();
                out.print("Ingrese su apellido.\n");
                String apellido=in.readLine();
                out.print("Ingrese su contrasena.\n");
                String contrasena=in.readLine();
                out.print("Ingrese su correo.\n");
                String correo=in.readLine();
                out.print("Ingrese su numero de telefono.\n");
                String telefono=in.readLine();
                out.print("Ingrese la sede en la que estudia.\n");
                String sede=in.readLine();
                out.print("Ingrese el codigo de su carrera.\n");
                int codigoCarrera=sc.nextInt();
                Date fechaCreacion=Date.valueOf(LocalDate.now());
                out.print("La fecha se ingresara por default, la actual sera:\n"+fechaCreacion+"\n");
                Rol rolUsuarioNuevo=lstRoles.get(0);
                out.print("El rol se ingresara por default, la actual sera: \n"+rolUsuarioNuevo+"\n");
                int puntuacion=0;
                out.print("La puntuacion inicial se ingresara por default, la actual sera:\n"+puntuacion+"\n");
                boolean estado=false;
                out.print("El estado se ingresara por default, la actual sera:\n Inactiva\n");
                out.print("\n===========================================================");
                Usuario uNuevoUsuario= new Usuario(carnet, cedula, nombre, apellido, contrasena, correo, telefono, sede, codigoCarrera, fechaCreacion, rolUsuarioNuevo, puntuacion, estado);
                sAgregarUsuario.agregarUsuario(uNuevoUsuario);
                break;

            case 3://Eliminar un usuario
                ServicioUsuario sEliminarUsuario=new ServicioUsuario();
                sEliminarUsuario.eliminarUsuario();
                break;
            case 4://Modificar un usuario
                ServicioUsuario sModificarUsuario=new ServicioUsuario();
                Usuario usuarioModificado=null;
                List<Usuario> lstUsuariosVerifica=sModificarUsuario.listarUsuarios();
                int carnetAModificar;
                out.print("\n============================Carnet=========================\n");
                out.print("Ingrese el carnet del usuario a modificar.\n");
                carnetAModificar=sc.nextInt();
                out.print("\n===========================================================");
                for(Usuario u:lstUsuariosVerifica){
                    if(carnetAModificar==u.getCarnet()){
                        usuarioModificado=u;
                    }
                }
                
                out.print("\n===========================================================\n");
                out.print("Ingrese el nuevo nombre de su usuario.\n");
                usuarioModificado.setNombre(in.readLine());
                out.print("Ingrese el nuevo apellido de su usuario.\n");
                usuarioModificado.setApellido(in.readLine());
                out.print("Ingrese su nueva contrasena.\n");
                usuarioModificado.setContrasena(in.readLine());
                out.print("Ingrese el nuevo correo de su usuario.\n");
                usuarioModificado.setCorreo(in.readLine());
                out.print("Ingrese el nuevo numero de telefono de su usuario.\n");
                usuarioModificado.setTelefono(in.readLine());
                out.print("Ingrese la sede a la que se traslado.\n");
                usuarioModificado.setSede(in.readLine());
                out.print("Ingrese el codigo de la carrera a la que se paso.\n");
                usuarioModificado.setCodigoCarrera(sc.nextInt());
                out.print("\n===========================================================");
                
                sModificarUsuario.modificarUsuario(usuarioModificado, carnetAModificar);


                break;
            case 5://Salir del sistema por completo

                noSalir = false;

                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inválida");
                out.println();
                break;
        }
        return noSalir;
    }

    public static void main(String[] args) {
        boolean noSalir = true;
        do {  
            mostrarMenu();
            try {
                noSalir=ejecutarAccionMenuInicio(leerOpcion());
            } catch (IOException ex) {
                System.out.println("???");
            }
        } while (noSalir==true);
        
        
        
    }
    
}
