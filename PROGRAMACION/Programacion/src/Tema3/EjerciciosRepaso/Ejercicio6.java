package Tema3.EjerciciosRepaso;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] listaNotas = new Integer[] {7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10};
		
		
		for (int i = 0; i < listaNotas.length; i++) {
			if (i%2 == 0) {
				listaNotas[i] = listaNotas[i] * 2; 
			}
		}
		
		System.out.print("Listas notas: ");
		for(int numeros:listaNotas) {
			System.out.print(numeros + " ");
		}
		
		
	}

}
