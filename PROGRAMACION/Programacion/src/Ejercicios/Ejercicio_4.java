package Ejercicios;

import java.util.Scanner;

public class Ejercicio_4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
	
		System.out.println("Pon un numero cualquiera");
		
		String a = sca.nextLine();
		
		System.out.println("Pon un numero decimal cualquiera");
		
		Double b = sca.nextDouble();
		
		System.out.println("Pon un numero entero cualquiera");
		
		Float c = sca.nextFloat();
		
		Long x1 = Long.parseLong(a);
		
		String x2 = b.toString();
		
		Integer x3 = b.intValue();
		
		Long x4 = c.longValue();
		
		System.out.println("Variable x1 " + x1);
		System.out.println("Variable x2 " + x2);
		System.out.println("Variable x3 " + x3);
		System.out.println("Variable x4 " + x4);
		
		
		sca.close(); 
		
	}

}