package org.velasquez.part5;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class LecturaSAX2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory=SAXParserFactory.newDefaultInstance();
        SAXParser parser=factory.newSAXParser();

        MiManejadorDeContenido miManejadorDeContenido=new MiManejadorDeContenido();

        InputSource fileXML=new InputSource("alumnos.xml");

        parser.parse(fileXML, miManejadorDeContenido);
    }
}
