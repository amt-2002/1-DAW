package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		Integer tamañoA;
		do {
			System.out.println("Indica el tamaño de la serie");
			tamañoA = sca.nextInt(); 
		} while(tamañoA <= 2);
		
		
		Integer [] arrayList = new Integer[tamañoA]; 
		
		arrayList[0] = 0; 
		arrayList[1] = 1;
		
		
		for (int i = 2; i < arrayList.length; i++) {
			arrayList[i] = arrayList[i-1] + arrayList[i-2]; 
		}
		
		for (Integer numero:arrayList) {
			System.out.print(numero + " ");
		}
		
		
		
		sca.close();

	}

}
