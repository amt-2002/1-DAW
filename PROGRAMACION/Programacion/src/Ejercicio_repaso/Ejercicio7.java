package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 

		Boolean repetimosBucle = false; 
		
		int sumaTotal = 0;
		int cantidadSuma = 0; 
		
		do {
			
			System.out.println("Indica un numero");
			
			int numeroSoli = sca.nextInt();
			cantidadSuma = numeroSoli; 
			
			if (numeroSoli >= 1 && numeroSoli <= 10) {
				repetimosBucle = false; 
				for (int i = 1; i<=9; i++) { 
					System.out.print(cantidadSuma + " + ");
					cantidadSuma = numeroSoli + cantidadSuma; 
					sumaTotal += cantidadSuma; 
					if (i == 9) {
						sumaTotal += numeroSoli; 
						System.out.println(cantidadSuma + " = " + sumaTotal);
					}
				}
			} else if (numeroSoli > 10 || numeroSoli < 0) {
				repetimosBucle = true;
			} else if (numeroSoli == 0) {
				System.out.println("Adios blancaflor");
			}
			
		} while(repetimosBucle);
		
		sca.close();

	}

}
