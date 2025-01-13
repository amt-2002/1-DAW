package Ejercicios;

import java.util.Scanner;

public class Ejercicio_2 {
	
	public static final Float IVA = 0.21f; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("¿Cuanto cuesta el producto?");
		
		Float dineroMarcado = sca.nextFloat(); 
	
		Float ivaDinero = dineroMarcado * IVA; 
		
		Float dineroTotal = ivaDinero + dineroMarcado; 
		
		System.out.println("El IVA del producto es " + ivaDinero + " y la cantidad total es " + dineroTotal);
		
		sca.close(); 
		
	}

}