package vista;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import controlador.PersonasHashMapControlador;
import modelo.Persona;

public class PersonasHashMapVista {

    private final PersonasHashMapControlador controlador;
    private final Scanner teclado = new Scanner(System.in);

    public PersonasHashMapVista(PersonasHashMapControlador controlador) {
        this.controlador = controlador;
    }

    public void iniciar() {
        String opcion;

        do {
            System.out.println("\n=== CRUD con HashMap (DNI -> Persona) ===");
            System.out.println("1. Añadir persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Listar personas");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = teclado.nextLine().trim();

            switch (opcion) {
                case "1":
                    anadir();
                    break;
                case "2":
                    System.out.print("DNI a eliminar: ");
                    mensaje(controlador.eliminar(teclado.nextLine().trim()),
                            "Persona eliminada.", "No existe ese DNI.");
                    break;
                case "3":
                    modificar();
                    break;
                case "4":
                    buscar();
                    break;
                case "5":
                    listar();
                    break;
                case "6":
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("6"));
    }

    private void anadir() {
        System.out.print("DNI: ");
        String dni = teclado.nextLine().trim();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine().trim();

        int edad = leerEntero("Edad: ");
        double altura = leerDouble("Altura en metros: ");

        mensaje(controlador.agregar(dni, nombre, edad, altura),
                "Persona añadida.", "Ya existe ese DNI.");
    }

    private void modificar() {
        System.out.print("DNI de la persona: ");
        String dni = teclado.nextLine().trim();

        System.out.print("Nuevo nombre: ");
        String nombre = teclado.nextLine().trim();

        int edad = leerEntero("Nueva edad: ");
        double altura = leerDouble("Nueva altura en metros: ");

        mensaje(controlador.modificar(dni, nombre, edad, altura),
                "Persona modificada.", "No existe ese DNI.");
    }

    private void buscar() {
        System.out.print("DNI a buscar: ");
        String dni = teclado.nextLine().trim();

        Persona persona = controlador.buscar(dni);

        if (persona == null) {
            System.out.println("No existe ese DNI.");
        } else {
            System.out.println("DNI=" + dni + " -> " + persona);
        }
    }

    private void listar() {
        List<Map.Entry<String, Persona>> lista = controlador.listar();

        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Map.Entry<String, Persona> entrada : lista) {
                System.out.println("DNI=" + entrada.getKey()
                        + " -> " + entrada.getValue());
            }
        }
    }

    private int leerEntero(String texto) {
        while (true) {
            try {
                System.out.print(texto);
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un entero válido.");
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