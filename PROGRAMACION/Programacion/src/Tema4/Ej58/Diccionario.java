package Tema4.Ej58;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {

	private Map<String, List<String>> palabras;
	
	public Diccionario() {
		super();
		this.palabras = new HashMap<>();
	}
	
	public void cargarDiccionario(List<String> listaR) {
		String letraInicial;
		
		for (String palabra : listaR) {
			letraInicial = palabra.substring(0, 1).toUpperCase();
			if (this.palabras.containsKey(letraInicial)) {
				this.palabras.get(letraInicial).add(palabra);
			} else {
				this.palabras.put(letraInicial, new ArrayList<>());
				this.palabras.get(letraInicial).add(letraInicial);
			}
		}
		
	}
	
	public void borrarDiccionario() {
		this.palabras.clear();
	}
	
	public void imprimirPalabras(String letra) {
	
		if (palabras.containsKey(letra)) {
			
			System.out.println("Hay " + this.palabras.get(letra).size() + " palabras que empiezan por " + letra);
			
			Collection<String> palabras2 = this.palabras.get(letra);
			
			for (String p : palabras2) {
				System.out.println("   > " + p);
			}
			
			
		} else {
			System.out.println("No hay palabras que empiezan por " + letra);
		}
	}



	
}
