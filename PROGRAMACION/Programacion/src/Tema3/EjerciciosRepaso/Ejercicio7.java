package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SIN NOVEDADES EN EL FRENTE STOP VUELVO MAÑANA TARDE NOCHE STOP TENED PREPARADO EL PUCHERO STOP 

		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Escribe tu telegrama");
		
		String telegrama = sca.nextLine(); 
		
		String [] arrayTelegrama = telegrama.split(" "); 
		
		Double oracionSinStop = 0.0;
		
		for (int i = 0; i < arrayTelegrama.length; i++) {
			if (!arrayTelegrama[i].contains("STOP")) {
				oracionSinStop++; 
			}
		}
		
		System.out.println("El precio es de " + oracionSinStop*0.24);
		
		sca.close();
		
	}

}
