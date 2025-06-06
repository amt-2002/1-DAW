package Tema4.Ej40;

import java.util.ArrayList;
import java.util.List;

public class PilaCola<E> {
	private List<E> datos;
	private String modoSeleccionado;
	
	
	public PilaCola() {
		this.modoSeleccionado = "cola";
		datos = new ArrayList<>();
	}
	
	public void añadirObjeto(E obj) {
		datos.add(obj);
	}

	public E sacarObjeto() {
		E ultimoSelec = null;
		
		if (this.modoSeleccionado.equals("pila")) {
			ultimoSelec = datos.get(datos.size() - 1);
			datos.remove(ultimoSelec);
		} else if (this.modoSeleccionado.equals("cola")) {
			ultimoSelec = datos.get(0);
			datos.remove(0);

		}

		return ultimoSelec;
	}

	public Integer getTamaño() {
		return datos.size();
	}

	@Override
	public String toString() {
		return "PilaCola [listPilaCola = " + datos + "]";
	}

	public void setModoPila() {
		this.modoSeleccionado = "pila";
	}

	public void setModoCola() {
		this.modoSeleccionado = "cola";
	}

	
}
