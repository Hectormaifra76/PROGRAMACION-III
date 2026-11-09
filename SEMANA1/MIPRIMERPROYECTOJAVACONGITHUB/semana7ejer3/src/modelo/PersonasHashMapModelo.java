package modelo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PersonasHashMapModelo {

    private final Map<String, Persona> personas = new LinkedHashMap<>();

    public boolean agregar(String dni, String nombre,
                           int edad, double altura) {
        if (personas.containsKey(dni)) {
            return false;
        }

        personas.put(dni, new Persona(nombre, edad, altura));
        return true;
    }

    public boolean eliminar(String dni) {
        return personas.remove(dni) != null;
    }

    public boolean modificar(String dni, String nombre,
                             int edad, double altura) {
        Persona persona = personas.get(dni);

        if (persona == null) {
            return false;
        }

        persona.setNombre(nombre);
        persona.setEdad(edad);
        persona.setAltura(altura);

        return true;
    }

    public Persona buscar(String dni) {
        return personas.get(dni);
    }

    public List<Map.Entry<String, Persona>> listar() {
        return new ArrayList<>(personas.entrySet());
    }
}
