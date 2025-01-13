package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		Boolean repetimosBucle = false; 
		
		do {
			
			System.out.println("Indica una contraseña");
			
			String contraseñaOriginal = sca.nextLine();
			
			Integer cantidadContra = contraseñaOriginal.length(); 
			
			if (cantidadContra < 8) {
				System.out.println("Debe tener al menos 8 caracteres");
				repetimosBucle = true; 
			} else {
				String contraseñaConvertida = contraseñaOriginal
						.replaceAll("a", "4")
						.replaceAll("e", "3")
						.replaceAll("i", "1")
						.replaceAll("o", "0")
						.replaceAll("t", "7");
				
				
				System.out.println("La contraseña generada es : " +contraseñaConvertida);
				repetimosBucle = false; 
			}
			
		} while (repetimosBucle);
		
		sca.close();

	}

}
