package Tema4.Ej52;

import java.math.BigDecimal;

import Tema4.Ej52.Classes.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente("12345678X", "Blas de los Montes");
		
		Carrito carrito = new Carrito(cliente);
		
		System.out.println(carrito + "\n");
		
		Ropa ropa = new Ropa(); 
		
		BigDecimal precioRopa = new BigDecimal(20.0);
		
		ropa.setPrecio(precioRopa);
		ropa.setDescripcion("Poncho");
		ropa.setTalla("XL");
		ropa.setColor("Azul");
		
		carrito.addArticulo(ropa);
		carrito.addArticulo(ropa);

		
		System.out.println(carrito + "\n");
		
		Libro libro = new Libro();
		
		BigDecimal precioLibro = new BigDecimal(15.0);
		
		libro.setPrecio(precioLibro);
		libro.setAutor("Así habló Zaratustra");
		libro.setDescripcion("Nietzsche");
		
		carrito.addArticulo(libro);
		
		System.out.println(carrito + "\n");
		
		carrito.borrarArticulo(libro);
		
		System.out.println(carrito + "\n");
		
		System.out.println("Precio medio del carrito " + carrito.getPrecioMedio() + "\n");
		
		carrito.vaciarCesta();
		
		System.out.println(carrito + "\n");
		
		System.out.println("Precio medio del carrito " + carrito.getPrecioMedio() + "\n");
		
	}

}
