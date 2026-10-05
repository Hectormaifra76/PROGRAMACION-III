public class Alumno {
    private String nombre;
    private double nota1;
    private double nota2;
    private double notafinal;

    public Alumno(String nombre, double nota1, double nota2) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notafinal = notaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNotafinal() {
        return notafinal;
    }

    public double calcularNotaFinal() {
        return nota1 * 0.10 + nota2 * 0.10 + notafinal * 0.80;
    }
}

