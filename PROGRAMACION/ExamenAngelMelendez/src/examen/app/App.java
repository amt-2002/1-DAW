package examen.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import examen.modelo.Libreria;
import examen.modelo.Libro;
import examen.services.LibreriaService;
import examen.services.LibroException;

public class App {

	public static Libreria solicitarLibreria() {
		Libreria libreria = new Libreria(); 
		libreria.setNombre("Paginas desiertas");
		Map<String, Libro> libros = new HashMap<>();

		
		Scanner sca = new Scanner(System.in);
		while(true) {
			
			Libro libro = new Libro();
			
			System.out.println("Escribre la informacion del libro en este formato ;");
			
			String tRec = sca.nextLine();
			
			if (tRec.equals("FIN")) {
				sca.close();
				break;
			}
			
			String [] infoLibro = tRec.split(";"); 
			
			libro.setISBN(infoLibro[0]);
			libro.setTitulo(infoLibro[1]);
			libro.setAutor(infoLibro[ 2]);
			
			BigDecimal precio = new BigDecimal(infoLibro[3]); 
			
			libro.setPrecio(precio);
			
			libros.put(libro.getISBN(), libro); 
			

		}
		libreria.setLibros(libros);
		return libreria; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libreria libreria = solicitarLibreria(); 
		
		List<Libro> librosBaratos = libreria.getLibrosBaratos(); 
		
		LibreriaService srv = new LibreriaService();
		
		for (Libro libro : librosBaratos) {
			try {
				srv.insertarLibroNuevo(libro);
				
			} catch (LibroException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("TODO OK");

		System.out.println("Precio medio de los libros - " + libreria.getPrecioMedio() + " | " + " Tasacion completa - " + libreria.getTasacionCompleta());
		
	}

}
