package Ejercicio2;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre");
		
		String nombre = sca.nextLine(); 
		
		for (int i = 1; i<=5; i++) {
			System.out.println("Tu nombre es " + nombre + " Linea " + i);
		}
		
		sca.close();

	}

}
