package Tema4.Ej56;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeroEntero;
		Scanner sca = new Scanner(System.in);
		int sumaTotal = 0; 

		Map<Integer, Integer> sumaNumeros = new HashMap<>();

		do {

			System.out.println("Introduce un numero entero");

			numeroEntero = sca.nextInt();

			if (numeroEntero > 0) {
				if (sumaNumeros.containsKey(numeroEntero)) {
					sumaNumeros.put(numeroEntero, sumaNumeros.get(numeroEntero) + 1);
				} else {
					sumaNumeros.put(numeroEntero, 1);
				}
				
				sumaTotal = sumaTotal + 1;
			}
			

		} while (numeroEntero > 0);

		System.out.println("Total numeros indicados: " + sumaTotal);

		System.out.println("Distrubucion: ");

		for (Map.Entry<Integer, Integer> entry : sumaNumeros.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();

			System.out.println("     > Numero " + key + ": " + val + " veces");
		}

		sca.close();

	}

}
