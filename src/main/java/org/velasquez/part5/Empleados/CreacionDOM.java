package org.velasquez.part5.Empleados;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreacionDOM {
    public static void main(String[] args) {

        File fichero = new File("registro.bat");
        try (RandomAccessFile lecturaBinaria = new RandomAccessFile(fichero, "r");) {
            int id;
            char[] nombreProducto =new char[12];
            char letra;
            int cantidad;
            double precio;
            int position=0;

            DocumentBuilderFactory fabrica=DocumentBuilderFactory.newInstance();
            DocumentBuilder convertidor=fabrica.newDocumentBuilder();
            DOMImplementation implementacion=convertidor.getDOMImplementation();
            Document arbol=implementacion.createDocument(null, "Productos", null);
            arbol.setXmlVersion("1.0");

            for (;;){
                lecturaBinaria.seek(position);
                id=lecturaBinaria.readInt();
                for (int i = 0; i < nombreProducto.length; i++) {
                    letra=lecturaBinaria.readChar();
                    nombreProducto[i]=letra;
                }
                String nombreProductoCompleto=new String(nombreProducto);
                cantidad=lecturaBinaria.readInt();
                precio=lecturaBinaria.readDouble();
                if (id>0){
                    Element padre=arbol.createElement("producto");
                    arbol.getDocumentElement().appendChild(padre);

                    crearElemento("id", Integer.toString(id), padre, arbol);
                    crearElemento("nombre", nombreProductoCompleto.trim(), padre, arbol);
                    crearElemento("cantidad", Integer.toString(cantidad), padre, arbol);
                    crearElemento("precio", Double.toString(precio), padre, arbol);
                }
                position=position+40;
                if (lecturaBinaria.getFilePointer()==lecturaBinaria.length()){
                    break;
                }
            }

            DOMSource source=new DOMSource(arbol);
            StreamResult result=new StreamResult(new File("Productos.xml"));
            Transformer transformador= TransformerFactory.newInstance().newTransformer();
            transformador.transform(source, result);

        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        catch (ParserConfigurationException e) {
            System.out.println("ERROR parser: "+e.getMessage());
        }
        catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }


    }

    public static void crearElemento(String tag, String valor,Element padre, Document document){
        Element element=document.createElement(tag);
        Text text=document.createTextNode(valor);
        padre.appendChild(element);
        element.appendChild(text);
    }

}
