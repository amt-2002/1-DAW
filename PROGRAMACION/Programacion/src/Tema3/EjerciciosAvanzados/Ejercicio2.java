package Tema3.EjerciciosAvanzados;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static void mostrarTablero(String [][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int x = 0; x < array.length; x++) {
				System.out.print(array[i][x]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		String [][] array = new String[3][3];
		
		Boolean jugadorUnoOcupado = false; 
		Boolean jugadorDosOcupado = false; 
		Boolean juegoActivo = true; 
		String circulo = "| O |";
		String equis = "| X |"; 
		Boolean ganador = false; 
		
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int x = 0; x < array.length; x++) {
				array[i][x] = "| * |";
				System.out.print(array[i][x]);
			}
		}
		
	
		while(juegoActivo) {
			
			System.out.println();
			System.out.println();
			
			if (!ganador) {		
				do {
					
					System.out.println("Jugador 1 - Indica la posicion de la columna");
					
					Integer posicionColumna = sca.nextInt();
					
					System.out.println("Jugador 1 - Indica la posicion de la fila");
					
					Integer posicionFila = sca.nextInt();
					
					
					if (array[posicionColumna][posicionFila].contains("| * |")) {
						array[posicionColumna][posicionFila] = circulo; 
						mostrarTablero(array); 
						jugadorUnoOcupado = false;
					} else {
						jugadorUnoOcupado = true;
						System.err.println("El sitio esta ocupado, pon otro numero");
					}
					
					
					for (int i = 0; i < 3; i++) {
					    if ((array[i][0].equals(circulo) && array[i][1].equals(circulo) && array[i][2].equals(circulo)) || 
					        (array[0][i].equals(circulo) && array[1][i].equals(circulo) && array[2][i].equals(circulo))) { 
					    	ganador = true; 
					    }
					}
					
					if (!ganador) {
					    if ((array[0][0].equals(circulo) && array[1][1].equals(circulo) && array[2][2].equals(circulo)) || 
					        (array[0][2].equals(circulo) && array[1][1].equals(circulo) && array[2][0].equals(circulo))) { 
					        ganador = true;
					    }
					}
					
					if (ganador) {
						System.out.println();
						System.out.println();
						System.out.println("El jugador 1 ha ganado");
				        juegoActivo = false;
						break; 
					}
					
				} while(jugadorUnoOcupado); 
			}
			
			System.out.println();
			System.out.println();
			
			if (!ganador) {			
				do {
					
					System.out.println("Jugador 2 - Indica la posicion de la columna");
					
					Integer posicionColumna = sca.nextInt();
					
					System.out.println("Jugador 2 - Indica la posicion de la fila");
					
					Integer posicionFila = sca.nextInt();
					
					
					if (array[posicionColumna][posicionFila].contains("| * |")) {
						array[posicionColumna][posicionFila] = equis; 
						mostrarTablero(array); 
						jugadorDosOcupado = false;
					} else {
						jugadorDosOcupado = true;
						System.err.println("El sitio esta ocupado, pon otro numero");
					}
					
					for (int i = 0; i < 3; i++) {
					    if ((array[i][0].equals(equis) && array[i][1].equals(equis) && array[i][2].equals(equis)) || 
					        (array[0][i].equals(equis) && array[1][i].equals(equis) && array[2][i].equals(equis))) { 
					    	ganador = true;
					    }
					}
					
					if (!ganador) {
					    if ((array[0][0].equals(equis) && array[1][1].equals(equis) && array[2][2].equals(equis)) || 
					        (array[0][2].equals(equis) && array[1][1].equals(equis) && array[2][0].equals(equis))) { 
					        ganador = true;
					    }
					}
					
					if (ganador) {
						System.out.println();
						System.out.println();
						System.out.println("El jugador 2 ha ganado");
				        juegoActivo = false;
						break;
					}				
				} while(jugadorDosOcupado); 
				
			}
				
		}
		
		sca.close();

	}

}
