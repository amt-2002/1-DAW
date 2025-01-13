package Ejercicios_repaso;

import java.util.Scanner;

public class Ejercicio_3 {
	
	public static final Double PI = 3.14159265359;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica el primer numero entero");
		
		String numero1 = sca.nextLine();
		
		System.out.println("Indica el segundo numero entero");
		
		String numero2 = sca.nextLine();
		
		Long numero1Converted = Long.parseLong(numero1);
		Long numero2Converted = Long.parseLong(numero2);
	
		System.out.println("La multipicacion de ellos es " + (numero1Converted * numero2Converted));
		
		sca.close();

	}

}

// Con Integer se pondria negativo por lo cual hay que usar la variable Long para grandes cantidades 
