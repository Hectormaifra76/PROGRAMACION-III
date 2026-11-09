import java.util.List;
import java.util.Scanner;

public class PersonasVista {
    private final Scanner teclado;

    public PersonasVista(Scanner teclado) { this.teclado = teclado; }

    public void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE PERSONAS =====");
        System.out.println("1. Importar personas desde un fichero TSV");
        System.out.println("2. Mostrar personas en forma de tabla");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerOpcion() {
        try { return Integer.parseInt(teclado.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    public String leerNombreFichero() {
        System.out.print("Nombre del fichero TSV (situado en el Escritorio): ");
        return teclado.nextLine().trim();
    }

    public boolean confirmarSalida() {
        System.out.print("¿Estás seguro de que quieres salir? (s/n): ");
        return teclado.nextLine().trim().equalsIgnoreCase("s");
    }

    public void mostrarPersonas(List<Persona> personas) {
        if (personas.isEmpty()) {
            System.out.println("No hay personas para mostrar.");
            return;
        }
        System.out.println("\n" + Persona.obtenerCabecera());
        System.out.println("-".repeat(57));
        for (Persona persona : personas) System.out.println(persona.toFila());
    }

    public void mostrarMensaje(String mensaje) { System.out.println(mensaje); }
}
