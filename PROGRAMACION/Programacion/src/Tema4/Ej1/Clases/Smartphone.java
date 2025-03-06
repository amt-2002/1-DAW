package Tema4.Ej1.Clases;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Smartphone {

	private String marca;
	private String modelo;
	private String imei;
	private Double precio;
	private LocalDate fechaFabricacion;
	private Boolean activo;

	public Smartphone() {
		super();
		this.activo = true;
		this.precio = 0.0;
	}

	public Smartphone(String imei) {
		super();
		this.imei = imei;
		this.activo = true;
		this.precio = 0.0;
	}

	public Smartphone(String marca, String modelo, String imei) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.imei = imei;
		this.activo = true;
		this.precio = 0.0;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void activar() {
		this.activo = true;
	}

	public void desactivar() {
		this.activo = false;
	}

	public Integer getEdad() {
		LocalDate fechaAnterior = LocalDate.of(2000, Month.APRIL, 1);
		Period periodo = fechaAnterior.until(this.fechaFabricacion);
		Integer añosDiferencia = periodo.getYears();
		return añosDiferencia;
	}

	public void cambiarMarcaModelo(String nMarca, String nModelo) {
		this.modelo = nModelo;
		this.marca = nMarca;
	}
	
	public void establecerFabricacion(LocalDate nFecha) {
		this.fechaFabricacion = nFecha;
	}
	
	public Double getPrecioMasIva() {
		Double precioIva = this.precio + (this.precio * 0.21);
		return precioIva;
	}
	
	public Boolean isAltaGama(Double precioX) {
		if (this.precio > precioX) {
			return true;
		}
		return false;
	}
	
	
	public Boolean isDatosCompletos() {
		if (this.precio != null && !this.imei.isEmpty() && !this.imei.isBlank()) {
			return true;
		}
		return false;
	}
	
	public Boolean isGratis() {
		if (this.precio == 0.0) {
			return true;
		}
		return false; 
	}
	
	public void rebajar() {
		this.precio -= 10;
	}
	
	public String toString() {
		if (this.activo) {
			return this.marca + "(" + this.modelo + ")";
		}
		return this.marca + "(" + this.modelo + ") - INACTIVO";
	}

}
