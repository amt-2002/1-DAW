package Tema4.Ej59;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Geografia paises = new Geografia();
		
		paises.agregarPais("Egipto", "El Cairo");
		paises.agregarPais("Suiza", "Berna");
		paises.agregarPais("Austria", "Praga");
		paises.agregarPais("Hungría", "Budapest");
		paises.agregarPais("Austria", "Viena");
		paises.agregarPais("Brasil", "Brasilia");
		
		
		paises.imprimirPaises();

		System.out.println(paises.calcularLongitudMediaPaises());
		
		Scanner sca = new Scanner(System.in);
		
		
		System.out.println("Indica una letra");
		
		String letraSoli = sca.nextLine();
		
		paises.imprimirNumeroPaisesLetra(letraSoli);
		
		
		System.out.println(paises.numeroPaisesConCapitalLetra(letraSoli));
		
		
		paises.eliminarPaisConCapitalLetra(letraSoli);
		
		
		paises.imprimirPaises();
		
		sca.close();

	}

}
