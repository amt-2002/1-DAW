package Tema4.Ej4.Clases;

import java.time.LocalDate;

public class LibroDigital extends Libro {

	public LibroDigital(String titulo, String autor, LocalDate fecha, int num_pag) {
		super(titulo, autor, fecha, num_pag);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getPeso() {
		// TODO Auto-generated method stub
		return 0;
	}

}
