public class DatosDeAlumno {
 private final Direccion direccion; private final DatosPersonales datosPersonales;
 public DatosDeAlumno(Direccion direccion,DatosPersonales datosPersonales){this.direccion=direccion;this.datosPersonales=datosPersonales;}
 public Direccion getDireccion(){return direccion;} public DatosPersonales getDatosPersonales(){return datosPersonales;}
 public static String obtenerCabecera(){return DatosPersonales.obtenerCabecera()+" | "+Direccion.obtenerCabecera();}
 public String toFila(){return datosPersonales.toFila()+" | "+direccion.toFila();}
}
