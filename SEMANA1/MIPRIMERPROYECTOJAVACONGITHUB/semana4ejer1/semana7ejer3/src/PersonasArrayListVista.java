package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Persona;
import controlador.PersonasArrayListControlador;

public class PersonasArrayListVista {

    private final PersonasArrayListControlador controlador;
    private final Scanner teclado = new Scanner(System.in);

    public PersonasArrayListVista(PersonasArrayListControlador controlador) {
        this.controlador = controlador;
    }

    public void iniciar() {
        String opcion;

        do {
            System.out.println("\n=== CRUD con ArrayList (MVC) ===");
            System.out.println("1. Añadir persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Listar personas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = teclado.nextLine().trim();

            switch (opcion) {
                case "1":
                    anadir();
                    break;
                case "2":
                    System.out.print("Nombre a eliminar: ");
                    mensaje(controlador.eliminar(teclado.nextLine().trim()),
                            "Persona eliminada.", "No existe esa persona.");
                    break;
                case "3":
                    modificar();
                    break;
                case "4":
                    listar();
                    break;
                case "5":
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("5"));
    }

    private void anadir() {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine().trim();

        int edad = leerEntero("Edad: ");
        double altura = leerDouble("Altura en metros (ej. 1,75): ");

        mensaje(controlador.agregar(nombre, edad, altura),
                "Persona añadida.",
                "Ya existe una persona con ese nombre.");
    }

    private void modificar() {
        System.out.print("Nombre actual: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Nuevo nombre: ");
        String nuevo = teclado.nextLine().trim();

        int edad = leerEntero("Nueva edad: ");
        double altura = leerDouble("Nueva altura en metros: ");

        mensaje(controlador.modificar(nombre, nuevo, edad, altura),
                "Persona modificada.",
                "No existe la persona o el nuevo nombre ya está registrado.");
    }

    private void listar() {
        List<Persona> lista = controlador.listar();

        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona persona : lista) {
                System.out.println(persona);
            }
        }
    }

    private int leerEntero(String texto) {
        while (true) {
            try {
                System.out.print(texto);
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    private double leerDouble(String texto) {
        while (true) {
            try {
                System.out.print(texto);
                return Double.parseDouble(
                        teclado.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Introduce una altura válida.");
            }
        }
    }

    private void mensaje(boolean correcto, String exito, String error) {
        System.out.println(correcto ? exito : error);
    }
}