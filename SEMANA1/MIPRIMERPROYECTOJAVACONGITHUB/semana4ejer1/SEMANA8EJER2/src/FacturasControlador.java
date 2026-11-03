import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FacturasControlador {

    private Facturas modelo;
    private FacturasVista vista;

    public FacturasControlador(Facturas modelo, FacturasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {

        cargarFacturasIniciales();

        boolean salir = false;

        while (!salir) {

            vista.mostrarMenu();

            int opcion = vista.leerOpcion();

            switch (opcion) {

                case 1:
                    buscarFacturas();
                    break;

                case 2:
                    vista.mostrarFacturas(modelo.getLista());
                    break;

                case 3:
                    exportarHTML();
                    break;

                case 4:
                    exportarCSV();
                    break;

                case 0:
                    salir = true;
                    vista.mostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void cargarFacturasIniciales() {

        Path escritorio = Paths.get(
                System.getProperty("user.home"),
                "Desktop", "datos", "facturas.tsv");

        Path carpetaProyecto = Paths.get("facturas.tsv");

        Path ruta;

        if (java.nio.file.Files.isRegularFile(escritorio)) {
            ruta = escritorio;
        } else {
            ruta = carpetaProyecto;
        }

        try {

            if (!java.nio.file.Files.isRegularFile(ruta)) {

                vista.mostrarMensaje("No se encuentra facturas.tsv.");

                vista.mostrarMensaje(
                        "Colócalo en Escritorio/datos/facturas.tsv "
                        + "o en la carpeta principal del proyecto.");

                return;
            }

            int cantidad = modelo.cargarTSV(ruta);

            vista.mostrarMensaje(
                    "Facturas cargadas correctamente: " + cantidad);

        } catch (IOException e) {

            vista.mostrarMensaje(
                    "Error al cargar las facturas: " + e.getMessage());
        }
    }

    private void buscarFacturas() {

        if (modelo.estaVacia()) {

            vista.mostrarMensaje("No hay facturas cargadas.");
            return;
        }

        double minimo = vista.leerDouble(
                "Introduce el importe mínimo: ");

        List<Factura> resultado =
                modelo.buscarPorTotalMinimo(minimo);

        vista.mostrarClientes(resultado);
    }

    private void exportarHTML() {

        if (modelo.estaVacia()) {

            vista.mostrarMensaje("No hay facturas para exportar.");
            return;
        }

        Path ruta = Paths.get("facturas.html");

        try {

            modelo.exportarHTML(ruta);

            vista.mostrarMensaje(
                    "Archivo HTML creado: " + ruta.toAbsolutePath());

            if (Desktop.isDesktopSupported()
                    && Desktop.getDesktop().isSupported(
                            Desktop.Action.BROWSE)) {

                Desktop.getDesktop().browse(
                        ruta.toAbsolutePath().toUri());

            } else {

                vista.mostrarMensaje(
                        "Abre facturas.html manualmente con tu navegador.");
            }

        } catch (IOException e) {

            vista.mostrarMensaje(
                    "Error al exportar HTML: " + e.getMessage());
        }
    }

    private void exportarCSV() {

        if (modelo.estaVacia()) {

            vista.mostrarMensaje("No hay facturas para exportar.");
            return;
        }

        Path ruta = Paths.get("facturas.csv");

        try {

            modelo.exportarCSV(ruta);

            vista.mostrarMensaje(
                    "Archivo CSV creado: " + ruta.toAbsolutePath());

        } catch (IOException e) {

            vista.mostrarMensaje(
                    "Error al exportar CSV: " + e.getMessage());
        }
    }
}