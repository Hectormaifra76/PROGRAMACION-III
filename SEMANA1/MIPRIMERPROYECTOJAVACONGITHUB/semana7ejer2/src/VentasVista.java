package vista;

import java.util.Scanner;
import controlador.VentasControlador;

public class VentasVista {

    private final Scanner teclado;
    private final VentasControlador controlador;

    public VentasVista(VentasControlador controlador) {
        this.controlador = controlador;
        teclado = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            String opcion = teclado.nextLine().trim().toLowerCase();

            switch (opcion) {
                case "1":
                    leerVentas();
                    break;

                case "2":
                    leerPrecios();
                    break;

                case "3":
                    calcularIngresos();
                    break;

                case "4":
                    mostrarResultados();
                    break;

                case "q":
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();
        }
    }

    private void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("       GESTIÓN DE VENTAS");
        System.out.println("==================================");
        System.out.println("1.- Leer tabla de ventas");
        System.out.println("2.- Leer tabla de precios");
        System.out.println("3.- Calcular ingresos totales");
        System.out.println("4.- Mostrar resultados");
        System.out.println("q.- Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void leerVentas() {
        int[][] ventas = new int[5][2];

        System.out.println("\nLECTURA DE VENTAS");
        System.out.println("Introduce las unidades vendidas.");

        for (int i = 0; i < 5; i++) {
            System.out.println("\nAlmacén " + (i + 1));

            for (int j = 0; j < 2; j++) {
                ventas[i][j] = leerEnteroNoNegativo(
                    "Unidades del producto " + (j + 1) + ": "
                );
            }
        }

        controlador.leerVentas(ventas);

        System.out.println("\nTabla de ventas guardada correctamente.");
    }

    private void leerPrecios() {
        System.out.println("\nLECTURA DE PRECIOS");

        double precio1 = leerDecimalPositivo(
            "Precio por unidad del producto 1 (€): "
        );

        double precio2 = leerDecimalPositivo(
            "Precio por unidad del producto 2 (€): "
        );

        controlador.leerPrecios(precio1, precio2);

        System.out.println("Precios guardados correctamente.");
    }

    private void calcularIngresos() {
        if (!controlador.hayVentasLeidas()) {
            System.out.println(
                "Primero debes leer la tabla de ventas (opción 1)."
            );
            return;
        }

        if (!controlador.hayPreciosLeidos()) {
            System.out.println(
                "Primero debes leer la tabla de precios (opción 2)."
            );
            return;
        }

        controlador.calcularIngresos();

        System.out.printf(
            "Ingresos calculados correctamente: %.2f €%n",
            controlador.getIngresosTotales()
        );
    }

    private void mostrarResultados() {
        if (!controlador.hayVentasLeidas()) {
            System.out.println(
                "No hay ventas registradas. Selecciona primero la opción 1."
            );
            return;
        }

        if (!controlador.hayPreciosLeidos()) {
            System.out.println(
                "No hay precios registrados. Selecciona primero la opción 2."
            );
            return;
        }

        if (!controlador.hayIngresosCalculados()) {
            System.out.println(
                "Primero debes calcular los ingresos con la opción 3."
            );
            return;
        }

        System.out.println("\n================ TABLA DE VENTAS ================");

        System.out.printf(
            "%-12s | %12s | %12s | %15s%n",
            "Almacén",
            "Producto 1",
            "Producto 2",
            "Ingresos (€)"
        );

        System.out.println(
            "---------------------------------------------------------------"
        );

        for (int i = 0; i < 5; i++) {
            System.out.printf(
                "%-12d | %12d | %12d | %15.2f%n",
                i + 1,
                controlador.getVentas(i, 0),
                controlador.getVentas(i, 1),
                controlador.getIngresosAlmacen(i)
            );
        }

        System.out.println(
            "---------------------------------------------------------------"
        );

        System.out.printf(
            "Precio producto 1: %.2f €%n",
            controlador.getPrecio(0)
        );

        System.out.printf(
            "Precio producto 2: %.2f €%n",
            controlador.getPrecio(1)
        );

        System.out.printf(
            "INGRESOS TOTALES: %.2f €%n",
            controlador.getIngresosTotales()
        );
    }

    private int leerEnteroNoNegativo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();

            try {
                int numero = Integer.parseInt(entrada);

                if (numero >= 0) {
                    return numero;
                }

                System.out.println("El número no puede ser negativo.");

            } catch (NumberFormatException e) {
                System.out.println(
                    "Entrada incorrecta. Introduce un número entero."
                );
            }
        }
    }

    private double leerDecimalPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String entrada = teclado.nextLine()
                .trim()
                .replace(',', '.');

            try {
                double numero = Double.parseDouble(entrada);

                if (Double.isFinite(numero) && numero > 0) {
                    return numero;
                }

                System.out.println(
                    "El precio debe ser un número mayor que cero."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Entrada incorrecta. Introduce un precio válido."
                );
            }
        }
    }
}