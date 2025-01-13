package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
	
		System.out.println("Indica una palabra");
		
		String palabra = sca.nextLine();  
		
		for (int i = palabra.length(); i > 0; i--) {
			String letraInvertida = palabra.substring(i-1, i);
			System.out.print(letraInvertida);
		}
		
		sca.close();

	}

}
