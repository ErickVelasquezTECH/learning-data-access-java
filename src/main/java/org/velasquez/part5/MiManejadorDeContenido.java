package org.velasquez.part5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiManejadorDeContenido extends DefaultHandler {


    public MiManejadorDeContenido(){
        super();
    }


    @Override
    public void startDocument(){
        System.out.println("Comienzo del Documento XML");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final del documento XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("\tPrincipio elemento: "+localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("\tFinal del elemento: "+localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String letras=new String(ch, start ,length);
        letras=letras.replace("[\t\n]", "");
        System.out.println("\t\tContenido: "+letras);
    }
}
