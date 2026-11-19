package org.velasquez.part4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LeerPersonasCollection {
    public static void main(String[] args) {
        List<Persona>personas=new ArrayList<>();

        try (ObjectInputStream lectura=new ObjectInputStream(
                new FileInputStream("pareja.dat")
        )){
            personas= (ArrayList<Persona>) lectura.readObject();
            for (Persona persona: personas){
                System.out.println(persona.getNombre());
            }
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
