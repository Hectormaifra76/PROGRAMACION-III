import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Facturas modelo = new Facturas();

        FacturasVista vista =
                new FacturasVista(teclado);

        FacturasControlador controlador =
                new FacturasControlador(modelo, vista);

        controlador.iniciar();

        teclado.close();
    }
}
