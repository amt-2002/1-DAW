package Tema4.Ej5.Clases;

import java.time.LocalDate;

public class Revista extends Publicacion {
	
	private Boolean consultado; 

	public Revista(String codigo, String autor, String titulo, LocalDate año_publi) {
		super(codigo, autor, titulo, año_publi);
		// TODO Auto-generated constructor stub
		this.consultado = false; 
	}

	public Boolean getConsultado() {
		return consultado;
	}

	public void setConsultado(Boolean consultado) {
		this.consultado = consultado;
	}

}
