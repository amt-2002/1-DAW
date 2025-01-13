package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica un texto");
		
		String texto = sca.nextLine().toLowerCase(); 
		
		String [] textoArray = texto.split(" "); 
		
		for (int i = 0; i < textoArray.length; i++) {
			if (i == 0) {
				System.out.print(textoArray[i]);
			} else {
				textoArray[i] = textoArray[i].substring(0, 1).toUpperCase() + textoArray[i].substring(1); 
				System.out.print(textoArray[i]);
			}
		}
		
		sca.close();

	}

}
