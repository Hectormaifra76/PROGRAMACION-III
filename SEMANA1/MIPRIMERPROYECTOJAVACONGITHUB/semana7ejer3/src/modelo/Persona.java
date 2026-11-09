package modelo;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;
    private double altura;

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad
                + ", altura=" + altura + "}";
    }

    // La igualdad se basa en el nombre para el HashSet.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Persona)) {
            return false;
        }

        Persona otra = (Persona) obj;

        return nombre != null && otra.nombre != null
                && nombre.equalsIgnoreCase(otra.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                nombre == null ? null : nombre.toLowerCase()
        );
    }
}