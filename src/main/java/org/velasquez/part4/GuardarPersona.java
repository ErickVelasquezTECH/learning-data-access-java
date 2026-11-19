package org.velasquez.part4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarPersona {
    public static void main(String[] args) {
        Persona persona = new Persona("Erick", 25);
        try (ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("persona.dat")
        )) {

            salida.writeObject(persona);
            System.out.println("Objeto guardado");


        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
