package Tema3.EjerciciosBasicos;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer nIndices = 0;
		Integer[] numerosPares =new Integer[15]; 
		
		for(int i = 1; i<=30; i++) {
			if (i % 2 == 0) {
				numerosPares[nIndices] = i; 
				nIndices++;
			}
		}
		
		for(int x = 0; x < nIndices; x++) {
			if (numerosPares[x] != null) {
				System.out.print(numerosPares[x] + " ");
			}

		}
		
		
		
		

	}

}
