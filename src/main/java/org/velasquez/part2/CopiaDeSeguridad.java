package org.velasquez.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopiaDeSeguridad {
    public static void main(String[] args) {
        Path origen = Path.of("proyecto", "datos", "clientes.txt");
        Path destino = Path.of("backup", "clientes.txt");
        if (Files.exists(origen)) {

            try {
                Files.createDirectories(destino.getParent());
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING
                ,StandardCopyOption.COPY_ATTRIBUTES);
                System.out.println("OPERACION REALIZADA CORRECTAMENTE");
            } catch (IOException e) {
                System.out.println("ERROR: "+e.getMessage());
            }

        }
    }
}
