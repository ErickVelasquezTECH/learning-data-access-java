package org.velasquez.part2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistroDeUsuarios {
    public static void main(String[] args) {
        Path fichero = Path.of("datos", "usuarios.txt");
        try {
            if (!Files.exists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }


            Files.writeString(fichero, "Erick\nCarlos\nJosue\nMaria", StandardCharsets.UTF_8);
            String contenido= Files.readString(fichero, StandardCharsets.UTF_8);
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }


    }
}
