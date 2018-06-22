/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.preguntic.tester.josue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class TesterLicenciasYCondiciones {

    public static void main(String[] args) {
        String licencia
                = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt tortor vel leo commodo, in tempus enim varius. Etiam ut dolor dui. Vestibulum posuere nisi et mi sollicitudin convallis. Proin sagittis justo est, in fringilla nunc iaculis at. In ante nisi, varius vel porttitor sed, egestas id dui. Vivamus non commodo ex. Duis convallis risus purus, a semper tortor elementum a. Praesent ornare egestas eros, in scelerisque nisl congue hendrerit. Aliquam non efficitur nisi.\n"
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
        String acuerodosYDerechos
                = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt tortor vel leo commodo, in tempus enim varius. Etiam ut dolor dui. Vestibulum posuere nisi et mi sollicitudin convallis. Proin sagittis justo est, in fringilla nunc iaculis at. In ante nisi, varius vel porttitor sed, egestas id dui. Vivamus non commodo ex. Duis convallis risus purus, a semper tortor elementum a. Praesent ornare egestas eros, in scelerisque nisl congue hendrerit. Aliquam non efficitur nisi.\n"
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
    boolean noSalir = true;
        do {  
            mostrarMenu();
            try {
                noSalir=ejecutarAccionMenuInicio(leerOpcion(),licencia,acuerodosYDerechos);
            } catch (IOException ex) {
                System.out.println("???");
            }
        } while (noSalir==true);
    }
        
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

     public static void mostrarMenu() {
        out.println("\n===========================================================");
        //Ver licencias a aceptar
        out.println("1.Ver licencias a aceptar.");
        //Ver acuerdos y derechos
        out.println("2.Ver acuerdos y derechos.");
        //Salir del programa
        out.println("3.Salir.");
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

    public static boolean ejecutarAccionMenuInicio(int opcion,String licencias,String acuerdosYLicencias) throws java.io.IOException {
        //Scanner Utilizado Para Leer Dentro De La Consola Segun El tipo De Dato Sea Necesario
        Scanner sc = new Scanner(System.in);
        //entero Para Guardar La Opcion Elegida
        boolean noSalir = true;

        switch (opcion) {

            case 1: //Ver las licencias a aceptar
                out.print(licencias);
                break;

            case 2://Ver los acuerdos y derechos correspondidos
                out.print(acuerdosYLicencias);
                break;
            case 3://Salir del sistema por completo

                noSalir = false;

                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inválida");
                out.println();
                break;
        }
        return noSalir;
    }
    
}
