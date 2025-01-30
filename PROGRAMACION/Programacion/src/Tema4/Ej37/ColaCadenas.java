package Tema4.Ej37;

import java.util.ArrayList;
import java.util.List;

public class ColaCadenas {

	private List <String> listCola = new ArrayList <>();
	

	public ColaCadenas() {
		
	}

	public void añadirCadena(String cadena) {
		listCola.add(cadena);
	}
	
	public String sacarCadena() {
		String ultimaCadena = listCola.get(0);
		listCola.remove(0);
		return ultimaCadena;
	}
	
	public Integer getTamaño() {
		return listCola.size();
	}

	
	@Override
	public String toString() {
		return "ColaCadenas [listCola = " + listCola + "]";
	}
	
	
}
