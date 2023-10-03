package parser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** @author pacopulido
 * 
 * Clase especial que nos ayuda a parsear un xml a traves de una url
 * El constructor se encarga de obtener los dos atributos necesarios para parsear:
 * - DocumentBuilder
 * - InputSource
 *
 */
public class DOMParserWeb {
	private InputSource is;
	private DocumentBuilder builder;

	public DOMParserWeb(String strUrl) {
		// abrimos la pagina y obtenemos nuestro canal is para luego parsear
		

		try {
			// creamos el fuente a traves del stream que es el que necesita el parseador
			this.is=new InputSource(new URL(strUrl).openStream());
		} catch (MalformedURLException e) {
			System.out.println("parsermf");
			e.printStackTrace();
		} catch (IOException e) {
            System.out.println("parserio");
			e.printStackTrace();
		}
		// Creamos nuestro atributo  DocumentBuilder para luego parsear
		builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("builder");
			e.printStackTrace();
		}
	}

	public Document getDocumento() {
		// Con nuestros dos atributos ya podemos parsear y obtener el DOCUMENTO.
		// Co este Documento ya podemos trabajar y sacarle las tripas (los nodos)
		Document doc = null;
		try {
			doc = builder.parse(is);
		} catch (SAXException e) {
			System.out.println("getsax");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("getio");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

}
