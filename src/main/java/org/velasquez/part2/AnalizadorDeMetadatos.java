package org.velasquez.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class AnalizadorDeMetadatos {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dime la ruta");
        Path fichero= Path.of(scanner.nextLine()).normalize();

        if (Files.exists(fichero)){
            try{
                BasicFileAttributes metadatos= Files.readAttributes(
                        fichero, BasicFileAttributes.class);

                System.out.println("Tamaño: "+metadatos.size());
                System.out.println("Creacion: "+metadatos.creationTime());
                System.out.println("Ultima modificacion: "+metadatos.lastModifiedTime());
                System.out.println("Es fichero normal: "+metadatos.isRegularFile());
                System.out.println("Es directorio: "+metadatos.isDirectory());

            }catch (IOException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }



    }
}
