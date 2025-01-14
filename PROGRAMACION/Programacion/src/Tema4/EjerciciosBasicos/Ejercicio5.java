package Tema4.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero");
		
		Integer num1 = sca.nextInt();
		
		System.out.println("Introduce el segundo numero");
		
		Integer num2 = sca.nextInt();
		
		
		Integer resultado = sumar(num1, num2);
		
		System.out.println("El resultado es " + resultado);
		
		
		sca.close();
		
		
	}
	
	public static Integer sumar(Integer num1, Integer num2) {
		
		Integer sumaRealizada = num1 + num2; 
		
		return sumaRealizada;
		
	}

}
