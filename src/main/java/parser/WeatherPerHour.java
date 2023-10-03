package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Incidencia;

public class WeatherPerHour {
	ArrayList<Incidencia> incidencias;

	public WeatherPerHour() {
		DOMParserWeb parser = new DOMParserWeb(
				"https://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp");
		Document doc = parser.getDocumento();

		incidencias = new ArrayList<Incidencia>();

		// root
		Element weatherData = (Element) doc.getElementsByTagName("forecast").item(0);

		// root/time
		NodeList incidenciasRaw = weatherData.getElementsByTagName("time");
		for (int i = 0; i < incidenciasRaw.getLength(); i++) {
			Element nodoIncidencia = (Element) incidenciasRaw.item(i);
			Incidencia incidencia = new Incidencia();

			// time/symbol
			Element simboloData = (Element) nodoIncidencia.getElementsByTagName("symbol").item(0);
			// time/symbol@var
			incidencia.setSimbolo(simboloData.getAttribute("var"));

			// time/precipitation
			Element precData = (Element) nodoIncidencia.getElementsByTagName("precipitation").item(0);
			// time/precipitation@probability
			Float probF = Float.parseFloat(simboloData.getAttribute("probability")) * 10;
			int probInt = Math.round(probF);
			incidencia.setPrecipitacion(probInt);

			// time/temperature
			Element temperData = (Element) nodoIncidencia.getElementsByTagName("temperature").item(0);
			// time/temperature@min
			incidencia.setTemperaturaMinima(Float.parseFloat(temperData.getAttribute("min")));
			// time/temperature@max
			incidencia.setTemperaturaMinima(Float.parseFloat(temperData.getAttribute("max")));

			// time/clouds
			Element cloudData = (Element) nodoIncidencia.getElementsByTagName("clouds").item(0);
			// time/clouds/@value

			incidencias.add(incidencia);
		}
	}

	public ArrayList<Incidencia> getIncidencias() {
		return incidencias;
	}
}
