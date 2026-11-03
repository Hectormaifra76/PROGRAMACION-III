import java.util.Scanner;
public class Main { public static void main(String[] args){Scanner teclado=new Scanner(System.in);ListaDeClase modelo=new ListaDeClase();ListaDeClaseVista vista=new ListaDeClaseVista(teclado);ListaDeClaseControlador controlador=new ListaDeClaseControlador(modelo,vista);controlador.iniciar();teclado.close();} }
