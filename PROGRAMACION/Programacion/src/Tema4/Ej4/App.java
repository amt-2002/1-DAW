package Tema4.Ej4;

import java.time.LocalDate;
import java.time.Month;

import Tema4.Ej4.Clases.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libreria libreria = new Libreria("Avda. de los sueños perdidos, 89", "954696954");
		
		LocalDate diaHoy = LocalDate.now();
		
		LocalDate fechaAntigua = LocalDate.of(2021, Month.APRIL, 1);
		LocalDate fechaAntigua2 = LocalDate.of(2001, Month.APRIL, 1);
		
		LibroNormal libro1 = new LibroNormal("Pepe el mejor", "Angel", diaHoy, 100);
		
		LibroNormal libro2 = new LibroNormal("Juanito el mejor", "Juan", fechaAntigua, 150);
		
		LibroDigital libro3 = new LibroDigital("Pera el mejor", "Pera", fechaAntigua2, 250);
		LibroDigital libro4 = new LibroDigital("Jhonny el mejor", "Jhonny", diaHoy, 350);
		
		
		libreria.añadirLibro(libro1);
		libreria.añadirLibro(libro2);
		libreria.añadirLibro(libro3);
		libreria.añadirLibro(libro4);
		
		libro1.setPeso(70);
		libro2.setPeso(100);
		
		
		System.out.println("Libro mas antiguo " + libreria.obtenerLibroMasAntiguo());
		
		System.out.println("Peso total de libros " + libreria.obtenerPesoTotalDeLibros());
		
		System.out.println("Numero de paginas medio " + libreria.obtenerNumPaginasMedio());
		

	}

}
