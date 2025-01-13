package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio4 {

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
		
		for(int x = arrayNumeros.length-1; x >= 0; x--) {
			System.out.println("Los numeros escritos a la inversa son " + arrayNumeros[x]);
		}
		
		
		sca.close();

	}

}
