package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);
		
		Integer[] listaNotas = new Integer[] {7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10};
		
		
		System.out.println("¿Que nota buscas?");
		
		Integer nSolicitado = sca.nextInt();
		Integer notasMayores = 0;  
		
		for (int i = 0; i < listaNotas.length; i++) {
			if (nSolicitado < listaNotas[i] ) {
				notasMayores++;		
			} 
		}
		
		System.out.println("Hay " + notasMayores + " notas mayores a la indicada");
		
		sca.close();
		
	}

}
