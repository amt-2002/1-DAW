package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio3 {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*** MENÚ ***");
		System.out.println("   1. Abrir");
		System.out.println("   2. Guardar");
		System.out.println("   3. Modificar");
		System.out.println("   4. Salir");
		
		Boolean repetimosBucle = true; 
		
		Scanner sca = new Scanner(System.in); 
	
		do {
			
			System.out.println("Escribe una opcion");
			
			Integer opcion = sca.nextInt(); 
			
			if (opcion == 1) {
				System.out.println("Has elegido la opcion de Abrir");
				repetimosBucle = false;
			} else if (opcion == 2) {
				System.out.println("Has elegido la opcion de Guardar");
				repetimosBucle = false;
			} else if (opcion == 3) {
				System.out.println("Has elegido la opcion de Modificar");
				repetimosBucle = false;
			} else if (opcion == 4) {
				System.out.println("Bye Bye");
				repetimosBucle = false;
			} else {
				System.out.println("Esa opcion del menu no es correcta");
			}
			
		} while(repetimosBucle); 
		
		sca.close();

	}

}
