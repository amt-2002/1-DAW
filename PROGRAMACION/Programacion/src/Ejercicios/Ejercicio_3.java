package Ejercicios;

import java.util.Scanner;

public class Ejercicio_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("¿Cual es su altura?");
		
		Float altura = sca.nextFloat();
		

		System.out.println("¿Cual es su peso?");
		
		Float peso = sca.nextFloat();
		
		Float altura2 = altura * altura; 
		
		Float imc = (peso / altura2) * 10000; 
		
		String estado = "No encontrado"; 
		
		if (imc < 18.5) {
			estado = "Peso inferior al normal";
		}
		else if (imc >= 18.5 && imc <= 24.9) {
			estado = "Peso Normal";
		}
		else if (imc >= 25.0 && imc <= 29.9) {
			estado = "Peso superior al normal";
		}
		else  {
			estado = "Obesidad";
		}
		
		System.out.println("El IMC de la persona es de " + imc + " y tiene " + estado);
		
		sca.close(); 
		
	}

}