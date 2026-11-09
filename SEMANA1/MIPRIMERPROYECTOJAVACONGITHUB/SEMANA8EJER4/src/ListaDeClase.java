import java.io.*; import java.nio.charset.StandardCharsets; import java.nio.file.*; import java.util.*;
public class ListaDeClase {
 private final List<DatosDeAlumno> alumnos=new ArrayList<>();
 public void crearListaAleatoria(int cantidad){alumnos.clear();Random r=new Random();Set<String> nifs=new HashSet<>();for(int i=0;i<cantidad;i++)alumnos.add(new DatosDeAlumno(Direccion.crearAleatoria(r),DatosPersonales.crearAleatorios(r,nifs)));}
 public List<DatosDeAlumno> getAlumnos(){return new ArrayList<>(alumnos);}
 public void exportarDatosPersonalesCSV(Path p)throws IOException{try(BufferedWriter w=Files.newBufferedWriter(p,StandardCharsets.UTF_8)){w.write("Nombre,Apellidos,Edad,NIF");w.newLine();for(DatosDeAlumno a:alumnos){w.write(a.getDatosPersonales().toCSV());w.newLine();}}}
 public void exportarDireccionesCSV(Path p)throws IOException{try(BufferedWriter w=Files.newBufferedWriter(p,StandardCharsets.UTF_8)){w.write("Calle,Numero,Piso,Letra");w.newLine();for(DatosDeAlumno a:alumnos){w.write(a.getDireccion().toCSV());w.newLine();}}}
}