package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);

		System.out.println("Indica una palabra");

		String palabra = sca.nextLine();

		String[] arrayPalabra = palabra.split("");

		for (int i = arrayPalabra.length - 1; i >= 0; i--) {
			System.out.print(arrayPalabra[i]);
		}

		sca.close();

	}

}
