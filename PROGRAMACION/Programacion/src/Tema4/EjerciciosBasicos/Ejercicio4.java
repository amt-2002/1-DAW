package Tema4.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Escribe una palabra: ");
		String palabra = scanner.nextLine();
		System.out.println(Ejercicio1.getMayusculas(palabra));
		System.out.println(Ejercicio2.getMinusculas(palabra));
		scanner.close();

	}

}
