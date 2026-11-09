import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Personas {
    private final ArrayList<Persona> lista = new ArrayList<>();

    public void agregar(Persona persona) { lista.add(persona); }
    public List<Persona> getLista() { return lista; }
    public boolean estaVacia() { return lista.isEmpty(); }

    public int importarTSV(Path fichero) throws IOException {
        List<String> lineas = Files.readAllLines(fichero);
        int cargadas = 0;
        for (String linea : lineas) {
            if (linea.trim().isEmpty()) continue;
            String[] campos = linea.split("\\t");
            if (campos.length < 3) continue;
            try {
                String nombre = campos[0].trim();
                String telefono = campos[1].trim();
                double peso = Double.parseDouble(campos[2].trim().replace(',', '.'));
                agregar(new Persona(nombre, telefono, peso));
                cargadas++;
            } catch (NumberFormatException e) {
                System.out.println("Se ignora una fila porque el peso no es válido: " + linea);
            }
        }
        return cargadas;
    }
}

