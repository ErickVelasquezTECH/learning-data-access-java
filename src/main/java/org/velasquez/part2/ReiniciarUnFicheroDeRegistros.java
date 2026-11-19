package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReiniciarUnFicheroDeRegistros {
    public static void main(String[] args) {
        Path fichero = Path.of("logs", "actividad.log");

        try {
            Files.writeString(fichero, "INFO - Nueva sesion iniciada\n", StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            Files.writeString(fichero, "INFO - Sistema preparado\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);


            String contenido = Files.readString(fichero, StandardCharsets.UTF_8);

            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


}
