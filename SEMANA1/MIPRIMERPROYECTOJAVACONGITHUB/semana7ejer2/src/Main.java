import modelo.VentasModelo;
import controlador.VentasControlador;
import vista.VentasVista;

public class Main {

    public static void main(String[] args) {

        VentasModelo modelo = new VentasModelo();

        VentasControlador controlador =
            new VentasControlador(modelo);

        VentasVista vista =
            new VentasVista(controlador);

        vista.iniciar();
    }
}