package Tema4.Ej34;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		List<String> lista = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Indica los nombres");
			lista.add(sca.nextLine()); 
		}
		
		System.out.println(lista.toString());
		
		for (int i = 0; i < lista.size(); i++) {
			String palabra = lista.get(i); 
			lista.set(i, palabra.toUpperCase());
		}	
		
		
		System.out.println(lista);
		
		if (lista.contains("")) {
			System.err.println("NO PUEDE HABER CADENAS VACIAS");
			return;
		}
		
		Iterator <String> iterador = lista.iterator();
		
		while(iterador.hasNext()) {
			String palabra = iterador.next();
			if (palabra.length() < 6) {
				iterador.remove();
			}
		}
		
		System.out.println(lista);
		
		sca.close();

	}

}
