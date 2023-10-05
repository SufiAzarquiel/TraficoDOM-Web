package vista;

import java.util.ArrayList;

import handler.WebHandler;
import model.Incidencia;

public class View {
	public static void main(String[] args) {
		WebHandler handler = new WebHandler("https://infocar.dgt.es/etraffic/rss_ca_13.xml");

		ArrayList<Incidencia> incidencias = handler.parsear();
		for (Incidencia incidencia : incidencias) {
			System.out.println(incidencia);
		}
	}
}
