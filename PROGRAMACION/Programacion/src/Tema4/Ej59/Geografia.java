package Tema4.Ej59;

import java.util.HashMap;
import java.util.Map;

public class Geografia {

	private Map<String, String> paises;

	public Geografia() {
		super();
		this.paises = new HashMap<>();
	}

	public Boolean agregarPais(String pais, String capital) {
		String capitalMayus = capital.substring(0, 1).toUpperCase() + capital.substring(1);
		String paisMayus = pais.toUpperCase();

		if (this.paises.containsKey(paisMayus)) {
			return true;
		}
		this.paises.put(paisMayus, capitalMayus);
		return false;
	}

	public String obtenerCapital(String pais) {
		String paisMayus = pais.substring(0, 1).toUpperCase() + pais.substring(1);
		if (this.paises.containsKey(paisMayus)) {
			return this.paises.getOrDefault(paisMayus, "");
		}
		return "";
	}

	public void imprimirPaises() {
		for (Map.Entry<String, String> entry : this.paises.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();

			System.out.println("PAIS: " + key + " - " + "CAPITAL: " + val);
		}
	}

	public void eliminarPais(String pais) {
		String paisMayus = pais.substring(0, 1).toUpperCase() + pais.substring(1);
		if (this.paises.containsKey(paisMayus)) {
			this.paises.remove(paisMayus);
		}
	}

	public Integer calcularLongitudMediaPaises() {
		Integer sumaNumeros = 0;
		if (!this.paises.isEmpty()) {
			for (Map.Entry<String, String> entry : this.paises.entrySet()) {
				String key = entry.getKey();
				sumaNumeros += key.length();
			}

			sumaNumeros = sumaNumeros / this.paises.size();

			return sumaNumeros;
		}

		return 0;
	}

	public void eliminarPaisConCapitalLetra(String letra) {

		if (!this.paises.isEmpty()) {
			for (Map.Entry<String, String> entry : this.paises.entrySet()) {
				String key = entry.getKey();
				if (key.startsWith(letra)) {
					this.paises.remove(key);
					break;
				}
			}
		}
	}

	public Integer numeroPaisesConCapitalLetra(String letra) {
		
		
		if (letra != null && !letra.isEmpty()) {		
			Integer contadorPais = 0;
			
			if (!this.paises.isEmpty()) {
				for (Map.Entry<String, String> entry : this.paises.entrySet()) {
					String key = entry.getKey();
					if (key.startsWith(letra)) {
						contadorPais++;
					}
				}
				return contadorPais;
			}
		}

		return 0;
	}

	public void imprimirNumeroPaisesLetra(String letra) {

		if (letra != null && !letra.isEmpty()) {	
			if (!this.paises.isEmpty()) {
				for (Map.Entry<String, String> entry : this.paises.entrySet()) {
					String key = entry.getKey();
					String val = entry.getValue();
	
					if (val.startsWith(letra)) {
						System.out.println(this.paises.get(key));
						return;
					}
				}
			}
		}

		System.out.println("Ninguna capital del mapa comienza por " + letra);
	}

	public void mismaLetra() {

		if (!this.paises.isEmpty()) {
			for (Map.Entry<String, String> entry : this.paises.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();

				String firstKey = key.substring(0, 1);
				String firstVal = val.substring(0, 1);

				if (firstKey.startsWith(firstVal)) {
					System.out.println("PAIS: " + key + " - " + "CAPITAL: " + val);
				}
			}
		}

		System.out.println("No hay ningún país y capital que comiencen por la misma letra");
	}

}
