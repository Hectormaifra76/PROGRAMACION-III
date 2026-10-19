import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Coche> coches = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- CONCESIONARIO DE COCHES ---");
            System.out.println("1. Dar de alta un coche");
            System.out.println("2. Mostrar todos los coches");
            System.out.println("3. Consultar un coche");
            System.out.println("4. Modificar un coche");
            System.out.println("5. Eliminar un coche");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    altaCoche();
                    break;
                case 2:
                    listarCoches();
                    break;
                case 3:
                    consultarCoche();
                    break;
                case 4:
                    modificarCoche();
                    break;
                case 5:
                    eliminarCoche();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // CREATE: dar de alta un coche
    public static void altaCoche() {

        System.out.print("Matricula: ");
        String matricula = teclado.nextLine();

        if (buscarCoche(matricula) != null) {
            System.out.println("Ya existe un coche con esa matricula.");
            return;
        }

        System.out.print("Marca: ");
        String marca = teclado.nextLine();

        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(teclado.nextLine());

        System.out.print("Unidades disponibles: ");
        int unidades = Integer.parseInt(teclado.nextLine());

        if (precio < 0 || unidades < 0) {
            System.out.println("El precio y las unidades no pueden ser negativos.");
            return;
        }

        Coche coche = new Coche(
                matricula, marca, modelo, precio, unidades);

        coches.add(coche);

        System.out.println("Coche añadido correctamente.");
    }

    // READ: listar todos los coches
    public static void listarCoches() {

        if (coches.isEmpty()) {
            System.out.println("No hay coches en el concesionario.");
            return;
        }

        for (Coche coche : coches) {
            System.out.println(coche);
        }
    }

    // READ: consultar un coche por matricula
    public static void consultarCoche() {

        System.out.print("Introduce la matricula: ");
        String matricula = teclado.nextLine();

        Coche coche = buscarCoche(matricula);

        if (coche != null) {
            System.out.println(coche);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    // UPDATE: modificar los datos de un coche
    public static void modificarCoche() {

        System.out.print("Introduce la matricula del coche: ");
        String matricula = teclado.nextLine();

        Coche coche = buscarCoche(matricula);

        if (coche == null) {
            System.out.println("Coche no encontrado.");
            return;
        }

        System.out.print("Nueva marca: ");
        String marca = teclado.nextLine();

        System.out.print("Nuevo modelo: ");
        String modelo = teclado.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = Double.parseDouble(teclado.nextLine());

        System.out.print("Nuevas unidades: ");
        int unidades = Integer.parseInt(teclado.nextLine());

        if (precio < 0 || unidades < 0) {
            System.out.println("El precio y las unidades no pueden ser negativos.");
            return;
        }

        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setPrecio(precio);
        coche.setUnidades(unidades);

        System.out.println("Coche modificado correctamente.");
    }

    // DELETE: eliminar un coche
    public static void eliminarCoche() {

        System.out.print("Introduce la matricula del coche: ");
        String matricula = teclado.nextLine();

        Coche coche = buscarCoche(matricula);

        if (coche != null) {
            coches.remove(coche);
            System.out.println("Coche eliminado correctamente.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    // Metodo auxiliar para buscar un coche
    public static Coche buscarCoche(String matricula) {

        for (Coche coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return coche;
            }
        }

        return null;
    }
}