package examen.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Libreria {

	private String nombre; 
	private Map<String, Libro> libros;
	
	
	public Libreria() {
		super();
		this.libros = new HashMap<>(); 
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libreria other = (Libreria) obj;
		return Objects.equals(nombre, other.nombre);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Map<String, Libro> getLibros() {
		return libros;
	}


	public void setLibros(Map<String, Libro> libros) {
		this.libros = libros;
	} 
	
	
	public BigDecimal getTasacionCompleta() {
		
		BigDecimal suma = BigDecimal.ZERO;
		
		if (this.libros.isEmpty()) {
			return suma; 
		}
		
		for (Entry<String, Libro> entry : this.libros.entrySet()) {
			String key = entry.getKey();
			Libro val = entry.getValue();
			suma = suma.add(val.getPrecio()); 
		}
		
		return suma; 
	}
	
	
	public BigDecimal getPrecioMedio() {
		
		BigDecimal suma = BigDecimal.ZERO;
		BigDecimal tLibros = BigDecimal.ZERO; 
		
		if (this.libros.isEmpty()) {
			return suma; 
		}
		
		for (Entry<String, Libro> entry : this.libros.entrySet()) {
			String key = entry.getKey();
			Libro val = entry.getValue();
			suma = suma.add(val.getPrecio()); 
			tLibros = tLibros.add(BigDecimal.ONE);
		}
		
		return suma.divide(tLibros, 2, RoundingMode.HALF_DOWN); 
	}
	
	public List<Libro> getLibrosBaratos() {
		
		if (this.libros.isEmpty()) {
			return null; 
		}
		
		List<Libro> lLibros = new ArrayList<>();
		
		
		for (Entry<String, Libro> entry : this.libros.entrySet()) {
			String key = entry.getKey();
			Libro val = entry.getValue();
			
			if (val.getPrecio().compareTo(BigDecimal.TEN) < 0 ) {
				lLibros.add(val); 
			}
		}
		
		return lLibros; 
		
	}
	
	
}
