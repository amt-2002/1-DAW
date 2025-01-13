package Ejercicio2;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica un numero para multiplicar");
		
		int numero = sca.nextInt(); 
		int multiplicar = 0; 
		
		for (int i = 0; i <= 10; i++) {
			multiplicar = i * numero; 
			System.out.println("El calculo es " + i + " x " + numero + " = " + multiplicar);
		} 
		
		sca.close();

	}

}
