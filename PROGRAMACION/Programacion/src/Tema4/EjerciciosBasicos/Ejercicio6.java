package Tema4.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero");
		
		Integer num1 = sca.nextInt();
		
		System.out.println("Introduce el segundo numero");
		
		Integer num2 = sca.nextInt();
		
		Integer resultado = Calculadora.sumar(num1, num2);
		
		System.out.println("El resultado es " + resultado);
		

		sca.close();

	}
	
}

