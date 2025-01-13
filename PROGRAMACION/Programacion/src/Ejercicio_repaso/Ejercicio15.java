package Ejercicio_repaso;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		Random numRandom = new Random(); 
		
		Boolean repetimosBucle = false; 
		
		Integer intentos = 10; 
		
		Integer numeroRandom = numRandom.nextInt(0, 9); 
		
		
		do {
		
			
			System.out.println("Indica un numero e intenta averiguar el acertijo");
			
			Integer numeroElegido = sca.nextInt();
			
			if (intentos <= 0) {
				repetimosBucle = false; 
				System.out.println("Te has quedado sin intentos");
			}
			
			if (numeroRandom == numeroElegido) {
				System.out.println("Bien, has ganado tu puntuacion es de " + intentos);
				repetimosBucle = false; 
			} else {
				System.out.println("Has fallado, intentalo de nuevo");
				repetimosBucle = true; 
			}
			
			intentos -= 1; 
			
		} while(repetimosBucle);
		
		
		sca.close();

	}

}
