package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Escribe tu codigo html");
		
		String textoCodigo = sca.nextLine(); 
		
		String [] arrayTexto = textoCodigo.split(""); 
		
		String textoFormado = ""; 
		
		Boolean pauseBucle = false;
		
		for (int i = 0; i < arrayTexto.length; i++) {
			if (arrayTexto[i].equals("<")) {
				pauseBucle = true;
			} else if (arrayTexto[i].equals(">")) {
				pauseBucle = false;
			} else if (!pauseBucle) {
				textoFormado += arrayTexto[i]; 
			}
			
		}
		
		System.out.println(textoFormado);
		
		sca.close();

	}

}
