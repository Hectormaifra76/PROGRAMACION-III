import modelo.SumaModelo;
import controlador.SumaControlador;
import vista.SumaVista;

public class Main {

    public static void main(String[] args) {

        SumaModelo modelo = new SumaModelo();

        SumaControlador controlador =
            new SumaControlador(modelo);

        SumaVista vista =
            new SumaVista(controlador);

        vista.iniciar();
    }
}