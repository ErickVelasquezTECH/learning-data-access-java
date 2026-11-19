package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RegistroDeEventos {


    public static void main(String[] args) {
        Path fichero= Path.of("datos", "eventos.log");
        try {
            if (!Files.exists(fichero.getParent())){
                Files.createDirectories(fichero.getParent());
            }
            Files.writeString(
                    fichero,
                    "Usuario conectado\n",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }


    }
}
