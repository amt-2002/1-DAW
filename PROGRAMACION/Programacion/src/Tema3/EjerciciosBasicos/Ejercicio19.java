package Tema3.EjerciciosBasicos;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] listaPalabras = new String []{"azulejo", "tenedor", "saltamontes", "carretilla",
				"molinero", "sofisticado", "terremoto", "culinario", "teclado", "primavera"}; 
		
		Random random = new Random(); 
		
		Integer nAzar = random.nextInt(0, 10);
		
		String palabraEscogida = listaPalabras[nAzar]; 
		
		Integer cantidadPalabra = listaPalabras[nAzar].length(); 
		
		String primeraLetra = listaPalabras[nAzar].substring(0, 1); 
		
		String [] arrayPalabra = new String [cantidadPalabra]; 
		
		Integer intentos = 10; 
		
		Scanner sca = new Scanner(System.in); 

		System.out.println("Indica una letra"); 
		System.out.println();
		
		Boolean esPerdedor = false; 
		
		do {
			esPerdedor = false; 
			Boolean acierto = false; 
			
			for (int i = 0; i < arrayPalabra.length; i++) {
				if (i == 0) {
					arrayPalabra[i] = primeraLetra;
				} else {
					if (arrayPalabra[i] == null || arrayPalabra[i].equals("_")) {
						arrayPalabra[i] = "_"; 
					}
				}
				System.out.print(arrayPalabra[i] + " ");
				
				if (arrayPalabra[i].contains("_")) {
					esPerdedor = true; 
				}
			}
			
			if (esPerdedor) {
				String letraSoli = sca.nextLine(); 
				
				for (int i = 0; i < cantidadPalabra; i++) {
					String letras = palabraEscogida.substring(i, i+1); 
					
					if (letras.equalsIgnoreCase(letraSoli)) {
						arrayPalabra[i] = letraSoli; 
						acierto = true; 
					}
				}
				
				if (!acierto) {
					intentos--; 
					System.out.println("Intento fallido. Te quedan " + intentos + " intentos");
				}
			}
			
		} while (intentos > 0 && esPerdedor); 
		
		System.out.println();
		
		if (intentos <= 0) {
			System.out.println("GAMEE OVEER");
		} else if (!esPerdedor) {
			System.out.println("Bieen has ganado");
			
		}
	

		sca.close();
		
	}

}
