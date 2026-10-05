import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de alumnos: ");
        int numAlumnos = scanner.nextInt();

        Alumno[] alumnos = new Alumno[numAlumnos];

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println();
            System.out.println("Alumno" + (i + 1) );

            System.out.print("Nombre: ");
            String nombre = scanner.next();

            System.out.print("Nota 1: ");
            double nota1 = scanner.nextDouble();

            System.out.print("Nota 2: ");
            double nota2 = scanner.nextDouble();

            System.out.print("Nota final: ");
            double notafinal = scanner.nextDouble();

            alumnos[i] = new Alumno(nombre, nota1, nota2, notafinal);
        }


        double sumaNota1 = 0;
        double sumaNota2 = 0;
        double sumaNotaFinal = 0;
        double sumaNotaCurso = 0;

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s%n",
                "Alumno", "Examen 1", "Examen 2", "Final", "Nota curso");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < numeroAlumnos; i++) {

            double notaCurso = alumnos[i].calcularNotaFinal();

            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-10.2f%n",
                    alumnos[i].getNombre(),
                    alumnos[i].getNota1(),
                    alumnos[i].getNota2(),
                    alumnos[i].getNotaFinal(),
                    notaCurso);

                    sumaNota1 += alumnos[i].getNota1();
            sumaNota2 += alumnos[i].getNota2();
            sumaNotaFinal += alumnos[i].getNotaFinal();
            sumaNotaCurso += notaCurso;
        }

        double mediaNota1 = sumaNota1 / numeroAlumnos;
        double mediaNota2 = sumaNota2 / numeroAlumnos;
        double mediaNotaFinal = sumaNotaFinal / numeroAlumnos;
        double mediaCurso = sumaNotaCurso / numeroAlumnos;

        System.out.println("---------------------------------------------------------------");

        System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-10.2f%n",
                "MEDIA",
                mediaNota1,
                mediaNota2,
                mediaNotaFinal,
                mediaCurso);

        System.out.println("---------------------------------------------------------------");

        scanner.close();
    }
}
    
    
