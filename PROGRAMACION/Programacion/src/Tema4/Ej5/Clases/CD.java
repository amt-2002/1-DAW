package Tema4.Ej5.Clases;

import java.time.LocalDate;

public class CD extends Publicacion {
	
	private Boolean prestado; 
	
	
	public CD(String codigo, String autor, String titulo, LocalDate año_publi) {
		super(codigo, autor, titulo, año_publi);
		// TODO Auto-generated constructor stub
		this.prestado = false;
	}


	public Boolean getPrestado() {
		return prestado;
	}


	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
	}

	
	

}
