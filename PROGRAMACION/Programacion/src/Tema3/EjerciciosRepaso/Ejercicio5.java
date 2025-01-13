package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);
		
		Integer[] listaNotas = new Integer[] {7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10};
		
		
		for (int i = 0; i < listaNotas.length; i++) {
			if (listaNotas[i] < 5 ) {
				listaNotas[i] = 5;
			}
		}
		
		System.out.print("Listas notas: ");
		for(int numeros:listaNotas) {
			System.out.print(numeros + " ");
		}
		
		sca.close();
		
	}

}
