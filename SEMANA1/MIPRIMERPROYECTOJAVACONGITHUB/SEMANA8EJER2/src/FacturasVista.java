import java.util.List;
import java.util.Scanner;

public class FacturasVista {

    private Scanner teclado;

    public FacturasVista(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {

        System.out.println("\n========== GESTIÓN DE FACTURAS ==========");

        System.out.println("1. Buscar facturas por importe mínimo");
        System.out.println("2. Mostrar todas las facturas");
        System.out.println("3. Exportar facturas a HTML");
        System.out.println("4. Exportar facturas a CSV");
        System.out.println("0. Salir");

        System.out.print("Elige una opción: ");
    }

    public int leerOpcion() {

        while (!teclado.hasNextInt()) {

            System.out.print("Introduce una opción numérica: ");
            teclado.nextLine();
        }

        int opcion = teclado.nextInt();
        teclado.nextLine();

        return opcion;
    }

    public double leerDouble(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String dato = teclado.nextLine()
                    .trim().replace(",", ".");

            try {
                return Double.parseDouble(dato);

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número válido.");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarFacturas(List<Factura> facturas) {

        if (facturas.isEmpty()) {

            System.out.println("No hay facturas para mostrar.");
            return;
        }

        System.out.println("\nLISTADO DE FACTURAS");

        System.out.printf(
                "%-27s %-10s %-12s %10s %-12s %-22s %-35s %5s %10s%n",
                "CONCEPTO", "DTO.", "FECHA", "IMPORTE",
                "NIF", "CLIENTE", "DIRECCIÓN", "IVA", "TOTAL");

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }

    public void mostrarClientes(List<Factura> facturas) {

        if (facturas.isEmpty()) {

            System.out.println(
                    "No hay facturas que superen ese importe.");

            return;
        }

        System.out.println("\nFACTURAS QUE SUPERAN EL MÍNIMO:");

        for (Factura factura : facturas) {

            System.out.printf(
                    "%-22s | NIF: %-12s | Total: %.2f euros%n",
                    factura.getNombreCliente(),
                    factura.getNif(),
                    factura.calcularTotal());
        }
    }
}