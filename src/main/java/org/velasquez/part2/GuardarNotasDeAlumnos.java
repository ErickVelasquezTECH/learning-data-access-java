package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GuardarNotasDeAlumnos {
    public static void main(String[] args) {
        List<String> datos = new ArrayList<>();
        datos.add("Erick - 9.5");
        datos.add("Carlos - 8.2");
        datos.add("Josué - 7.8");
        datos.add("María - 9.1");

        Path fichero=Path.of("datos", "notas.txt");

        try {
            Files.write(fichero, datos, StandardCharsets.UTF_8);
            List<String>contenido=Files.readAllLines(fichero, StandardCharsets.UTF_8);
            contenido.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage() );
        }


    }
}
