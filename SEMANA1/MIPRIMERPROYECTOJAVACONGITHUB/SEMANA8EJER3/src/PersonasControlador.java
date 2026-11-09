import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonasControlador {
    private final Personas modelo;
    private final PersonasVista vista;
    private final Path escritorio;

    public PersonasControlador(Personas modelo, PersonasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.escritorio = Paths.get(System.getProperty("user.home"), "Desktop");
    }

    public void iniciar() {
        cargarDatosIniciales();
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            switch (opcion) {
                case 1 -> importarPersonas();
                case 2 -> vista.mostrarPersonas(modelo.getLista());
                case 0 -> {
                    if (vista.confirmarSalida()) continuar = false;
                }
                default -> vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        }
        vista.mostrarMensaje("Programa finalizado.");
    }

    private void cargarDatosIniciales() {
        Path fichero = escritorio.resolve("datos.txt");
        if (java.nio.file.Files.exists(fichero)) {
            try {
                int cantidad = modelo.importarTSV(fichero);
                vista.mostrarMensaje("Se han cargado " + cantidad + " personas desde " + fichero);
            } catch (IOException e) {
                vista.mostrarMensaje("No se pudieron cargar los datos iniciales: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se ha encontrado datos.txt en el Escritorio. Puedes importar otro fichero desde el menú.");
        }
    }

    private void importarPersonas() {
        String nombre = vista.leerNombreFichero();
        if (nombre.isBlank()) {
            vista.mostrarMensaje("No has indicado ningún nombre de fichero.");
            return;
        }
        Path fichero = escritorio.resolve(nombre).normalize();
        if (!fichero.startsWith(escritorio.normalize())) {
            vista.mostrarMensaje("Ruta no permitida. El fichero debe estar en el Escritorio.");
            return;
        }
        if (!java.nio.file.Files.isRegularFile(fichero)) {
            vista.mostrarMensaje("No se encuentra el fichero: " + fichero);
            return;
        }
        try {
            int cantidad = modelo.importarTSV(fichero);
            vista.mostrarMensaje("Importación terminada. Personas añadidas: " + cantidad);
        } catch (IOException e) {
            vista.mostrarMensaje("Error al leer el fichero: " + e.getMessage());
        }
    }
}
