package Tema4.Ej25;

public class Curso {

	private String identificador;
	private String descripcion;

	
	public Curso(String i, String d) {
		this.identificador = i;
		this.descripcion = d;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
