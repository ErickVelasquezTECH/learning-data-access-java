package org.velasquez.part5;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class LecturaSAX {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser= XMLReaderFactory.createXMLReader();

        MiManejadorDeContenido miManejadorDeContenido=new MiManejadorDeContenido();

        parser.setContentHandler(miManejadorDeContenido);

        InputSource fileXML=new InputSource("alumnos.xml");

        parser.parse(fileXML);


    }
}
