import es.usal.progiii.tools.Esdia;

public class Ejercicio {

    public static void main(String[] args) {
        Person persona1 = new Person();
        Person persona2 = new Person();
        Person persona3 = new Person();

        persona1.setNombre(Esdia.readString("Introduce el nombre de la primera persona: "));
        persona1.setAltura(Esdia.readFloat("Introduce la altura de " + persona1.getNombre() + ": "));
        persona1.setPeso(Esdia.readFloat("Introduce el peso de " + persona1.getNombre() + ": "));

        persona2.setNombre(Esdia.readString("Introduce el nombre de la segunda persona: "));
        persona2.setAltura(Esdia.readFloat("Introduce la altura de " + persona2.getNombre() + ": "));
        persona2.setPeso(Esdia.readFloat("Introduce el peso de " + persona2.getNombre() + ": "));


        persona3.setNombre(Esdia.readString("Introduce el nombre de la tercera persona: "));
        persona3.setAltura(Esdia.readFloat("Introduce la altura de " + persona3.getNombre() + ": "));
        persona3.setPeso(Esdia.readFloat("Introduce el peso de " + persona3.getNombre() + ": "));

        Person masAlta = persona1;
        if (persona2.getAltura() > masAlta.getAltura()) {
            masAlta = persona2;
        }

        if (persona3.getAltura() > masAlta.getAltura()) {
            masAlta = persona3;
        }

       
        Person masPeso = persona1;

        if (persona2.getPeso() > masPeso.getPeso()) {
            masPeso = persona2;
        }

        if (persona3.getPeso() > masPeso.getPeso()) {
            masPeso = persona3;
        }

       
        System.out.println();
        System.out.println("La persona más alta es " + masAlta.getNombre()
                + " con " + masAlta.getAltura() + " cm.");

        System.out.println("La persona que más pesa es " + masPeso.getNombre()
                + " con " + masPeso.getPeso() + " kg.");
    }
}
