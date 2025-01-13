package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Indica una texto");
		
		String palabra = sca.nextLine().toLowerCase();
		
		String [] palabraArray = palabra.split(" "); 

		Integer cantidadA = 0; 
		
		
		for (int i = 0; i < palabraArray.length; i++) {
			String palabras = palabraArray[i];
			for (int k = 0; k < palabras.length(); k++) {
				String letras = palabras.substring(k, k+1);
				if (letras.contains("a")) {
					cantidadA++; 
				}
			}
		}
		
		System.out.println("El texto indicado tiene " + cantidadA + " (a) y " + palabraArray.length + " palabras" );
		
		sca.close();
		


	}

}
