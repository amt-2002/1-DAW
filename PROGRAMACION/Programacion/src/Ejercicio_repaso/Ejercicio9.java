package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Boolean repetimosBucle = false; 
		
		do {
			
			System.out.println("Indicanos el texto");
			
			String texto = sca.nextLine(); 
			
			if (texto.startsWith("hola") && texto.endsWith("hastaluego")) {
				repetimosBucle = true;
				Integer primerEspacio = texto.indexOf(" "); 
				Integer ultimoEspacio = texto.lastIndexOf(" "); 
				String textoConvertido = texto.substring(primerEspacio, ultimoEspacio);
				
				System.out.println("Lo he entendido. Mensaje: " + textoConvertido);
			} 
			
			if (!texto.startsWith("hola") && !texto.endsWith("hastaluego")) {
				System.out.println("No lo entiendo, repite de nuevo el texto (Recuerda debe empezar por hola y acabar por hastaluego)");
				repetimosBucle = true;
			}
			
			if (texto.endsWith("adios")) {
				System.out.println("Adios que vaya bien");
				repetimosBucle = false; 
			}
			
		} while(repetimosBucle);
		
		sca.close();

	}

}
