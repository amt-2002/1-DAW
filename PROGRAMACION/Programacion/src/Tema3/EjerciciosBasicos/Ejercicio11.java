package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Indica tu nombre completo");
		
		String nombreCompleto = sca.nextLine(); 
		
		String [] nombreTrozos = nombreCompleto.split(" "); 
		
		for (String partes:nombreTrozos) {
			System.out.println(partes);
		}

		
		sca.close();

	}

}
