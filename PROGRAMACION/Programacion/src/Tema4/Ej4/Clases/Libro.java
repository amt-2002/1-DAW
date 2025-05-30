package Tema4.Ej4.Clases;

import java.time.LocalDate;

public abstract class Libro {

	private String titulo;
	private String autor;
	private LocalDate fecha;
	private int num_pag;

	public Libro(String titulo, String autor, LocalDate fecha, int num_pag) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.num_pag = num_pag;

	}

	public int getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}

	@Override
	public String toString() {
		return "Libro [titulo= " + titulo + ", autor= " + autor + ", fecha= " + fecha + ", num_pag= " + num_pag + "]";
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public abstract Integer getPeso();

}
