package modelo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PersonasHashSetModelo {

    private final Set<Persona> personas = new LinkedHashSet<>();

    public boolean agregar(String nombre, int edad, double altura) {
        return personas.add(new Persona(nombre, edad, altura));
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

        if (!persona.getNombre().equalsIgnoreCase(nuevoNombre)
                && buscar(nuevoNombre) != null) {
            return false;
        }

        personas.remove(persona);

        persona.setNombre(nuevoNombre);
        persona.setEdad(edad);
        persona.setAltura(altura);

        return personas.add(persona);
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