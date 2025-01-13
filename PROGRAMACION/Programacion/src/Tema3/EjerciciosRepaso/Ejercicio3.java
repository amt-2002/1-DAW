package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);
		
		Integer[] listaNotas = new Integer[] {7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10};
		
		
		System.out.println("¿Que nota buscas?");
		
		Integer nSolicitado = sca.nextInt();
		Boolean encontrado = false; 
		
		for (int i = 0; i < listaNotas.length; i++) {
			if (listaNotas[i] == nSolicitado) {
				System.out.println("La nota buscada existe y esta en la posicion " + i);
				encontrado = true;
			} 
		}
		
		if (!encontrado) {
			System.out.println("La nota buscada no existe");
		} 
		
		sca.close();
		
	}
 
}
