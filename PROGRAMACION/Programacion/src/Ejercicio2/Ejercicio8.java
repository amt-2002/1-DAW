package Ejercicio2;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);
		
	    String nombre1;
	    String nombre2;
	    Boolean sonIguales;
		
		do {
			System.out.println("Escribe un nombre"); 
			
		    nombre1 = sca.nextLine(); 
			
			System.out.println("Escribe otro nombre"); 
			
			nombre2 = sca.nextLine(); 
			
			sonIguales = nombre1.equalsIgnoreCase(nombre2); 
			
			if (sonIguales == false) {
				System.out.println("ERROR: Los nombres deben ser iguales");
			}
		}
		while (sonIguales == false); 
		
		System.out.println("SUCCESS: Los nombres son iguales, saludos");
		
		sca.close();
		
	}

}
