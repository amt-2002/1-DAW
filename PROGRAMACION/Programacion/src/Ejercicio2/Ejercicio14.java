package Ejercicio2;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Escribe un numero para saber su tabla de multiplicacion");
		
		int numero = sca.nextInt();
		
		int contador = 0; 
		int contadorMultiplicar = 0;
		
		do {
			System.out.println(numero + " x " + contadorMultiplicar + " = " + contador);
			contadorMultiplicar = contadorMultiplicar + 1;
			contador = (contadorMultiplicar * numero); 

		} while(contadorMultiplicar <= 10); 
		
		sca.close();

	}

}
