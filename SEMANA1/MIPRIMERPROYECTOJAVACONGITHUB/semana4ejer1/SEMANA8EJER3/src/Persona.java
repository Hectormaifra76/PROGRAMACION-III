public class Persona {
    private String nombre;
    private String telefono;
    private double peso;

    public Persona(String nombre, String telefono, double peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public double getPeso() { return peso; }

    public static String obtenerCabecera() {
        return String.format("%-25s %-18s %10s", "NOMBRE", "TELÉFONO", "PESO (kg)");
    }

    public String toFila() {
        return String.format("%-25s %-18s %10.2f", nombre, telefono, peso);
    }

    public String toTSV() {
        return nombre + "\t" + telefono + "\t" + peso;
    }
}
