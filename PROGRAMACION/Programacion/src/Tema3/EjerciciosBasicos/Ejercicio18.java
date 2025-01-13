package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica una palabra");
		
		String palabra = sca.nextLine(); 
		
		String[] letrasArray = palabra.split(""); 
		
		for(String letra:letrasArray) {
			System.out.print(letra + " ");
		}
		
		sca.close();

	}

}
