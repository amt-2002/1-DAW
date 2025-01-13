package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		Integer nLados = 5; 
		
		for (int x = 0; x < nLados; x++) {
			for(int i = 0; i <= nLados; i++) {
				if (i == x) {
					System.out.print("* ");
				} else if (i == 5) {
					System.out.println();
				} else {
					System.out.print("- ");
				}
			}
		}
		
		sca.close();
		


	}

}
