import modelo.PersonasArrayListModelo;
import controlador.PersonasArrayListControlador;
import vista.PersonasArrayListVista;

public class MainArrayList {

    public static void main(String[] args) {
        PersonasArrayListModelo modelo =
                new PersonasArrayListModelo();

        PersonasArrayListControlador controlador =
                new PersonasArrayListControlador(modelo);

        PersonasArrayListVista vista =
                new PersonasArrayListVista(controlador);

        vista.iniciar();
    }
}