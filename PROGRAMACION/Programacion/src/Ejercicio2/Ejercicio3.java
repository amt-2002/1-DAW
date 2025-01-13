package Ejercicio2;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in);
		
		Integer porcentajeIva = null;	
		
		System.out.println("¿Cual es el precio sin iva?");
		
		double precioSeco = sca.nextDouble();
		sca.nextLine();
		
		System.out.println("¿Cual es tipo de IVA?");
		

		String iva = sca.nextLine();
		
		System.out.println(iva);
		
  
		if (iva.equals("Normal")) {
			porcentajeIva = 21;
		}
        else if (iva.equals("Reducido")) {
        	porcentajeIva = 10;
		}
        else if (iva.equals("Superreducido")) {
        	porcentajeIva = 4;
        }
        else if (iva.equals("Exento")) {
        	porcentajeIva = 0;
        }
        else {
        	System.out.println("Tipo de IVA incorrecto (Escribe Normal, Reducido, Superreducido o Exento)");
        	return;
        }
	
		double precioIva = (precioSeco * porcentajeIva)/100 + precioSeco; 
		
		System.out.println("El porcentaje de IVA es del " + porcentajeIva + "% y se le suma un total al producto de " + (precioSeco * porcentajeIva)/100+ "$");
		
		System.out.println("El calculo del precio final es de " + precioIva + "$");
		
		sca.close(); 
		


	}

}
