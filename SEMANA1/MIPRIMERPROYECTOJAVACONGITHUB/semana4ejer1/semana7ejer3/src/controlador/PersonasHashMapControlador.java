package controlador;

import java.util.List;
import java.util.Map;
import modelo.Persona;
import modelo.PersonasHashMapModelo;

public class PersonasHashMapControlador {

    private final PersonasHashMapModelo modelo;

    public PersonasHashMapControlador(PersonasHashMapModelo modelo) {
        this.modelo = modelo;
    }

    public boolean agregar(String dni, String nombre,
                           int edad, double altura) {
        return modelo.agregar(dni, nombre, edad, altura);
    }

    public boolean eliminar(String dni) {
        return modelo.eliminar(dni);
    }

    public boolean modificar(String dni, String nombre,
                             int edad, double altura) {
        return modelo.modificar(dni, nombre, edad, altura);
    }

    public Persona buscar(String dni) {
        return modelo.buscar(dni);
    }

    public List<Map.Entry<String, Persona>> listar() {
        return modelo.listar();
    }
}