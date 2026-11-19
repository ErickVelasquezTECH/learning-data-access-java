package org.velasquez.part4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GuardarPersonasCollection {
    public static void main(String[] args) {
        List<Persona>personas=new ArrayList<>();
        personas.add(new Persona("Erick",25));
        personas.add(new Persona("Mary",25));

        try(ObjectOutputStream escritura=new ObjectOutputStream(
                new FileOutputStream("pareja.dat")
        )) {
            escritura.writeObject(personas);
            System.out.println("ESCRITORA FINALIZADA");
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
