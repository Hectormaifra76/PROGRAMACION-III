import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Person persona1 = new Person();
        Person persona2 = new Person();
        Person persona3 = new Person();

        System.out.println("Introduce los datos de la primera persona:");

        System.out.print("Nombre: ");
        persona1.setNombre(teclado.nextLine());

        System.out.print("Altura (metros): ");
        persona1.setAltura(teclado.nextDouble());

        System.out.print("Peso (kg): ");
        persona1.setPeso(teclado.nextDouble());

        teclado.nextLine();


        System.out.println("\nIntroduce los datos de la segunda persona:");

        System.out.print("Nombre: ");
        persona2.setNombre(teclado.nextLine());

        System.out.print("Altura (metros): ");
        persona2.setAltura(teclado.nextDouble());

        System.out.print("Peso (kg): ");
        persona2.setPeso(teclado.nextDouble());

        teclado.nextLine();



        System.out.println("\nIntroduce los datos de la tercera persona:");

        System.out.print("Nombre: ");
        persona3.setNombre(teclado.nextLine());

        System.out.print("Altura (metros): ");
        persona3.setAltura(teclado.nextDouble());

        System.out.print("Peso (kg): ");
        persona3.setPeso(teclado.nextDouble());

        Person masAlta = persona1;

        if (persona2.getAltura() > masAlta.getAltura()) {
            masAlta = persona2;
        }

        if (persona3.getAltura() > masAlta.getAltura()) {
            masAlta = persona3;
        }

        Person masPesa = persona1;

        if (persona2.getPeso() > masPesa.getPeso()) {
            masPesa = persona2;
        }

        if (persona3.getPeso() > masPesa.getPeso()) {
            masPesa = persona3;
        }

        System.out.println("\n--- RESULTADOS ---");

        System.out.println("La persona más alta es: "
                + masAlta.getNombre()
                + " con una altura de "
                + masAlta.getAltura()
                + " metros.");

        System.out.println("La persona que más pesa es: "
                + masPesa.getNombre()
                + " con un peso de "
                + masPesa.getPeso()
                + " kg.");

        teclado.close();
    }
}