package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Indica cuantos numeros quieres almacenar");
		 
		Integer[] arrayNumeros = new Integer[sca.nextInt()]; 
		
		for(int i =0; i< arrayNumeros.length; i++) {
			System.out.println("Indica un numero aleatorio");
			Integer nSoli = sca.nextInt();
			
			arrayNumeros[i] = nSoli;  
		}
		
		for(int x = 0; x<arrayNumeros.length; x++) {
			System.out.println("Los numeros escritos son " + arrayNumeros[x]);
		}
		
		
		sca.close();

	}

}
