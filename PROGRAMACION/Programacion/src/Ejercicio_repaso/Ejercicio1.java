package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio1 {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica tu nombre"); 
		
		String nombre = sca.nextLine();
		
		System.out.println("Indica tu fecha de nacimiento");
		
		Integer fecha = sca.nextInt(); 
		
		Integer resultado = 2030 - fecha; 
		
		System.out.println("Hola " + nombre + ", en el año 2030 tendras " + resultado);
		
		sca.close();

	}

}
