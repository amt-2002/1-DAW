package Tema5.Ej6;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona persona = new Persona();
		
		BigDecimal num = new BigDecimal(2);
		
		try {
			persona.setAltura(num);
		} catch (ParametroIncorrectoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Realizado el cambio de altura");
		}
		
		try {
			persona.setGenero("a");
		} catch (ParametroIncorrectoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Realizado el cambio de genero");
		}
		
		
	}

}
