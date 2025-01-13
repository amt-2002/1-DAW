package EjereciosAvanzados;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		Integer nLados; 
		
		do {
			
			System.out.println("Indica un numero");
			
			nLados = sca.nextInt();
			
			for(int x = 1; x <= nLados; x++) {
				for(int i = 1; i<=nLados; i++) {
					if (i == x || i == nLados - x + 1) {
						System.out.print(" * ");
					} else {
						System.out.print(" - ");
					}
				}
				System.out.println();
			}
			
		}while(nLados <= 0);
		
		
		
		sca.close();

	}

}
