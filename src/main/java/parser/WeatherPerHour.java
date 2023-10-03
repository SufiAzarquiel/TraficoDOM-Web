package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Intervalo;

public class WeatherPerHour {
	ArrayList<Intervalo> intervalos;
	
	public WeatherPerHour() {
		DOMParserWeb parser = new DOMParserWeb("https://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp");
		Document doc = parser.getDocumento();
		
		intervalos = new ArrayList<Intervalo>();
		
		// root
		Element weatherData = (Element) doc.getElementsByTagName("forecast").item(0);
		
		// root/time
		NodeList intervalosRaw = weatherData.getElementsByTagName("time");
		for (int i = 0; i < intervalosRaw.getLength(); i++) {
			Element nodoIntervalo = (Element) intervalosRaw.item(i);
		    Intervalo intervalo = new Intervalo();
			
			// time/symbol	
		    Element simboloData = (Element) nodoIntervalo.getElementsByTagName("symbol").item(0);
		    // time/symbol@var
			intervalo.setSimbolo(simboloData.getAttribute("var"));

			// time/precipitation
			Element precData = (Element) nodoIntervalo.getElementsByTagName("precipitation").item(0);
			// time/precipitation@probability
			Float probF = Float.parseFloat(simboloData.getAttribute("probability")) * 10;
			int probInt = Math.round(probF);
			intervalo.setPrecipitacion(probInt);
			
			// time/temperature
			Element temperData = (Element) nodoIntervalo.getElementsByTagName("temperature").item(0);
			// time/temperature@min
			intervalo.setTemperaturaMinima(Float.parseFloat(temperData.getAttribute("min")));
			// time/temperature@max
			intervalo.setTemperaturaMinima(Float.parseFloat(temperData.getAttribute("max")));
			
			// time/clouds
			Element cloudData = (Element) nodoIntervalo.getElementsByTagName("clouds").item(0);
			// time/clouds/@value
			
			
			intervalos.add(intervalo);
		}
	}

	public ArrayList<Intervalo> getIntervalos() {
		return intervalos;
	}
}
