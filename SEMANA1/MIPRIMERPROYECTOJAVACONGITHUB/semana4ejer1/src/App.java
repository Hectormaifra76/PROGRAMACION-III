public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Error:Debes introducir dos numeros");
            return;
        }

        try {
            double numero1 = Double.parseDouble(args[0]);
            double numero2 = Double.parseDouble(args[1]);

            double suma = numero1 + numero2;
            System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + suma);

        } catch (NumberFormatException e) {
            System.out.println("Error: Los dos argumentos deben ser numeros validos");
        }
    
}
