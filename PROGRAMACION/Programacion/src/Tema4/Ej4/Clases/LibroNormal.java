package Tema4.Ej4.Clases;

import java.time.LocalDate;

public class LibroNormal extends Libro {

	private int ancho;
	private int alto;
	private int peso;
	
	public LibroNormal(String titulo, String autor, LocalDate fecha, int num_pag) {
		super(titulo, autor, fecha, num_pag);
		// TODO Auto-generated constructor stub
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public Integer getPeso() {
		// TODO Auto-generated method stub
		return this.peso;
	}

}
