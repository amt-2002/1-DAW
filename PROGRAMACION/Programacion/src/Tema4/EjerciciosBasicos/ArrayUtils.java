package Tema4.EjerciciosBasicos;

public class ArrayUtils {

	public static void imprimirArray(String[] array) {

		for (String infoArray : array) {
			System.out.println(infoArray);
		}

	}

	public static String obtenerPalabra(Integer numeroI, String[] array) {

		if (numeroI <= array.length - 1) {
			return array[numeroI];
		}

		return "";

	}

	public static Integer buscarPalabra(String[] array, String palabra) {

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(palabra)) {
				return i;
			}
		}

		return -1;
	}

}
