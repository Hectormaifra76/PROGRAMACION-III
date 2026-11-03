public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha,
                   double importe, String nif, String nombreCliente,
                   String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public String getNif() {
        return nif;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getIva() {
        return iva;
    }

    public double calcularTotal() {
        return importe * (1 - descuento) * (1 + iva);
    }

    public String toCSV() {
        return escaparCSV(concepto) + "," + descuento + "," + escaparCSV(fecha)
                + "," + importe + "," + escaparCSV(nif) + ","
                + escaparCSV(nombreCliente) + "," + escaparCSV(direccion)
                + "," + iva + "," + calcularTotal();
    }

    private String escaparCSV(String texto) {
        return "\"" + texto.replace("\"", "\"\"") + "\"";
    }

    public static String cabeceraCSV() {
        return "Concepto,Descuento,Fecha,Importe,NIF,Nombre cliente,Direccion,IVA,Total";
    }

    @Override
    public String toString() {
        return String.format(
                "%-27s %-10s %-12s %10.2f %-12s %-22s %-35s %5.2f %10.2f",
                concepto, descuento, fecha, importe, nif,
                nombreCliente, direccion, iva, calcularTotal());
    }
}