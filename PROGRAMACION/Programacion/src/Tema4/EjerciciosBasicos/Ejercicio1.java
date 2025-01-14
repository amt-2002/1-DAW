package Tema4.EjerciciosBasicos;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palabra = "Hola como estas";
		String mayus = getMayusculas(palabra);
		System.out.println(mayus);
		
	}	
	public static String getMayusculas (String palabra) {
		String mayuscula = palabra.toUpperCase();
		//System.out.println(mayuscula);
		return mayuscula;
		
	} 
	 
	
}
