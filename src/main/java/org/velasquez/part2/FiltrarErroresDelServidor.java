package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FiltrarErroresDelServidor {
    public static void main(String[] args) {
        Path servidor = Path.of("datos", "servidor.log");

        try (Stream<String> lectura = Files.lines(servidor, StandardCharsets.UTF_8)) {

            lectura.filter(linea->linea.contains("ERROR"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
