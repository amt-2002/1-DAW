package Tema4.Ej58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Diccionario dic = new Diccionario();
		
		Scanner sca = new Scanner(System.in);
		
		String palabraEscrita;
		String letraEscrita;
		
		List<String> lista = new ArrayList<>();
		
		do {
			System.out.println("Escribe una palabra (FIN para acabar)");
			palabraEscrita = sca.nextLine();
			
			lista.add(palabraEscrita);
			
		}
		while (!palabraEscrita.equals("FIN"));
		
		dic.cargarDiccionario(lista);
	
		do {
			System.out.print("Dime una letra: ");
			letraEscrita = sca.nextLine().toUpperCase();
			System.out.println("");
			
			if (!letraEscrita.equals("FIN")) {
				dic.imprimirPalabras(letraEscrita);
			}
			
		}
		while (!letraEscrita.equals("FIN"));
		
		System.out.println("¡Gracias por jugar con nosotros! Bye");
		
		sca.close();

	}

}
