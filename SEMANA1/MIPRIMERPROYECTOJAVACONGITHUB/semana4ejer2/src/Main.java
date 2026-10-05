public class Main {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Uso: java Main <nombre> <peso> <altura>");
            return;
        }

        try {
            Usuario usuario = Usuario.crearUsuario(args);
            System.out.println("-----------------------------------------------");
            System.out.printf("%-15s %-10s %-10s %-10s%n",
                    "Nombre", "Peso", "Altura", "IMC");
            System.out.println("-----------------------------------------------");

            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f%n",
                    usuario.getNombre(),
                    usuario.getPeso(),
                    usuario.getAltura(),
                    usuario.calcularIMC());

            System.out.println("-----------------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Error: El peso y la altura deben ser números válidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Se requieren tres argumentos: nombre, peso y altura.");
        }
    }
}
