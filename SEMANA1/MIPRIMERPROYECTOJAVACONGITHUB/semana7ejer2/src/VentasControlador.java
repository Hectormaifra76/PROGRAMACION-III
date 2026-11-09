package controlador;

import modelo.VentasModelo;

public class VentasControlador {

    private final VentasModelo modelo;

    public VentasControlador(VentasModelo modelo) {
        this.modelo = modelo;
    }

    public void leerVentas(int[][] ventas) {
        modelo.establecerVentas(ventas);
    }

    public void leerPrecios(double precio1, double precio2) {
        modelo.establecerPrecios(precio1, precio2);
    }

    public boolean hayVentasLeidas() {
        return modelo.hayVentasLeidas();
    }

    public boolean hayPreciosLeidos() {
        return modelo.hayPreciosLeidos();
    }

    public boolean hayIngresosCalculados() {
        return modelo.hayIngresosCalculados();
    }

    public void calcularIngresos() {
        modelo.calcularIngresos();
    }

    public int getVentas(int almacen, int producto) {
        return modelo.getVentas(almacen, producto);
    }

    public double getPrecio(int producto) {
        return modelo.getPrecio(producto);
    }

    public double getIngresosAlmacen(int almacen) {
        return modelo.getIngresosAlmacen(almacen);
    }

    public double getIngresosTotales() {
        return modelo.getIngresosTotales();
    }
}