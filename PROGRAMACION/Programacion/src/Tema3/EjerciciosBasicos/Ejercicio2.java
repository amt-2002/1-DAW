package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Boolean bucle = true;
		
		Integer[] arrayNumeros;

		System.out.println("Indica un numero cualquiera");
		
		Integer nSoli = sca.nextInt();
		
		arrayNumeros = new Integer[6]; 
		
		Integer nSoliCuadrado = nSoli * nSoli; 
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			arrayNumeros[i] = nSoliCuadrado;
			nSoli++; 
			nSoliCuadrado = nSoli * nSoli;
		}
		
		
		for (int x=0; x < arrayNumeros.length; x++) {
			System.out.println("El cuadrado del indice " + x + " es " + arrayNumeros[x]);
		}
		
		sca.close();

	}

}
