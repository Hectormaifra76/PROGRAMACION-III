import java.util.List; import java.util.Scanner;
public class ListaDeClaseVista {
 private final Scanner teclado; public ListaDeClaseVista(Scanner teclado){this.teclado=teclado;}
 public void mostrarMenu(){System.out.println("\n===== LISTA DE CLASE =====\n1. Volver a crear la lista de alumnos\n2. Mostrar tabla de alumnos\n3. Exportar datos personales (CSV)\n4. Exportar direcciones (CSV)\nq. Salir\nElige una opción: ");}
 public String leerOpcion(){return teclado.nextLine().trim();}
 public void mostrarAlumnos(List<DatosDeAlumno> alumnos){if(alumnos.isEmpty()){System.out.println("No hay alumnos.");return;}System.out.println("\n"+DatosDeAlumno.obtenerCabecera());System.out.println("-".repeat(125));for(DatosDeAlumno a:alumnos)System.out.println(a.toFila());}
 public String pedirNombreArchivo(String tipo){System.out.print("Nombre del archivo "+tipo+" (ejemplo alumnos.csv): ");return teclado.nextLine().trim();}
 public void mostrarMensaje(String s){System.out.println(s);}
}
