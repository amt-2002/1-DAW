package Ejercicios_repaso;

import java.util.Scanner;

public class Ejercicio_1 {
	
	public static final Double PI = 3.14159265359;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica el numero del radio del circulo");
		
		float radio = sca.nextFloat(); 
		
		double area = PI * (radio * radio);
		
		double circunferencia = 2 * radio * PI; 
		
		
		System.out.println("El area del circulo es de " + area  + " y la circunferencia es " + circunferencia);
		
		
		sca.close();

	}

}
