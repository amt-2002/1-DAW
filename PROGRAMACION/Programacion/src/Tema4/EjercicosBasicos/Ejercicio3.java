package Tema4.EjercicosBasicos;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Escribe un número: ");
		Integer numero = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Escribe una palabra: ");
		String palabra = scanner.nextLine();
 
		if (numero == 2 || numero == 1) {
			// Resultado
			System.out.println(getMayMin(numero, palabra));
		} else {
			System.out.println("Pon un número entre 1 y 2");
		}
		scanner.close();
	}
 
	public static String getMayMin(Integer numero, String palabra) {
		if (numero == 1) {
			palabra = palabra.toUpperCase();
		} else if (numero == 2) {
			palabra = palabra.toLowerCase();
		}
		return palabra;
	}
	
	
}
