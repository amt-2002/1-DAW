package Tema5.Ej7;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Aut
		
		Scanner sca = new Scanner(System.in);
		
		try {
			Sociedad soci = new Sociedad();
			String gen; 
			BigDecimal alt = BigDecimal.ZERO;
			String decision;
			while (true) {
				
				System.out.println("Indica del gen de la persona");
				gen = sca.nextLine();
				
				System.out.println("Indica altura de la persona");
				alt = sca.nextBigDecimal();
				
				try {
					soci.addPersona(gen, alt);
				} catch (ParametroIncorrectoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				System.out.println("Quieres añadir otra? Indica S o N segun tu preferencia");
				sca.nextLine(); //Limpiamos buffer
				decision = sca.nextLine();
				
				if (decision.equalsIgnoreCase("N") || !decision.equalsIgnoreCase("S")) {
					break;
				}
				
			}
			
			System.out.println("¿De que genero quieres sacar la media? Vacio si es de todos los gens");
			
			gen = sca.nextLine();
			
			try {
				System.out.println(soci.calcularAlturaMedia(gen));
			} catch (ListaVaciaException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("¿Que genero quieres borrar?");
			
			gen = sca.nextLine();
			
			try {
				soci.borrarGenero(gen);
			} catch (ParametroIncorrectoException e) {
				System.out.println(e.getMessage());
			}
			
		} finally {
			sca.close();
		}
		
		

	}

}
