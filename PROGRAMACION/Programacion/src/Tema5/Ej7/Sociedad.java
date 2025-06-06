package Tema5.Ej7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sociedad {
	
	Set<Persona> personas;

	public Sociedad() {
		super();
		this.personas = new HashSet<>();
		
	} 
	
	
	public void addPersona(String gen, BigDecimal altu) throws ParametroIncorrectoException {
		
		Persona pers = new Persona();
		
		try {
			pers.setAltura(altu);
			pers.setGenero(gen);
			this.personas.add(pers);
		} catch (ParametroIncorrectoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new ParametroIncorrectoException("Parametro Incorrecto");
		}
		

		
	}
	

	
	public BigDecimal calcularAlturaMedia(String gen) throws ListaVaciaException {
		
		
		if (personas.isEmpty()) {
			throw new ListaVaciaException("No hay personas en la lista");
		}
		
		BigDecimal suma = BigDecimal.ZERO;
		Boolean genEncontrado = false;
		Integer contador = 0;
		
		
		if (gen.equals("H")) {
			
			for (Persona persona : personas) {
				if (persona.getGenero().equals("H")) {
					suma = suma.add(persona.getAltura());
					genEncontrado = true;
					contador++;
				}
			}
			
			if (!genEncontrado) {
				throw new ListaVaciaException("No hay personas hombres en la lista");
			}
		} else if (gen.equals("M")) {
		
			for (Persona persona : personas) {
				if (persona.getGenero().equals("M")) {
					suma = suma.add(persona.getAltura());
					genEncontrado = true;
					contador++;
				}
			}
			
			if (!genEncontrado) {
				throw new ListaVaciaException("No hay personas mujeres en la lista");
			}
			
		} else {
			
			for (Persona persona : personas) {
				suma = suma.add(persona.getAltura());
				contador++;
			}
			
		}
		
		return suma.divide(new BigDecimal(contador), 2, RoundingMode.HALF_UP);
		
	}
	
	
	public void borrarGenero(String gen) throws ParametroIncorrectoException {
		if (!gen.equals("H") && !gen.equals("M")) {
			throw new ParametroIncorrectoException("El genero debe ser H o M");
		}
		
		for (Iterator<Persona> iterator = personas.iterator(); iterator.hasNext();) {
			Persona persona = (Persona) iterator.next();
			if (persona.getGenero().equals(gen)) {
				personas.remove(persona);
			}
		}
		
	}
	
	

}
