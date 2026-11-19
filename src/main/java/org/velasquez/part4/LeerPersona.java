package org.velasquez.part4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class LeerPersona {
    public static void main(String[] args) {
        try (ObjectInput entrada=new ObjectInputStream(
                new FileInputStream("persona.dat")
        )){

            Persona persona= (Persona) entrada.readObject();
            System.out.println(persona.getNombre());
            System.out.println(persona.getEdad());
        }catch(IOException | ClassNotFoundException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
