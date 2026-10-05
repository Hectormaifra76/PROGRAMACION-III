import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double IVA = 0.21; 

        Producto[] productos = new Producto[2];

        System.out.println("PRECIOS DE LOS PRODUCTOS");

        System.out.print("Precio por kg de las manzanas sin IVA: ");
        double precioManzanas = scanner.nextDouble();

        System.out.print("Precio por kg de las peras sin IVA: ");
        double precioPeras = scanner.nextDouble();

        productos[0] = new Producto("Manzanas", precioManzanas);
        productos[1] = new Producto("Peras", precioPeras);

        int numeroCliente = 1;
        boolean continuar = true;

        while(continuar) {
            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println("                 CLIENTE " + numeroCliente);
            System.out.println("-----------------------------------------------");

            System.out.print("Cantidad de manzanas (kg): ");
            double cantidadManzanas = scanner.nextDouble();

            System.out.print("Cantidad de peras (kg): ");
            double cantidadPeras = scanner.nextDouble();

            double precioManzanasIVA =
                    productos[0].getPrecioConIVA(IVA);

            double precioPerasIVA =
                    productos[1].getPrecioConIVA(IVA);

            double totalManzanas =
                    cantidadManzanas * precioManzanasIVA;

            double totalPeras =
                    cantidadPeras * precioPerasIVA;

            double totalFactura =
                    totalManzanas + totalPeras;
                    System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.printf("| %-10s | %-8s | %-17s | %-10s |%n",
                    "Producto", "Kg", "Precio/Kg IVA", "Total");
            System.out.println("-----------------------------------------------");

            System.out.printf("| %-10s | %8.2f | %17.2f | %10.2f € |%n",
                    productos[0].getNombre(),
                    cantidadManzanas,
                    precioManzanasIVA,
                    totalManzanas);

            System.out.printf("| %-10s | %8.2f | %17.2f | %10.2f € |%n",
                    productos[1].getNombre(),
                    cantidadPeras,
                    precioPerasIVA,
                    totalPeras);

            System.out.println("-----------------------------------------------");
            System.out.printf("| Total con IVA: %33.2f € |%n",
                    totalFactura);
            System.out.println("-----------------------------------------------");

            System.out.print("¿Quieres introducir otro cliente? (s/n): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            } else {
                numeroCliente++;
            }
        }

        System.out.println();
        System.out.println("Programa finalizado.");

        scanner.close();
    }
}
        
    
    

