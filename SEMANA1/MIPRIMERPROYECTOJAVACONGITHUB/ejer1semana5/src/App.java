package paquete2;

import paquete1.Clase1;
// import paquete1.Clase2; // Da error: Clase2 no es public

public class App {

    public static void main(String[] args) {

        Clase1 objeto = new Clase1();

        // Atributo public: SI se puede acceder
        objeto.atributoPublic = 10;

        // Atributo sin modificador: NO se puede acceder
        // objeto.atributoDefault = 20;

        // Atributo protected: NO se puede acceder
        // objeto.atributoProtected = 30;

        // Atributo private: NO se puede acceder
        // objeto.atributoPrivate = 40;


        // Metodo public: SI se puede acceder
        objeto.metodoPublic();

        // Metodo sin modificador: NO se puede acceder
        // objeto.metodoDefault();

        // Metodo protected: NO se puede acceder
        // objeto.metodoProtected();

        // Metodo private: NO se puede acceder
        // objeto.metodoPrivate();

        System.out.println("Programa ejecutado correctamente.");
    }
}