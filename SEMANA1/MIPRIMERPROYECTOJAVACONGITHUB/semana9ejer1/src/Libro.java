package com.gestorlibros.model;

import java.util.Locale;
import java.io.Serializable;

public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    String ISBN;
    String titulo;
    String autor;
    String editorial;
    int anyoPublicacion;
    int numPaginas;
    float precio;

    // Constructor sin argumentos para XML
    public Libro() {
    }

    public Libro(String iSBN, String titulo, String autor,
            String editorial, int anyoPublicacion,
            int numPaginas, float precio) {

        ISBN = iSBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anyoPublicacion = anyoPublicacion;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }

    // Crear un libro desde una cadena delimitada
    public static Libro fromDelimitedString(
            String delimitedString, String delimiter) {

        String[] parts = delimitedString.split(
                java.util.regex.Pattern.quote(delimiter), -1);

        try {
            if (parts.length != 7) {
                return null;
            }

            return new Libro(parts[0], parts[1], parts[2],
                    parts[3], Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Float.parseFloat(parts[6]));

        } catch (IllegalArgumentException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    // Convertir libro a cadena delimitada
    public String asDelimitedString(String delimiter) {

        return String.join(delimiter,
                ISBN, titulo, autor, editorial,
                String.valueOf(anyoPublicacion),
                String.valueOf(numPaginas),
                String.format(Locale.ENGLISH, "%.2f", precio));
    }

    // Cabecera de la tabla
    public static String tableHeader() {

        return String.format(Locale.ENGLISH,
                "|%-15s|%-30s|%-30s|%-30s|%-10s|%-10s|%-10s|",
                "ISBN", "Título", "Autor", "Editorial",
                "Año", "Páginas", "Precio");
    }

    // Fila de la tabla
    public String asTableRow() {

        return String.format(Locale.ENGLISH,
                "|%-15s|%-30s|%-30s|%-30s|%-10d|%-10d|%-10.2f|",
                ISBN, titulo, autor, editorial,
                anyoPublicacion, numPaginas, precio);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result
                + ((ISBN == null) ? 0 : ISBN.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Libro other = (Libro) obj;

        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;

        return true;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}