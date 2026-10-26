package controlador;

import java.util.List;
import modelo.Persona;
import modelo.PersonasArrayListModelo;

public class PersonasArrayListControlador {

    private final PersonasArrayListModelo modelo;

    public PersonasArrayListControlador(PersonasArrayListModelo modelo) {
        this.modelo = modelo;
    }

    public boolean agregar(String nombre, int edad, double altura) {
        return modelo.agregar(nombre, edad, altura);
    }

    public boolean eliminar(String nombre) {
        return modelo.eliminar(nombre);
    }

    public boolean modificar(String nombre, String nuevoNombre,
                             int edad, double altura) {
        return modelo.modificar(nombre, nuevoNombre, edad, altura);
    }

    public List<Persona> listar() {
        return modelo.listar();
    }
}