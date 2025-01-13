package Ejercicios_repaso;

import java.util.Scanner;

public class Ejercicio_2 {
	
	public static final Double PI = 3.14159265359;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica el primer numero entero");
		
		long numero1 = sca.nextInt();
		
		System.out.println("Indica el segundo numero entero");
		
		long numero2 = sca.nextInt();
		
		System.out.println("La multipicacion de ellos es " + (numero1 * numero2));
		
		sca.close();

	}

}

// Con Integer se pondria negativo por lo cual hay que usar la variable Long para grandes cantidades 
