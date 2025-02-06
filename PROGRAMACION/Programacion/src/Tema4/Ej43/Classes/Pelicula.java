package Tema4.Ej43.Classes;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

	private Integer año_estreno;
	private String titulo;
	private List<Actor> actores = new ArrayList<>();
	private Guionista guionista;
	private Director director;

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public Guionista getGuionista() {
		return guionista;
	}

	public void setGuionista(Guionista guionista) {
		this.guionista = guionista;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Integer getAño_estreno() {
		return año_estreno;
	}

	public void setAño_estreno(Integer año_estreno) {
		this.año_estreno = año_estreno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Pelicula [año_estreno=" + año_estreno + ", titulo=" + titulo + ", actores=" + actores + ", guionista="
				+ guionista + ", director=" + director + "]";
	}
	
	

}