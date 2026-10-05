public class Usuario {
    private String nombre;
    private double peso;
    private double altura;

    public Usuario(String nombre, double peso, double altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public static Usuario crearUsuario(String[] datos) {
        String nombre = datos[0];
        double peso = Double.parseDouble(datos[1]);
        double altura = Double.parseDouble(datos[2]);
        return new Usuario(nombre, peso, altura);
    }
}
