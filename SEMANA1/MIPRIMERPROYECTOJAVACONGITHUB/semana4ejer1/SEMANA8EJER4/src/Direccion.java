import java.util.Random;
public class Direccion {
 private final String calle; private final int numero,piso; private final String letra;
 public Direccion(String calle,int numero,int piso,String letra){this.calle=calle;this.numero=numero;this.piso=piso;this.letra=letra;}
 public static Direccion crearAleatoria(Random r){String[] c={"Mayor","Real","Cervantes","Gran Vía","Luna","Sol","Paz","Libertad","Olmo","Rosales"};String[] l={"A","B","C","D"};return new Direccion("Calle "+c[r.nextInt(c.length)],r.nextInt(150)+1,r.nextInt(8)+1,l[r.nextInt(l.length)]);}
 public String getCalle(){return calle;} public int getNumero(){return numero;} public int getPiso(){return piso;} public String getLetra(){return letra;}
 public static String obtenerCabecera(){return String.format("%-22s %6s %6s %-6s","CALLE","NÚMERO","PISO","LETRA");}
 public String toFila(){return String.format("%-22s %6d %6d %-6s",calle,numero,piso,letra);}
 public String toCSV(){return escapar(calle)+","+numero+","+piso+","+escapar(letra);}
 private static String escapar(String s){return "\""+s.replace("\"","\"\"")+"\"";}
}

