package Ejercicio2;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Escribe tu año de nacimiento");
		
		int añoNacimiento = sca.nextInt();
		
		String generacion = "No existe generacion";
		
		if (añoNacimiento >= 2010 && añoNacimiento <= 2020) {
			generacion = "Generácion Alta";
		} 			
        else if (añoNacimiento >= 1997 && añoNacimiento <= 2012) {
			generacion = "Generacion Z";
        }		
		else if (añoNacimiento >= 1981 && añoNacimiento <= 1996) {
			generacion = "Generacion Y";
		} 
		else if (añoNacimiento >= 1965 && añoNacimiento <= 1980) {
			generacion = "Generacion X";
		} 
		else if (añoNacimiento >= 1946 && añoNacimiento <= 1964) {
			generacion = "Baby Boomers";
		} 
		else if (añoNacimiento >= 1928 && añoNacimiento <= 1945) {
			generacion = "Generacion Silenciosa";
		} 
		else if (añoNacimiento >= 1883 && añoNacimiento <= 1900) {
			generacion = "Generacion perdida";
		} 
		
		System.out.println("Los nacidos en " + añoNacimiento + " seran " + generacion);
		
		
		sca.close(); 

	}

}
