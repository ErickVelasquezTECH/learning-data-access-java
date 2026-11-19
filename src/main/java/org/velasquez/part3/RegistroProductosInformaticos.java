package org.velasquez.part3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class RegistroProductosInformaticos {


    public static void main(String[] args) {
        Path fichero=Path.of("registro.bat");

        try ( RandomAccessFile acceso=new RandomAccessFile(fichero.toFile(),"rw")){
            acceso.setLength(0);

            String[]productos={"TECLADO", "RATON", "MONITOR", "DISCO"};
            int[] cantidades={15,30,8,12};
            double[]precios={49.99, 25.50, 189.95, 79.90};

            StringBuffer adaptador;

            for (int i = 0; i < productos.length ; i++) {

                acceso.writeInt(i+1);
                adaptador=new StringBuffer(productos[i]);
                adaptador.setLength(12);
                acceso.writeChars(adaptador.toString());
                acceso.writeInt(cantidades[i]);
                acceso.writeDouble(precios[i]);
            }
            System.out.println(acceso.length());
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }







    }
}
