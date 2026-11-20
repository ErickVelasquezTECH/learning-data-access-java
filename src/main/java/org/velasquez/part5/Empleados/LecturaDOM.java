package org.velasquez.part5.Empleados;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class LecturaDOM {
    public static void main(String[] args) {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder convertidor = fabrica.newDocumentBuilder();
            Document arbol = convertidor.parse(new File("Empleados.xml"));

            System.out.println("RAIZ: "+arbol.getDocumentElement().getNodeName());
            NodeList empleados=arbol.getElementsByTagName("empleado");

            for (int i = 0; i <empleados.getLength() ; i++) {
                Node empleado=empleados.item(i);

                if (empleado.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) empleado;
                    System.out.println("ID: "+element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("- Apellido: "+element.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.println("- Departamento: "+element.getElementsByTagName("dep").item(0).getTextContent());
                    System.out.println("- Salario: "+element.getElementsByTagName("salario").item(0).getTextContent());
                }

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }
}
