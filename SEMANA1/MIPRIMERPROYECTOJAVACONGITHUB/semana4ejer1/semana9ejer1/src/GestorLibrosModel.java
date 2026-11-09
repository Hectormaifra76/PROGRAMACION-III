package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import es.usal.progiii.tools.Rutas;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    private ArrayList<Libro> libros;

    private final Path pathToXML =
            Rutas.pathToFileOnDesktop("libros.xml");

    private final Path pathToJSON =
            Rutas.pathToFileOnDesktop("libros.json");

    private final Path pathToCSV =
            Rutas.pathToFileOnDesktop("libros.csv");

    private final Path pathToBinary =
            Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<>();
    }

    public void addLibro(Libro l) {
        if (l != null && !libros.contains(l))
            libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {

        int pos = libros.indexOf(l);

        if (pos >= 0)
            libros.set(pos, l);
    }

    public ArrayList<Libro> getLibros() {
        return new ArrayList<>(libros);
    }

    // EXPORTAR CSV
    public int exportBooksToCSV() {

        try {
            StringBuilder contenido = new StringBuilder();

            contenido.append(
                    "ISBN,Titulo,Autor,Editorial,AnyoPublicacion,NumPaginas,Precio\n");

            for (Libro l : libros) {
                contenido.append(l.asDelimitedString(","))
                        .append('\n');
            }

            Files.write(pathToCSV,
                    contenido.toString().getBytes(StandardCharsets.UTF_8));

            return libros.size();

        } catch (IOException e) {
            return -1;
        }
    }

    // IMPORTAR CSV
    public int importBooksFromCSV() {

        try {
            List<String> lineas = Files.readAllLines(
                    pathToCSV, StandardCharsets.UTF_8);

            int anadidos = 0;

            for (int i = 0; i < lineas.size(); i++) {

                String linea = lineas.get(i).trim();

                if (linea.isEmpty()
                        || (i == 0 && linea.startsWith("ISBN,")))
                    continue;

                Libro l = Libro.fromDelimitedString(linea, ",");

                if (l != null && !libros.contains(l)) {
                    libros.add(l);
                    anadidos++;
                }
            }

            return anadidos;

        } catch (IOException e) {
            return -1;
        }
    }

    // EXPORTAR JSON
    public int exportBooksToJSON() {

        try {
            Gson gson = new Gson();

            Files.write(pathToJSON,
                    gson.toJson(libros).getBytes(StandardCharsets.UTF_8));

            return libros.size();

        } catch (IOException e) {
            return -1;
        }
    }

    // IMPORTAR JSON
    public int importBooksFromJSON() {

        try {
            String json = new String(
                    Files.readAllBytes(pathToJSON),
                    StandardCharsets.UTF_8);

            Type tipo = new TypeToken<ArrayList<Libro>>() {
            }.getType();

            ArrayList<Libro> importados =
                    new Gson().fromJson(json, tipo);

            return incorporar(importados);

        } catch (Exception e) {
            return -1;
        }
    }

    // IMPORTAR XML
    public int importBooksFromXML() {

        try {
            String xml = new String(
                    Files.readAllBytes(pathToXML),
                    StandardCharsets.UTF_8);

            XmlMapper mapper = new XmlMapper();

            List<Libro> importados = mapper.readValue(
                    xml,
                    mapper.getTypeFactory()
                            .constructCollectionType(ArrayList.class, Libro.class));

            return incorporar(importados);

        } catch (Exception e) {
            return -1;
        }
    }

    // EXPORTAR XML
    public int exportBooksToXML() {

        try {
            XmlMapper mapper = new XmlMapper();

            String xml = mapper.writeValueAsString(libros);

            Files.write(pathToXML,
                    xml.getBytes(StandardCharsets.UTF_8));

            return libros.size();

        } catch (Exception e) {
            return -1;
        }
    }

    // INCORPORAR LIBROS IMPORTADOS
    private int incorporar(List<Libro> importados) {

        if (importados == null)
            return 0;

        int anadidos = 0;

        for (Libro l : importados) {

            if (l != null && !libros.contains(l)) {
                libros.add(l);
                anadidos++;
            }
        }

        return anadidos;
    }

    // GUARDAR ESTADO BINARIO
    public int saveStateOfTheApp() {

        try (ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(pathToBinary.toFile()))) {

            out.writeObject(libros);

            return libros.size();

        } catch (IOException e) {
            return -1;
        }
    }

    // CARGAR ESTADO BINARIO
    public int loadStateOfTheApp() {

        if (!Files.exists(pathToBinary))
            return -2;

        try (ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(pathToBinary.toFile()))) {

            Object objeto = in.readObject();

            if (!(objeto instanceof ArrayList<?>))
                return -1;

            ArrayList<?> lista = (ArrayList<?>) objeto;

            ArrayList<Libro> cargados = new ArrayList<>();

            for (Object o : lista) {
                if (o instanceof Libro)
                    cargados.add((Libro) o);
            }

            libros = cargados;

            return libros.size();

        } catch (Exception e) {
            return -1;
        }
    }
}