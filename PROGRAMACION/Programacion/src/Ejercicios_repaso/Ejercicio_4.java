package Ejercicios_repaso;

import java.util.Scanner;

public class Ejercicio_4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica tu numero favorito");
		
		int numeroFavorito = sca.nextInt();
		
		sca.nextLine(); 
		
		System.out.println("Indica tu ciudad favorita");
		
		String ciudadFavorita = sca.nextLine();  
 		
		System.out.println("Tu numero favorito es " + numeroFavorito + " y tu ciudad es " + ciudadFavorita);
		
		sca.close();
		

	}

}