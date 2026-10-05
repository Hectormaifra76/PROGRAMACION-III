public class Producto {
    private String nombre;
    private double precioSinIVA;

    public Producto(String nombre, double precioSinIVA) {
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public double getPrecioConIVA(double iva) {
        return precioSinIVA * (1 + iva); 
    }
}


