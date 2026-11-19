package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AnalisisDeRegistro {
    public static void main(String[] args) {
        Path fichero = Path.of("datos", "servidor.log");
        try {
            List<String> lineas = Files.readAllLines(fichero, StandardCharsets.UTF_8);
            System.out.println("Existen un total de "+ lineas.size()+" registros");
            long countInfo=lineas.stream().filter(l->l.contains("INFO")).count();
            long countWarning=lineas.stream().filter(l->l.contains("WARNING")).count();
            long countError=lineas.stream().filter(l->l.contains("ERROR")).count();

            System.out.println("- "+countInfo+" registros de INFO");
            System.out.println("- "+countWarning+" registros de WARNING");
            System.out.println("- "+countError+" registros de ERROR");
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }
}
