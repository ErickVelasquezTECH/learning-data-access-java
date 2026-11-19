package org.velasquez.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.io.File;

public class LecturaClasicaConBufferedReader {
    public static void main(String[] args) {
        Path fichero = Path.of("datos", "alumnos.txt");


        try (BufferedReader lectura = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fichero.toFile()),
                        StandardCharsets.UTF_8
                )
        )) {

            String linea;
            while ((linea=lectura.readLine()) != null) {
                System.out.println(linea);
            }


        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
