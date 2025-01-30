package Tema4.Ej39;

import java.util.ArrayList;
import java.util.List;

public class PilaColaCadenas {

	private List<String> listPilaCola = new ArrayList<>();
	private String modoSeleccionado;

	public PilaColaCadenas() {
		this.modoSeleccionado = "cola";
	}

	public void añadirCadena(String cadena) {
		listPilaCola.add(cadena);
	}

	public String sacarCadena() {
		if (this.modoSeleccionado.equals("pila")) {
			String ultimaCadena = listPilaCola.get(listPilaCola.size() - 1);
			listPilaCola.remove(ultimaCadena);
			return ultimaCadena;
		} else if (this.modoSeleccionado.equals("cola")) {
			String ultimaCadena = listPilaCola.get(0);
			listPilaCola.remove(0);
			return ultimaCadena;
		}
		return "ERROR";
	}

	public Integer getTamaño() {
		return listPilaCola.size();
	}

	@Override
	public String toString() {
		return "PilaCadenas [listPila = " + listPilaCola + "]";
	}

	public void setModoPila() {
		this.modoSeleccionado = "pila";
	}

	public void setModoCola() {
		this.modoSeleccionado = "cola";
	}

}
