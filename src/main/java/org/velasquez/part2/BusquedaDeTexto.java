package org.velasquez.part2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

public class BusquedaDeTexto {
    public static void main(String[] args) {
        Path raiz=Path.of("proyecto");

        PathMatcher filtro= FileSystems.getDefault()
                .getPathMatcher("glob:*.txt");

        try(Stream<Path>arbol= Files.walk(raiz)) {
            arbol.filter(Files::isRegularFile)
                    .filter(path -> filtro.matches(path.getFileName()))
                    .forEach(path -> System.out.println(path.getFileName()));

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
