package Tema4.Ej4.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Libreria {
	
	private List<Libro> libros ;
	private String dir; 
	private String num_tel;
	
	
	public Libreria(String dir, String num_tel) {
		super();
		this.dir = dir;
		this.num_tel = num_tel;
		this.libros = new ArrayList<>();
	}

	
	public void añadirLibro(Libro libro) {
		this.libros.add(libro);
	}

	public Libro obtenerLibroMasAntiguo() {
		
		if (!this.libros.isEmpty()) {
			
			LocalDate fechaAntigua = libros.get(libros.size()-1).getFecha(); 
			Libro libroAntiguo = libros.get(libros.size()-1); 

			for (int i = 0; i < libros.size(); i++ ) {
				if (fechaAntigua.isAfter(libros.get(i).getFecha())) {
					fechaAntigua = libros.get(i).getFecha();
					libroAntiguo = libros.get(i);
				}	
			}
			return libroAntiguo; 
		}
		
		return null;

	}
	
	public Integer obtenerPesoTotalDeLibros() {
		Integer peso = 0;
	
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			peso += libro.getPeso();
		}
		return peso;
	}
	
	public Integer obtenerNumPaginasMedio() {
		Integer num_paginas = 0;
		if (this.libros.isEmpty()) return 0; 
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			num_paginas += libro.getNum_pag();
		}
		
		num_paginas = num_paginas / libros.size();
		
		return num_paginas;
	}
	
	
	
	

	

}
