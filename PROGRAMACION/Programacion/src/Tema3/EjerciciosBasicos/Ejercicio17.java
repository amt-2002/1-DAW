package Tema3.EjerciciosBasicos;

public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double [] numeros = new Double[]{5.4, 3.1, 9.0, 4.7}; 

		Double sumaNumeros = 0.0; 
		
		System.out.print("Los numeros son: ");
		for(double decimal : numeros) {
			System.out.print(decimal + " ");
			sumaNumeros += decimal; 
		}
		
		System.out.println("y su suma es " + sumaNumeros);
	}

}
