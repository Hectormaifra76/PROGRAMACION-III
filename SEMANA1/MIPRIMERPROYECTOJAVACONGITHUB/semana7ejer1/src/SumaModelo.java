package modelo;

public class SumaModelo {

    private int primerNumero;
    private int segundoNumero;
    private boolean numerosLeidos;
    private boolean sumaCalculada;
    private int resultado;

    public void establecerNumeros(int primerNumero, int segundoNumero) {
        this.primerNumero = primerNumero;
        this.segundoNumero = segundoNumero;
        this.numerosLeidos = true;
        this.sumaCalculada = false;
    }

    public boolean hayNumerosLeidos() {
        return numerosLeidos;
    }

    public boolean haySumaCalculada() {
        return sumaCalculada;
    }

    public int calcularSuma() {
        if (!numerosLeidos) {
            throw new IllegalStateException(
                "Primero debes leer los números."
            );
        }

        resultado = primerNumero + segundoNumero;
        sumaCalculada = true;

        return resultado;
    }

    public int getPrimerNumero() {
        return primerNumero;
    }

    public int getSegundoNumero() {
        return segundoNumero;
    }

    public int getResultado() {
        if (!sumaCalculada) {
            throw new IllegalStateException(
                "La suma todavía no se ha calculado."
            );
        }

        return resultado;
    }
}