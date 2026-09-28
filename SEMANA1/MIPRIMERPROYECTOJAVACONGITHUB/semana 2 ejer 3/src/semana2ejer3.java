import es.usal.progii.tools.Esdia;
public class semana2ejer3 {
    public static void main(String[] args) {
        int n;
        do {
            n = Esdia.readInt("Ingrese un número entero mayor que 0: ");
            if (n <= 0) {
                System.err.println("Error:El número debe ser mayor que 0. Intente nuevamente.");
            }
        } while (n <= 0);
        double suma = 0;
        for (int i = 1; i <= n; i++) {
            double numero = Esdia.readDouble("Ingrese el número " + i + ": ");
            suma += numero;
        }

double media = suma / n;
        System.out.println("La media de los %d números ingresados es: %.2f\n", n, media);
    }
}



