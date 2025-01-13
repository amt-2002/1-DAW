package Ejercicios;

import java.util.Scanner;

public class Ejercicio_1 {
	
	public static final Integer MESES_AÑO = 12; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("¿Cuanto te gustaria ganar al año?");
		
		Integer dinero = sca.nextInt();
		
		
		Integer sueldo = dinero / MESES_AÑO;
		
		System.out.println("Tu sueldo mensual es de " + sueldo + " euros");

		sca.close();
		 
	}

}
