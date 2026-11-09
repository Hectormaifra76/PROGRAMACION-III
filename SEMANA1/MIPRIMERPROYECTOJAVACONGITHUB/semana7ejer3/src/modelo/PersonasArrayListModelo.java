package modelo;

import java.util.ArrayList;
import java.util.List;

public class PersonasArrayListModelo {

    private final List<Persona> personas = new ArrayList<>();

    public boolean agregar(String nombre, int edad, double altura) {
        if (buscar(nombre) != null) {
            return false;
        }

        personas.add(new Persona(nombre, edad, altura));
        return true;
    }

    public boolean eliminar(String nombre) {
        Persona persona = buscar(nombre);

        return persona != null && personas.remove(persona);
    }

    public boolean modificar(String nombre, String nuevoNombre,
                              int edad, double altura) {
        Persona persona = buscar(nombre);

        if (persona == null) {
            return false;
        }

        Persona existente = buscar(nuevoNombre);

        if (existente != null && existente != persona) {
            return false;
        }

        persona.setNombre(nuevoNombre);
        persona.setEdad(edad);
        persona.setAltura(altura);

        return true;
    }

    public Persona buscar(String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }

        return null;
    }

    public List<Persona> listar() {
        return new ArrayList<>(personas);
    }
}