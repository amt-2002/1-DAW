package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Escribe una palabra"); 
		
		String palabra = sca.nextLine(); 
		
		if (palabra.contains(" ")) {
			System.out.println("Solo se puede escribir una palabra");
			return; 
		}
		
		for (int i = 0; i < palabra.length(); i++) {
			String letraSeparada = palabra.substring(i, i+1); 
			System.out.println(letraSeparada);
		}
		
		sca.close();

	}

}
