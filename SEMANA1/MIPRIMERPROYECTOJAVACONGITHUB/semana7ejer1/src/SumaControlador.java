package controlador;

import modelo.SumaModelo;

public class SumaControlador {

    private final SumaModelo modelo;

    public SumaControlador(SumaModelo modelo) {
        this.modelo = modelo;
    }

    public void leerNumeros(int primerNumero, int segundoNumero) {
        modelo.establecerNumeros(primerNumero, segundoNumero);
    }

    public boolean hayNumerosLeidos() {
        return modelo.hayNumerosLeidos();
    }

    public boolean haySumaCalculada() {
        return modelo.haySumaCalculada();
    }

    public int calcularSuma() {
        return modelo.calcularSuma();
    }

    public int getPrimerNumero() {
        return modelo.getPrimerNumero();
    }

    public int getSegundoNumero() {
        return modelo.getSegundoNumero();
    }

    public int getResultado() {
        return modelo.getResultado();
    }
}