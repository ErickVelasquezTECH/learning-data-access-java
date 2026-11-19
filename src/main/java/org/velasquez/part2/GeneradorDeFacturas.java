package org.velasquez.part2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeneradorDeFacturas {

    public static void main(String[] args) {
        Path fichero = Path.of("facturas", "factura.txt");

        try {
            if (!Files.exists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }
            try (PrintWriter pw = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fichero.toFile(), false),
                            StandardCharsets.UTF_8)))
            {
                pw.println("FACTURA DE COMPRA");
                pw.println("Producto: Teclado mecanico");
                pw.printf("Precio : %.2f €%n", 89.99);
                pw.println("Producto: Raton inalambrico");
                pw.printf("Precio : %.2f €%n", 45.50);
                pw.println("Producto: Monitor 24 pulgadas");
                pw.printf("Precio : %.2f €%n", 179.90);
                pw.printf("TOTAL: %.2f € %n",89.99+ 45.50+179.90);


            }
            String contenido = Files.readString(fichero, StandardCharsets.UTF_8);
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
