package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Boolean repetimosBucle = true; 
		
		String textoFinal = ""; 
		
		do {
			
			System.out.println("Indica una frase");
			
			String textoEscrito = sca.nextLine(); 
			
			if (textoEscrito.equalsIgnoreCase("fin")) {
				repetimosBucle = false; 
				System.out.println("Texto final: " + textoFinal); 
				return; 
			} else {
				repetimosBucle = true; 
				textoFinal += textoEscrito + " "; 
			}
			
		} while(repetimosBucle); 
		
		sca.close();

	}

}
