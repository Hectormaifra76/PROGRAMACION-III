public class Person {

    private String nombre;
    private double altura;
    private double peso;

    public Person() {
        this.nombre = "Sin nombre";
        this.altura = 1.70;
        this.peso = 70.0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularIMC() {

        if (altura <= 0 || peso <= 0) {
            return -1;
        }

        return peso / (altura * altura);
    }
}
