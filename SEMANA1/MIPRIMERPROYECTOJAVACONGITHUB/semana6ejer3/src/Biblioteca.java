import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

    static Scanner teclado = new Scanner(System.in);
    static HashMap<String, Libro> libros = new HashMap<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- GESTION DE BIBLIOTECA ---");
            System.out.println("1. Dar de alta un libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Consultar un libro");
            System.out.println("4. Modificar un libro");
            System.out.println("5. Eliminar un libro");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    altaLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    consultarLibro();
                    break;

                case 4:
                    modificarLibro();
                    break;

                case 5:
                    eliminarLibro();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // CREATE: dar de alta un libro
    public static void altaLibro() {

        System.out.print("Introduce el ISBN: ");
        String isbn = teclado.nextLine();

        if (libros.containsKey(isbn)) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }

        System.out.print("Titulo: ");
        String titulo = teclado.nextLine();

        System.out.print("Autor: ");
        String autor = teclado.nextLine();

        System.out.print("Anio de publicacion: ");
        int anio = Integer.parseInt(teclado.nextLine());

        Libro libro = new Libro(isbn, titulo, autor, anio);

        libros.put(isbn, libro);

        System.out.println("Libro añadido correctamente.");
    }

    // READ: mostrar todos los libros
    public static void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
    }

    // READ: consultar un libro por ISBN
    public static void consultarLibro() {

        System.out.print("Introduce el ISBN: ");
        String isbn = teclado.nextLine();

        Libro libro = libros.get(isbn);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    // UPDATE: modificar un libro
    public static void modificarLibro() {

        System.out.print("Introduce el ISBN del libro: ");
        String isbn = teclado.nextLine();

        Libro libro = libros.get(isbn);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo titulo: ");
        String titulo = teclado.nextLine();

        System.out.print("Nuevo autor: ");
        String autor = teclado.nextLine();

        System.out.print("Nuevo anio de publicacion: ");
        int anio = Integer.parseInt(teclado.nextLine());

        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnio(anio);

        System.out.println("Libro modificado correctamente.");
    }

    // DELETE: eliminar un libro
    public static void eliminarLibro() {

        System.out.print("Introduce el ISBN del libro: ");
        String isbn = teclado.nextLine();

        Libro libro = libros.remove(isbn);

        if (libro != null) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}