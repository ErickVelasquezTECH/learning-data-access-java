package org.velasquez.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ProteccionDeConfiguraciones {
    public static void main(String[] args) {
        Path fichero = Path.of("datos", "configuracion.txt");

        String linea = "Servidor=localhost\n" +
                "puerto=3306\n" +
                "usuario=root\n";

        try {
            Files.writeString(fichero, linea, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            System.out.println("Configuración creada correctamente.");
        }catch (FileAlreadyExistsException e){
            System.out.println("ERROR: La configuración ya existe.\n" +
                    "No se ha modificado el fichero.");
        }catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
