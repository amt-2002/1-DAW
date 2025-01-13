package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);

		System.out.println("Escribe un numero capicua");

		String nCapicua = sca.nextLine();

		String[] arrayCapicua = nCapicua.split("");

		Integer arrayLength = arrayCapicua.length;

		Boolean esCapicua = false;

		for (int i = 0; i < arrayLength; i++) {
			arrayLength -= 1;
			if (arrayCapicua[i].equals(arrayCapicua[arrayLength])) {
				esCapicua = true;
			} else {
				esCapicua = false;
				break;
			}
		}

		if (esCapicua) {
			System.out.println("El numero " + nCapicua + " es capicua");
		} else {
			System.out.println("El numero " + nCapicua + " no es capicua");
		}

		sca.close();

	}

}
