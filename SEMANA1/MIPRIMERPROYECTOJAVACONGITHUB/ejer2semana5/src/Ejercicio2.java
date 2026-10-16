import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String[] palabras = new String[5];

        // Pedimos las 5 palabras al usuario
        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Introduce una palabra: ");
            palabras[i] = teclado.nextLine();
        }

        // Ordenamos las palabras
        Arrays.sort(palabras);

        // Mostramos las palabras ordenadas
        System.out.println("Palabras ordenadas:");

        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

        teclado.close();
    }
}
