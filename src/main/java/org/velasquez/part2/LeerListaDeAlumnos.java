package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LeerListaDeAlumnos {
    public static void main(String[] args) {
        Path fichero=Path.of("datos", "alumnos.txt");

        try {


            List<String> lineas=Files.readAllLines(fichero, StandardCharsets.UTF_8 );

            for (String linea: lineas){
                System.out.println(linea);
            }


        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }



    }
}
