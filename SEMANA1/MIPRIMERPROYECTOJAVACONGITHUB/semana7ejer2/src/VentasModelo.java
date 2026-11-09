package modelo;

public class VentasModelo {

    private final int[][] ventas;
    private final double[] precios;
    private boolean ventasLeidas;
    private boolean preciosLeidos;
    private boolean ingresosCalculados;
    private double[] ingresosAlmacenes;
    private double ingresosTotales;

    public VentasModelo() {
        ventas = new int[5][2];
        precios = new double[2];
        ingresosAlmacenes = new double[5];

        ventasLeidas = false;
        preciosLeidos = false;
        ingresosCalculados = false;
    }

    public void establecerVentas(int[][] nuevasVentas) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                ventas[i][j] = nuevasVentas[i][j];
            }
        }

        ventasLeidas = true;
        ingresosCalculados = false;
    }

    public void establecerPrecios(double precio1, double precio2) {
        precios[0] = precio1;
        precios[1] = precio2;

        preciosLeidos = true;
        ingresosCalculados = false;
    }

    public boolean hayVentasLeidas() {
        return ventasLeidas;
    }

    public boolean hayPreciosLeidos() {
        return preciosLeidos;
    }

    public boolean hayIngresosCalculados() {
        return ingresosCalculados;
    }

    public void calcularIngresos() {
        if (!ventasLeidas || !preciosLeidos) {
            throw new IllegalStateException(
                "Primero debes leer las ventas y los precios."
            );
        }

        ingresosTotales = 0;

        for (int i = 0; i < 5; i++) {
            ingresosAlmacenes[i] =
                ventas[i][0] * precios[0]
                + ventas[i][1] * precios[1];

            ingresosTotales += ingresosAlmacenes[i];
        }

        ingresosCalculados = true;
    }

    public int getVentas(int almacen, int producto) {
        return ventas[almacen][producto];
    }

    public double getPrecio(int producto) {
        return precios[producto];
    }

    public double getIngresosAlmacen(int almacen) {
        if (!ingresosCalculados) {
            throw new IllegalStateException(
                "Primero debes calcular los ingresos."
            );
        }

        return ingresosAlmacenes[almacen];
    }

    public double getIngresosTotales() {
        if (!ingresosCalculados) {
            throw new IllegalStateException(
                "Primero debes calcular los ingresos."
            );
        }

        return ingresosTotales;
    }
}