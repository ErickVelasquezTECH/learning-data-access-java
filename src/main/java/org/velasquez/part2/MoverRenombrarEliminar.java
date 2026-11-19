package org.velasquez.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoverRenombrarEliminar {

    public static void main(String[] args) {
        Path fichero=Path.of("documentos", "borrador.txt");
        Path fichero2=Path.of("documentos", "temporal.txt");

        Path renombrado=Path.of("documentos", "informe_final.txt");
        try {
            Files.move(fichero, renombrado, StandardCopyOption.ATOMIC_MOVE);
            Path rutaNueva=Path.of("finalizados");
            Files.createDirectories(rutaNueva);
            Files.move(renombrado, rutaNueva.resolve(renombrado.getFileName()), StandardCopyOption.ATOMIC_MOVE );
            boolean result= Files.deleteIfExists(fichero2);
            if (result){
                System.out.println("Archivo eliminado");
            }else{
                System.out.println("Error al eliminar");
            }

        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
