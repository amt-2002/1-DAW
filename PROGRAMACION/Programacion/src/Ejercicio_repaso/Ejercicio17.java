package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Boolean repetimosBucle = false; 
		
		do {
			
			System.out.println("Indica un numero");
			
			Integer numeroSoli = sca.nextInt(); 
			
			Integer primerNumero = 0;
			Integer segundoNumero = 1; 
			Integer suma = 0;
			
			if (numeroSoli <= 2) {
				repetimosBucle = true; 
				System.out.println("El numero tiene que ser mayor a 2");
			} else {
				
				for(int i = 2; i<= numeroSoli; i++) {
				   System.out.print(suma + " ");
				   
				   suma = primerNumero + segundoNumero; 
				   primerNumero = segundoNumero;
				   segundoNumero = suma;
				   
				}
				
			}
			
		} while(repetimosBucle); 
		
		sca.close();

	}

}
