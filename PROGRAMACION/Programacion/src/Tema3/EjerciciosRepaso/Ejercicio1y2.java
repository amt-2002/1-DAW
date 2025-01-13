package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio1y2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] listaNotas = new Integer[] {7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10};
		Integer alumnosAprobados = 0;
		Integer sumaTotalNotas = 0;
		
		for (int i = 0; i < listaNotas.length; i++) { //Ejercicio 1
			if (listaNotas[i] > 5) {
				alumnosAprobados++;
			}
		}
		
		System.out.println("Han aprobado un total de " + alumnosAprobados + " alumnos");
		
		
		for (int i = 0; i < listaNotas.length; i++) { // Ejercicio 2 
			if (listaNotas[i] > 5) {
				sumaTotalNotas += listaNotas[i];
			}
		}
		
		System.out.println("La nota media de aprobados es de " + sumaTotalNotas/alumnosAprobados);
		
	} 

}
