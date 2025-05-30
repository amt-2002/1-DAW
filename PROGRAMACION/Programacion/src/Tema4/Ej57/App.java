package Tema4.Ej57;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
	
		Map<String, List<String>> palabras = new HashMap<>();
		String palabraEscrita;
		String letraEscrita = null;
		
		do {
			System.out.println("Escribe una palabra (FIN para acabar)");
			palabraEscrita = sca.nextLine();
			String initPalabra = palabraEscrita.substring(0, 1).toUpperCase();
			if (!palabraEscrita.equals("FIN")) {
				if (palabras.containsKey(initPalabra)) {
					palabras.get(initPalabra).add(palabraEscrita);
				} else {
					palabras.put(initPalabra, new ArrayList<>());
					palabras.get(initPalabra).add(palabraEscrita);
				}
			}
			
		}
		while (!palabraEscrita.equals("FIN"));
		
		do {
			System.out.print("Dime una letra: ");
			letraEscrita = sca.nextLine().toUpperCase();
			System.out.println("");
			
			if (!letraEscrita.equals("FIN")) {
	
				if (palabras.containsKey(letraEscrita)) {
					
					System.out.println("Hay " + palabras.get(letraEscrita).size() + " palabras que empiezan por " + letraEscrita);
					
					System.out.println(palabras.get(letraEscrita));
					
					Collection<String> palabras2 = palabras.get(letraEscrita);
					
					for (String p : palabras2) {
						System.out.println("   > " + p);
					}
					
					
				} else {
					System.out.println("No hay palabras que empiezan por " + letraEscrita);
				}
			}
			
		}
		while (!letraEscrita.equals("FIN"));
		
		System.out.println("¡Gracias por jugar con nosotros! Bye");
		
		sca.close();

	}

}
