package Tema3.EjerciciosAvanzados;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica la cantidad de veces que quieres tirar");
		
		Integer nVeces = sca.nextInt();
		
		
		Random random = new Random();

		int [] estadisticas = new int[13]; 
		Integer [] sumaDados = new Integer[nVeces];
		
		for(int i = 0 ; i < nVeces; i++) {
			Integer dado1 = random.nextInt(1, 7); 
			Integer dado2 = random.nextInt(1, 7); 
			sumaDados[i] = dado1+dado2; 
		}
	
		for(int i = 0; i < nVeces; i++) {
			for (int x = 2; x < 13; x++) {
				
				if (sumaDados[i] == x) {
					estadisticas[x] += 1; 
				}
			}
		}

		for (int i = 2; i <= 12; i++) {
			System.out.println("La suma de dados " + (i) + " se ha repetido " + estadisticas[i] + " veces");
		}
		
		sca.close();

	}


}
