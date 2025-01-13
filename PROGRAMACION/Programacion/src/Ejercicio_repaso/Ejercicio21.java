package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Integer nLados = 0; 
		
		do {
			
			System.out.println("Indica el numero de lados");
			
			nLados = sca.nextInt();
			
			if (nLados > 0) {
				for (int x = 0; x < nLados; x++) {
					for(int i = 0; i <= nLados; i++) {
						if (i == x) {
							System.out.print("* ");
						} else if (i == nLados) {
							System.out.println();
						} else {
							System.out.print("- ");
						}
					}
				}
			}

		} while(nLados >= 0); 
		
		sca.close();
		


	}

}
