public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private double Precio;
    private int unidades;

   public Coche(String matricula, String marca, String modelo,
                 double precio, int unidades) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.unidades = unidades;
    }
public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula
                + " | Marca: " + marca
                + " | Modelo: " + modelo
                + " | Precio: " + precio + " euros"
                + " | Unidades: " + unidades;
    }
}

}
