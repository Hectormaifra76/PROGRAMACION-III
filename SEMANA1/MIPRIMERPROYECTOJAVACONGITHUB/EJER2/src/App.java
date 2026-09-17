import java.util.Scanner;

public class app {
    public static void main(String[] args) throws Exception {
        //Pedir dos números al usuario con Scanner y mostrar la suma de ambos
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.printf("La suma es: %d%n", sum);
        sc.close();
    }
}
