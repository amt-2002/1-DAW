package Ejercicio2;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int numeros = 0; 
		int suma = 0; 
		
		while (numeros < 10000) {
			numeros = numeros + 1;
			suma = suma + numeros;
			System.out.println("Numero " + numeros);
		}
		
		System.out.println("La suma de todos los numeros " + suma);
	}

}
