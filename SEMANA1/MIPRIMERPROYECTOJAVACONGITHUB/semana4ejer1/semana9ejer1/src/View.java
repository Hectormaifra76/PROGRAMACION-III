package com.gestorlibros.view;

import java.util.ArrayList;

import es.usal.progiii.tools.Esdia;
import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.Libro;

public class View {

    private Controller c;

    public void startMenu() {

        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== GESTOR DE LIBROS =====");
            System.out.println("1. Mostrar el listado de libros en formato tabla.");
            System.out.println("2. Añadir nuevo libro al modelo.");
            System.out.println("3. Eliminar libro de una lista de libros disponibles.");
            System.out.println("4. Modificar libro de una lista de libros disponibles.");
            System.out.println("5. Exportar libros en formato delimitado por comas CSV.");
            System.out.println("6. Exportar libros en formato JSON.");
            System.out.println("7. Exportar libros en formato XML.");
            System.out.println("8. Importar libros de un fichero JSON.");
            System.out.println("9. Importar libros de un fichero XML.");
            System.out.println("10. Importar libros de un fichero delimitado por comas CSV.");
            System.out.println("11. Salir del programa.");

            int option = Esdia.readInt("Ingrese una opción: ", 1, 11);

            switch (option) {

                case 1:
                    mostrarLibrosModelo(false);
                    break;

                case 2:
                    anadirLibroAlModelo();
                    break;

                case 3:
                    borrarLibroDelModelo();
                    break;

                case 4:
                    editarLibroDelModelo();
                    break;

                case 5:
                    resultado("Exportación CSV",
                            c.exportBooksToCSV(), true);
                    break;

                case 6:
                    resultado("Exportación JSON",
                            c.exportBooksToJSON(), true);
                    break;

                case 7:
                    resultado("Exportación XML",
                            c.exportBooksToXML(), true);
                    break;

                case 8:
                    resultado("Importación JSON",
                            c.importBooksFromJSON(), false);
                    break;

                case 9:
                    resultado("Importación XML",
                            c.importBooksFromXML(), false);
                    break;

                case 10:
                    resultado("Importación CSV",
                            c.importBooksFromCSV(), false);
                    break;

                case 11:
                    exit = true;
                    break;
            }
        }
    }

    // Mostrar resultado de importaciones y exportaciones
    private void resultado(String operacion,
            int cantidad, boolean exportacion) {

        if (cantidad < 0) {

            showErrorMessage(
                    "Error en la " + operacion
                    + ". Compruebe que el fichero existe y que tiene un formato correcto.");

        } else {

            showInfoMessage(
                    operacion + " realizada correctamente. "
                    + (exportacion
                    ? "Registros exportados: "
                    : "Libros nuevos añadidos: ")
                    + cantidad);
        }
    }

    // AÑADIR LIBRO
    private void anadirLibroAlModelo() {

        String titulo = Esdia.readString_ne(
                "Introduzca el título del libro: ");

        String autor = Esdia.readString_ne(
                "Introduzca el autor del libro: ");

        String isbn = Esdia.readString_ne(
                "Introduzca el ISBN del libro: ");

        String editorial = Esdia.readString_ne(
                "Introduzca la editorial del libro: ");

        int anyo = Esdia.readInt(
                "Introduzca el año de publicación: ");

        int paginas = Esdia.readInt(
                "Introduzca el número de páginas: ");

        float precio = Esdia.readFloat(
                "Introduzca el precio: ");

        Libro l = new Libro(isbn, titulo, autor,
                editorial, anyo, paginas, precio);

        if (c.getLibros().contains(l)) {

            showInfoMessage("Ya existe un libro con ese ISBN.");

        } else {

            c.addLibro(l);

            showInfoMessage("Libro añadido correctamente.");
        }
    }

    // ELIMINAR LIBRO
    private void borrarLibroDelModelo() {

        ArrayList<Libro> libros = c.getLibros();

        if (libros.isEmpty()) {

            showInfoMessage("No hay libros para eliminar.");
            return;
        }

        mostrarLibrosModelo(true);

        int indice = Esdia.readInt(
                "Seleccione el número del libro que desea eliminar: ",
                1, libros.size());

        c.removeLibro(libros.get(indice - 1));

        showInfoMessage("Libro eliminado correctamente.");
    }

    // MODIFICAR LIBRO
    private void editarLibroDelModelo() {

        ArrayList<Libro> libros = c.getLibros();

        if (libros.isEmpty()) {

            showInfoMessage("No hay libros para modificar.");
            return;
        }

        mostrarLibrosModelo(true);

        int indice = Esdia.readInt(
                "Seleccione el número del libro que desea modificar: ",
                1, libros.size());

        Libro antiguo = libros.get(indice - 1);

        showInfoMessage("Introduzca los nuevos datos del libro:");

        String titulo = Esdia.readString_ne("Título: ");
        String autor = Esdia.readString_ne("Autor: ");
        String isbn = Esdia.readString_ne("ISBN: ");
        String editorial = Esdia.readString_ne("Editorial: ");

        int anyo = Esdia.readInt("Año de publicación: ");

        int paginas = Esdia.readInt("Número de páginas: ");

        float precio = Esdia.readFloat("Precio: ");

        Libro nuevo = new Libro(isbn, titulo, autor,
                editorial, anyo, paginas, precio);

        if (!antiguo.getISBN().equals(nuevo.getISBN())
                && c.getLibros().contains(nuevo)) {

            showErrorMessage(
                    "Ya existe otro libro con ese ISBN. No se ha modificado.");

            return;
        }

        c.removeLibro(antiguo);
        c.addLibro(nuevo);

        showInfoMessage("Libro modificado correctamente.");
    }

    // MOSTRAR LIBROS
    private void mostrarLibrosModelo(boolean showIndex) {

        ArrayList<Libro> books = c.getLibros();

        if (books.isEmpty()) {

            System.out.println("No hay libros disponibles.");
            return;
        }

        if (showIndex) {
            System.out.println(
                    String.format("| %6s ", "Índice")
                    + Libro.tableHeader());
        } else {
            System.out.println(Libro.tableHeader());
        }

        for (int i = 0; i < books.size(); i++) {

            if (showIndex) {

                System.out.println(
                        String.format("| %6d ", i + 1)
                        + books.get(i).asTableRow());

            } else {

                System.out.println(books.get(i).asTableRow());
            }
        }
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void showInfoMessage(String string) {
        System.out.println(string);
    }

    public void showErrorMessage(String string) {
        System.err.println(string);
    }
}