package Tema4.Ej38;

import java.util.ArrayList;
import java.util.List;

public class PilaCadenas {

	private List<String> listPila = new ArrayList<>();

	public PilaCadenas() {

	}

	public void añadirCadena(String cadena) {
		listPila.add(cadena);
	}

	public String sacarCadena() {
		String ultimaCadena = listPila.get(listPila.size() - 1);
		listPila.remove(ultimaCadena);
		return ultimaCadena;
	}

	public Integer getTamaño() {
		return listPila.size();
	}

	@Override
	public String toString() {
		return "PilaCadenas [listPila = " + listPila + "]";
	}

}
