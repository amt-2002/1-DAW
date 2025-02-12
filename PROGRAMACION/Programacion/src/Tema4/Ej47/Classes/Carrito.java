package Tema4.Ej47.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private LocalDate fechaCreacion;
	private LocalDate fechaActualizacion;
	private Cliente cliente;
	private List<Articulo> articulos;
	
	public Carrito(Cliente clienteRecibido) {
		super();
		this.cliente = clienteRecibido; 
		this.fechaCreacion = LocalDate.now();
		this.fechaActualizacion = fechaCreacion;
		this.articulos = new ArrayList<>();
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

	public List<Articulo> getArticulos() {
		return this.articulos;
	}
	
	public Integer getCantidad() {
		return this.articulos.size();
	}
	
	public Double getTotal() {
		if (this.getArticulos().size() <= 0) return 0.0;
		Double precioTotal = 0.0;
		for (int i = 0; i < this.articulos.size(); i++) {
			precioTotal += this.articulos.get(i).getPrecio();
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
	
	public void borrarArticulo(int index) {
		this.articulos.remove(index); 
	}
	
	public void vaciarCesta() {
		this.articulos.clear();
	}
}
