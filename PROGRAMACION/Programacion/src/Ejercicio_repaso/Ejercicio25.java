package Ejercicio_repaso;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Piedra, papel, tijera... un, dos, tres, ya!!");
		
		Random opcionRandom = new Random();
		
		Integer eleccion = opcionRandom.nextInt(1, 4); 
		
		//System.out.println(eleccion);
		
		System.out.println("Indica tu accion (Piedra, papel o tijera)");
		
		String accion = sca.nextLine().toLowerCase();
		
		if (accion.equals("piedra")) {
			if (eleccion == 1) {
				System.err.println("Empate");
			} else if (eleccion == 2) {
				System.err.println("Derrota");
			} else {
				System.err.println("Victoria");
			}
			
		} else if (accion.equals("papel")) {
			if (eleccion == 1) {
				System.err.println("Victoria");
			} else if (eleccion == 2) {
				System.err.println("Empate");
			} else {
				System.err.println("Derrota");
			}
			
		} else if (accion.equals("tijera")) {
			if (eleccion == 1) {
				System.err.println("Derrota");
			} else if (eleccion == 2) {
				System.err.println("Victoria");
			} else {
				System.err.println("Empate");
			}
			
		} else {
			System.out.println("No es una opcion correcta");
		}
		
		sca.close();

	}

}
