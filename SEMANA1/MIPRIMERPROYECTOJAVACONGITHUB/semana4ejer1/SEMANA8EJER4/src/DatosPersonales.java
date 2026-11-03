import java.util.Random; import java.util.Set;
public class DatosPersonales {
 private final String nombre,apellidos,nif; private final int edad;
 public DatosPersonales(String nombre,String apellidos,int edad,String nif){this.nombre=nombre;this.apellidos=apellidos;this.edad=edad;this.nif=nif;}
 public static DatosPersonales crearAleatorios(Random r,Set<String> usados){String[] n={"Lucía","Hugo","Martina","Daniel","Sofía","Pablo","Valeria","Alejandro","Carmen","Mario","Paula","Adrián","Elena","Marcos","Irene","David","Alba","Javier","Claudia","Álvaro"};String[] a={"García","Fernández","González","Rodríguez","López","Martínez","Sánchez","Pérez","Gómez","Martín","Jiménez","Ruiz","Hernández","Díaz"};String nif;do{int x=r.nextInt(100_000_000);nif=String.format("%08d",x)+"TRWAGMYFPDXBNJZSQVHLCKE".charAt(x%23);}while(!usados.add(nif));return new DatosPersonales(n[r.nextInt(n.length)],a[r.nextInt(a.length)]+" "+a[r.nextInt(a.length)],r.nextInt(8)+18,nif);}
 public String getNombre(){return nombre;} public String getApellidos(){return apellidos;} public int getEdad(){return edad;} public String getNif(){return nif;}
 public static String obtenerCabecera(){return String.format("%-14s %-25s %5s %-10s","NOMBRE","APELLIDOS","EDAD","NIF");}
 public String toFila(){return String.format("%-14s %-25s %5d %-10s",nombre,apellidos,edad,nif);}
 public String toCSV(){return escapar(nombre)+","+escapar(apellidos)+","+edad+","+escapar(nif);}
 private static String escapar(String s){return "\""+s.replace("\"","\"\"")+"\"";}
}
