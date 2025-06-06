package Tema4.Ej47.Classes;

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
	
	public Double getTotal() {
		if (this.getArticulos().size() <= 0) return 0.0;
		Double precioTotal = 0.0;
		for (Articulo articulo : articulos) {
			precioTotal += articulo.getPrecio();
		}
		return precioTotal;
		
	}
	
	public Double getPrecioMedio() {
		if (this.getArticulos().size() <= 0) return 0.0;
		return this.getTotal() / this.articulos.size();
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
