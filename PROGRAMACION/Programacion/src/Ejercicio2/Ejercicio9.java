package Ejercicio2;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica tu nombre completo (Debe contener apellidos)");
		
		String nombreCompleto= sca.nextLine();

		Integer primerEspacio = nombreCompleto.indexOf(" "); 
		
		String primerNombre = nombreCompleto.substring(0, primerEspacio); 
		
		System.out.println("Nombre: " + primerNombre);
		
		Integer segundoEspacio = nombreCompleto.indexOf(" ", primerEspacio+1);  
		
		String primerApellido = nombreCompleto.substring(primerEspacio, segundoEspacio); 
		
		System.out.println("Primer apellido:" + primerApellido);
		
		Integer ultimoEspacio = nombreCompleto.length(); 
		
		String segundoApellido = nombreCompleto.substring(segundoEspacio, ultimoEspacio); 
		
		System.out.println("Segundo Apellido: " + segundoApellido);
		
		sca.close();

	}

}
