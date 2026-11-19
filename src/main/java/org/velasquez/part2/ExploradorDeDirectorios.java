package org.velasquez.part2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

public class ExploradorDeDirectorios {
    public static void main(String[] args) {
        Path fichero= Path.of("recursos");

        try(Stream<Path> elementos= Files.list(fichero)) {
            System.out.println("ELEMENTOS DIRECTOS");
            elementos.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }


        try(Stream<Path> elementos= Files.walk(fichero)) {
            System.out.println("RECORRIDO COMPLETO");

            elementos.forEach(System.out::println);

        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }




        PathMatcher matcher= FileSystems.getDefault()
                .getPathMatcher("glob:*.txt");
        try(Stream<Path> elementos= Files.walk(fichero)) {

            System.out.println("FICHEROS TXT");
            elementos.filter(f-> Files.isRegularFile(f))
                    .filter(f-> matcher.matches(f.getFileName()))
                    .forEach(System.out::println);

        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
