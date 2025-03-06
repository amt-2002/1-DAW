package Tema4.Ej5.Clases;

import java.time.LocalDate;

public class Libro extends Publicacion {

	private Boolean prestado;
	private Boolean consultado; 
	
	
	public Libro(String codigo, String autor, String titulo, LocalDate año_publi) {
		super(codigo, autor, titulo, año_publi);
		// TODO Auto-generated constructor stub
		this.prestado  = false;
		this.consultado = false; 
	}


	public Boolean getPrestado() {
		return prestado;
	}


	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
	}


	public Boolean getConsultado() {
		return consultado;
	}


	public void setConsultado(Boolean consultado) {
		this.consultado = consultado;
	}

	
	
}
