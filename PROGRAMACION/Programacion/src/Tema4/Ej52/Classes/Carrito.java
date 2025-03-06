package Tema4.Ej52.Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrito {

	private LocalDate fechaCreacion;
	private LocalDate fechaActualizacion;
	private Cliente cliente;
	private Set<Articulo> articulos;
	
	public Carrito(Cliente clienteRecibido) {
		super();
		this.cliente = clienteRecibido; 
		this.fechaCreacion = LocalDate.now();
		this.fechaActualizacion = fechaCreacion;
		this.articulos = new HashSet<>();
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public Set<Articulo> getArticulos() {
		return this.articulos;
	}
	
	public Integer getCantidad() {
		return this.articulos.size();
	}
	
	public BigDecimal getTotal() {
		if (this.getArticulos().size() <= 0) return BigDecimal.ZERO;
		BigDecimal precioTotal = BigDecimal.ZERO;
		for (Articulo articulo : articulos) {
			precioTotal = precioTotal.add(articulo.getPrecio());
		}
		return precioTotal;
		
	}
	
	public BigDecimal getPrecioMedio() {
		if (this.getArticulos().size() <= 0) return BigDecimal.ZERO;
		BigDecimal cantidadArt = new BigDecimal(this.articulos.size());
		return this.getTotal().divide(cantidadArt, 2, RoundingMode.HALF_UP);
	}

	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormada = this.fechaActualizacion.format(formato);
		return "Cliente: " + this.getCliente() + " | " + 
				" Cantidad de articulos: " + this.getCantidad() + " | " + 
				" Suma total a pagar: " + this.getTotal() + " | " + 
				" Fecha de ultima actualizacion: " + fechaFormada;
	}
	
	public void addArticulo(Articulo articulo) {
		this.articulos.add(articulo);
	}
	
	public void borrarArticulo(Articulo articulo) {
		this.articulos.remove(articulo); 
	}
	
	public void vaciarCesta() {
		this.articulos.clear();
	}
}
