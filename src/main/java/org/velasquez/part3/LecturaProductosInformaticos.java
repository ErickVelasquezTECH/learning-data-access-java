package org.velasquez.part3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class LecturaProductosInformaticos {
    public static void main(String[] args) {
        Path fichero = Path.of("registro.bat");


        try (RandomAccessFile acceso = new RandomAccessFile(fichero.toFile(), "r")) {


            int id, cantidad;
            double precio;
            char [] caracteres=new char[12];
            char caracter;

            int posicion=0;

            while (acceso.getFilePointer() < acceso.length()){
                acceso.seek(posicion);
                id=acceso.readInt();
                for (int i = 0; i <caracteres.length ; i++) {
                    caracter=acceso.readChar();
                    caracteres[i]=caracter;
                }
                String producto=new String(caracteres).trim();
                cantidad= acceso.readInt();
                precio=acceso.readDouble();

                if (id>0){
                    System.out.printf("- ID: %d , Producto: %s , Cantidad: %d , Precio: %.2f\n",
                            id,producto,cantidad,precio);
                }
                posicion=posicion+40;

            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }
}
