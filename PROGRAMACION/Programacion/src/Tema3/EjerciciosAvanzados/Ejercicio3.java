package Tema3.EjerciciosAvanzados;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [][] tablero = new String[10][10];
		
		
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int x = 0; x < tablero.length; x++) {
				if (i == 0) {
					tablero[i][x] = " __";
				} else {
					tablero[i][x] = "|  ";
					if (x == 9 && i > 0) {
						tablero[i][x] = "|  |";
					}
				}
				System.out.print(tablero[i][x]);
			}
		}
	}

}
