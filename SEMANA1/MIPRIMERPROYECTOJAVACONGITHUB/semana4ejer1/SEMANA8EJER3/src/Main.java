import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Personas modelo = new Personas();
        PersonasVista vista = new PersonasVista(teclado);
        PersonasControlador controlador = new PersonasControlador(modelo, vista);
        controlador.iniciar();
        teclado.close();
    }
}