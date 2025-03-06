package Tema4.Ej52.Classes;

import java.math.BigDecimal;

public class Articulo {

	private String descripcion;
	private BigDecimal precio;

	public Articulo() {
		super();
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


}
