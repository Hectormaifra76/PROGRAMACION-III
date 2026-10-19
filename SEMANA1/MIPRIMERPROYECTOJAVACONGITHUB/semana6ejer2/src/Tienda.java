import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- GESTION DE PRODUCTOS ---");
            System.out.println("1. Dar de alta un producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Consultar un producto");
            System.out.println("4. Modificar un producto");
            System.out.println("5. Eliminar un producto");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    altaProducto();
                    break;

                case 2:
                    listarProductos();
                    break;

                case 3:
                    consultarProducto();
                    break;

                case 4:
                    modificarProducto();
                    break;

                case 5:
                    eliminarProducto();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // CREATE
    public static void altaProducto() {

        System.out.print("Codigo del producto: ");
        int codigo = Integer.parseInt(teclado.nextLine());

        if (buscarProducto(codigo) != null) {
            System.out.println("Ya existe un producto con ese codigo.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(teclado.nextLine());

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(teclado.nextLine());

        if (precio < 0 || cantidad < 0) {
            System.out.println("El precio y la cantidad no pueden ser negativos.");
            return;
        }

        Producto producto = new Producto(
                codigo, nombre, precio, cantidad);

        productos.add(producto);

        System.out.println("Producto añadido correctamente.");
    }

    // READ: mostrar todos los productos
    public static void listarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    // READ: consultar un producto
    public static void consultarProducto() {

        System.out.print("Introduce el codigo: ");
        int codigo = Integer.parseInt(teclado.nextLine());

        Producto producto = buscarProducto(codigo);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // UPDATE
    public static void modificarProducto() {

        System.out.print("Codigo del producto que quieres modificar: ");
        int codigo = Integer.parseInt(teclado.nextLine());

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = Double.parseDouble(teclado.nextLine());

        System.out.print("Nueva cantidad: ");
        int cantidad = Integer.parseInt(teclado.nextLine());

        if (precio < 0 || cantidad < 0) {
            System.out.println("El precio y la cantidad no pueden ser negativos.");
            return;
        }

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        System.out.println("Producto modificado correctamente.");
    }

    // DELETE
    public static void eliminarProducto() {

        System.out.print("Codigo del producto que quieres eliminar: ");
        int codigo = Integer.parseInt(teclado.nextLine());

        Producto producto = buscarProducto(codigo);

        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Metodo auxiliar para buscar por codigo
    public static Producto buscarProducto(int codigo) {

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }
}