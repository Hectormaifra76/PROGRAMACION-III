public class semana 2 ejer2 {
    public static void main(String[] args) {
        java.io.Console console = System.console();
        String nacimiento = console.readLine("Ingrese su fecha de nacimiento: ");
        int añoNacimiento = Integer.parseInt(nacimiento);
        String actual = console.readLine("Ingrese el año actual: ");
        int añoActual = Integer.parseInt(actual);
        int edad = añoActual - añoNacimiento;
        console.printf("Su edad es: %d años\n", edad);
    }
}

    