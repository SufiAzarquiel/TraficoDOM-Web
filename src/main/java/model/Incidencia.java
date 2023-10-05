package model;

public class Incidencia {
	private String titulo;
	private String link;
	private String fecha;
	private String descripcion;

	public Incidencia(String titulo, String link, String fecha, String descripcion) {
		super();
		this.titulo = titulo;
		this.link = link;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public Incidencia() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Incidencia [titulo=" + titulo + ", link=" + link + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ "]";
	}
}
