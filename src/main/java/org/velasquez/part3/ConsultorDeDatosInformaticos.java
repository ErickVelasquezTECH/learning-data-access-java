package org.velasquez.part3;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class ConsultorDeDatosInformaticos {
    public static void main(String[] args) {
        Path fichero = Path.of("empleados.dat");
        try (RandomAccessFile acceso = new RandomAccessFile(fichero.toFile(), "rw")) {
            acceso.setLength(0);
            String [] nombres={"Erick", "Mary", "Xin"};
            double[]salarios={1800.00, 1900.00, 1700.00};
            StringBuffer adaptador;
            for (int i = 0; i <nombres.length ; i++) {
                acceso.writeInt(i+1);
                adaptador=new StringBuffer(nombres[i]);
                adaptador.setLength(10);
                acceso.writeChars(adaptador.toString());
                acceso.writeDouble(salarios[i]);
            }
            System.out.println("Registros Creados");

            System.out.println("EMPLEADO 3:");
            int idBuscado=3;
            char[]caracteres=new char[10];
            char caracter;

            long positionID3=(idBuscado-1L)*32;
            long positionSalario3=(idBuscado-1L)*32+24;

            if (idBuscado<=0 || positionID3+32>acceso.length()){
                System.out.println("El empleado no existe");
            }else {
                acceso.seek(positionID3);
                int idEncontrado=acceso.readInt();
                for (int i = 0; i <caracteres.length ; i++) {
                    caracter=acceso.readChar();
                    caracteres[i]=caracter;
                }
                String nombre=new String(caracteres).trim();
                double salario= acceso.readDouble();
                System.out.printf("- ID: %d, Nombre: %s, Salario: %.2f€%n",
                        idEncontrado, nombre, salario);

                System.out.println("Modificando salario... (aumentando 100€)");
                acceso.seek(positionSalario3);
                double salarionuevo=salario+100;
                acceso.writeDouble(salarionuevo);
                System.out.printf("- ID: %d, Nombre: %s, Salario: %.2f€%n",
                        idEncontrado, nombre, salarionuevo);


                if (idBuscado!=idEncontrado){
                    System.out.println("Empleado sin registro");
                }
            }

        } catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
