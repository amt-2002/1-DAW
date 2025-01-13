package Tema3.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica la pagina web");
		
		String pagWeb = sca.nextLine(); 
		
		String[] pagWebMontada = pagWeb.split("");
		Integer primeraBarra = pagWeb.indexOf("/"); 
		Integer ultimaBarra = pagWeb.lastIndexOf("/"); 
		Boolean espacioHecho = false; 
		
		//https://www.google.com/
		for (int i = 0; i < pagWebMontada.length; i++) {
			if (pagWebMontada[i].contains(":")) {
				System.out.print(pagWebMontada[i] + "//");
			} else if (i == ultimaBarra || i == primeraBarra) {
				if (!espacioHecho) {
					System.out.println();
					espacioHecho = true; 
				}
			} else if (pagWebMontada[i].contains(".")) {
					System.out.println();
			} else {
				System.out.print(pagWebMontada[i]);
			}
			
		}
		
		sca.close();

	}

}
