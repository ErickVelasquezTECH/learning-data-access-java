package org.velasquez.part4;

import java.io.*;

public class GuardarPersonasFor {
    public static void main(String[] args) {
        Persona persona;
        String[]nombres={"Erick", "Mary", "Xin"};
        int[] edad={25,25,21};

        try (ObjectOutputStream escritura=new ObjectOutputStream(
                new FileOutputStream("personas.dat", true)
        )){
            for (int i = 0; i <nombres.length ; i++) {
                persona=new Persona(nombres[i], edad[i]);
                escritura.writeObject(persona);
            }
            System.out.println("ESCRITURA CORRECTA");

        }catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir o crear el fichero");

        } catch (NotSerializableException e) {
            System.out.println("El objeto no es serializable");

        } catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
