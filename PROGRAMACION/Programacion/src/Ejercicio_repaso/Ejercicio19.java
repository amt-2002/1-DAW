package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Boolean repetimosBucle = true; 
		
		do {
			
			System.out.println("1 - Pasar de Pesetas a Euros\r\n"
					+ "2 - Pasar de Euros a Pesetas\r\n"
					+ "3 - Salir");
			
			
			Integer opcion = sca.nextInt(); 
			
			if (opcion == 3) {
				System.out.println("Adioos");
				repetimosBucle = false; 
			}
			
			System.out.println("Indica la cantidad que quieres convertir");
			
			Double cantidad = sca.nextDouble();
			
			if (opcion == 1) {
				cantidad = cantidad / 166.386; 
				System.out.println("El resultado es " + cantidad + " de euros");
			} else if (opcion == 2) {
				cantidad = cantidad * 166.386;
				System.out.println("El resultado es " + cantidad + " de pesetas");
			}
			
		} while(repetimosBucle);
		

		
		sca.close();

	}

}
