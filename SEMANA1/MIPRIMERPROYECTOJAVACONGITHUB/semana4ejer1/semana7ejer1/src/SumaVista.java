package vista;

import java.util.Scanner;
import controlador.SumaControlador;

public class SumaVista {

    private final Scanner teclado;
    private final SumaControlador controlador;

    public SumaVista(SumaControlador controlador) {
        this.controlador = controlador;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            String opcion = teclado.nextLine().trim().toLowerCase();

            switch (opcion) {
                case "1":
                    leerNumeros();
                    break;

                case "2":
                    calcularSuma();
                    break;

                case "3":
                    mostrarResultado();
                    break;

                case "q":
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println(
                        "Opción no válida. Selecciona 1, 2, 3 o q."
                    );
            }

            System.out.println();
        }
    }

    private void mostrarMenu() {
        System.out.println("========== SUMA DE DOS NÚMEROS ==========");
        System.out.println("1.- Leer los números");
        System.out.println("2.- Calcular la suma");
        System.out.println("3.- Mostrar el resultado");
        System.out.println("q.- Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void leerNumeros() {
        int primero = leerEntero(
            "Introduce el primer número entero: "
        );

        int segundo = leerEntero(
            "Introduce el segundo número entero: "
        );

        controlador.leerNumeros(primero, segundo);

        System.out.println("Números guardados correctamente.");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Entrada no válida. Debes introducir un número entero."
                );
            }
        }
    }

    private void calcularSuma() {
        if (!controlador.hayNumerosLeidos()) {
            System.out.println(
                "Primero debes seleccionar la opción 1 y leer los números."
            );
            return;
        }

        try {
            int resultado = controlador.calcularSuma();
            System.out.println(
                "Suma calculada correctamente: " + resultado
            );
        } catch (ArithmeticException e) {
            System.out.println(
                "No se puede representar el resultado con un int."
            );
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mostrarResultado() {
        if (!controlador.haySumaCalculada()) {
            System.out.println(
                "Todavía no hay resultado. Lee los números y calcula la suma primero."
            );
            return;
        }

        System.out.println(
            "Resultado: "
            + controlador.getPrimerNumero()
            + " + "
            + controlador.getSegundoNumero()
            + " = "
            + controlador.getResultado()
        );
    }
}