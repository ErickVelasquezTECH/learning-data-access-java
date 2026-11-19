package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SistemaDeLogs {
    public static void main(String[] args) {
        Path fichero= Path.of("logs", "actividad.log");
        try {
            if (!Files.exists(fichero.getParent())){
                Files.createDirectories(fichero.getParent());
            }

            Files.writeString(fichero, "INFO - Aplicacion iniciada\n", StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(fichero, "INFO - Usuario autenticado\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(fichero, "WARNING - Memoria elevada\n", StandardCharsets.UTF_8,  StandardOpenOption.APPEND);

            String contenido=Files.readString(fichero);
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

    }


}
