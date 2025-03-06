package Tema4.Ej5.Clases;

import java.time.LocalDate;
import java.util.Objects;

public class Publicacion {

	private String codigo;
	private String autor;
	private String titulo;
	private LocalDate año_publi;

	public Publicacion(String codigo, String autor, String titulo, LocalDate año_publi) {
		super();
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.año_publi = año_publi;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(codigo, other.codigo);
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDate getAño_publi() {
		return año_publi;
	}


	public void setAño_publi(LocalDate año_publi) {
		this.año_publi = año_publi;
	}


	@Override
	public String toString() {
		return "Publicacion [codigo=" + codigo + ", autor=" + autor + ", titulo=" + titulo + ", año_publi=" + año_publi
				+ "]";
	}

}
