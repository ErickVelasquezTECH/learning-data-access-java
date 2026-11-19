package org.velasquez.part4;

import java.io.*;

public class LeerPersonasFor {
    public static void main(String[] args) {

        Persona persona;
        try (ObjectInputStream lectura = new ObjectInputStream(
                new FileInputStream("personas.dat")
        )) {
            while (true) {
             persona=(Persona) lectura.readObject();
                System.out.println(persona.getNombre());
            }

        }catch (EOFException e){
            System.out.println("FIN de lectura :D");
        } catch (ClassNotFoundException e){
            System.out.println("Error en la clase java: "+e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println("Error en fichero: "+e.getMessage());
        }
        catch (IOException e) {System.out.println("ERROR: " + e.getMessage());
        }
    }
}
