import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Facturas {

    private List<Factura> lista;

    public Facturas() {
        lista = new ArrayList<>();
    }

    public void agregar(Factura factura) {
        lista.add(factura);
    }

    public List<Factura> getLista() {
        return lista;
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int cargarTSV(Path ruta) throws IOException {

        int cargadas = 0;

        try (BufferedReader br = Files.newBufferedReader(
                ruta, StandardCharsets.UTF_8)) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {

                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linea.split("\\t", -1);

                if (campos.length != 8) {
                    System.out.println("Línea " + numeroLinea
                            + " ignorada: debe tener 8 campos.");
                    continue;
                }

                try {
                    String concepto = campos[0].trim();

                    double descuento = Double.parseDouble(
                            campos[1].trim().replace(",", "."));

                    String fecha = campos[2].trim();

                    double importe = Double.parseDouble(
                            campos[3].trim().replace(",", "."));

                    String nif = campos[4].trim();
                    String nombre = campos[5].trim();
                    String direccion = campos[6].trim();

                    double iva = Double.parseDouble(
                            campos[7].trim().replace(",", "."));

                    if (descuento < 0 || descuento >= 1
                            || iva < 0 || importe < 0) {

                        System.out.println("Línea " + numeroLinea
                                + " ignorada: valores no válidos.");
                        continue;
                    }

                    agregar(new Factura(concepto, descuento, fecha,
                            importe, nif, nombre, direccion, iva));

                    cargadas++;

                } catch (NumberFormatException e) {

                    System.out.println("Línea " + numeroLinea
                            + " ignorada: error en un número.");
                }
            }
        }

        return cargadas;
    }

    public List<Factura> buscarPorTotalMinimo(double minimo) {

        List<Factura> resultado = new ArrayList<>();

        for (Factura factura : lista) {

            if (factura.calcularTotal() > minimo) {
                resultado.add(factura);
            }
        }

        return resultado;
    }

    public void exportarCSV(Path ruta) throws IOException {

        try (BufferedWriter bw = Files.newBufferedWriter(
                ruta, StandardCharsets.UTF_8)) {

            bw.write(Factura.cabeceraCSV());
            bw.newLine();

            for (Factura factura : lista) {
                bw.write(factura.toCSV());
                bw.newLine();
            }
        }
    }

    public void exportarHTML(Path ruta) throws IOException {

        String plantilla = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <title>Listado de facturas</title>
                  <style>
                    body { font-family: Arial, sans-serif; margin: 30px; }
                    table { border-collapse: collapse; width: 100%; }
                    th, td { border: 1px solid #999; padding: 8px; }
                    th { background: #eeeeee; }
                    tr:nth-child(even) { background: #f7f7f7; }
                  </style>
                </head>
                <body>
                  <h1>Listado de facturas</h1>
                  <p>Total de facturas: %%NUMERO%%</p>
                  <table>
                    <thead>
                    <tr>
                      <th>Concepto</th>
                      <th>Descuento</th>
                      <th>Fecha</th>
                      <th>Importe</th>
                      <th>NIF</th>
                      <th>Cliente</th>
                      <th>Dirección</th>
                      <th>IVA</th>
                      <th>Total</th>
                    </tr>
                    </thead>
                    <tbody>%%TABLA%%</tbody>
                  </table>
                </body>
                </html>
                """;

        StringBuilder tabla = new StringBuilder();

        for (Factura f : lista) {

            tabla.append("<tr>")
                    .append("<td>").append(html(f.getConcepto())).append("</td>")
                    .append("<td>").append(f.getDescuento()).append("</td>")
                    .append("<td>").append(html(f.getFecha())).append("</td>")
                    .append("<td>").append(f.getImporte()).append("</td>")
                    .append("<td>").append(html(f.getNif())).append("</td>")
                    .append("<td>").append(html(f.getNombreCliente())).append("</td>")
                    .append("<td>").append(html(f.getDireccion())).append("</td>")
                    .append("<td>").append(f.getIva()).append("</td>")
                    .append("<td>").append(f.calcularTotal()).append("</td>")
                    .append("</tr>\n");
        }

        String html = plantilla
                .replace("%%NUMERO%%", String.valueOf(lista.size()))
                .replace("%%TABLA%%", tabla.toString());

        Files.writeString(ruta, html, StandardCharsets.UTF_8);
    }

    private String html(String texto) {

        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}