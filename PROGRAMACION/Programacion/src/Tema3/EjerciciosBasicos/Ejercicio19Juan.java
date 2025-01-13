package Tema3.EjerciciosBasicos;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio19Juan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random ramdom = new Random();
		
		String [] array = new String[] {"azulejo","tenedor", "saltamontes", "carretilla", "molinero", "sotisficado", "terremoto", "culinario", "teclado", "primavera"};
		
		// Punto 2. Empieza el juego
		
		Integer numeroAleatorio = ramdom.nextInt(0, 10);
		String palabra = array[numeroAleatorio];
		String primeraLetraPalabra = palabra.substring(0, 1);
		Boolean bucle = true;
		
		// Parte 3.
		
		String[] arrayUsuario = palabra.split(""); 
		
		for(int i = 0; i < arrayUsuario.length; i++) {
			if(i == 0) {
				arrayUsuario[i] = primeraLetraPalabra;
			}
			else {
				arrayUsuario[i] = "_";
			}
		}
		
		System.out.println("La palabra empieza por " + arrayUsuario[0] + " y tiene " + arrayUsuario.length + " letras");
		// Número de intentos
		int intentos = 0;
		// Booleano si adivina la palabra
		boolean quedanLetras = true;

		
		do {
			boolean fallaLetra = true;
			//aux
			String letraInt = "";
			for(String letra:arrayUsuario) {
				System.out.print(letra + " ");
			}
			
			System.out.println("\nTe quedan " + (10 - intentos) + " intentos.");
			System.out.println("Introduce una letra");
			char letraIntroducida = sc.next().charAt(0);
			System.out.println(); // Dejo una línea para que se vea mas clara la consola.
			
			// Comprobamos si la letra está dentro de la palabra
			for(int x = 0; x < palabra.length(); x++) {
				if (palabra.charAt(x) == letraIntroducida && arrayUsuario[x] == "_"){
					letraInt = String.valueOf(letraIntroducida);
					arrayUsuario[x] = letraInt;
					fallaLetra = false;
				}
			}
			
			if(fallaLetra) {
				if (intentos >= 10) {
					bucle = false; 
				}
				intentos++;
				System.out.println("La letra " + letraIntroducida +" no está en la palabra");
			}
			
			// comprobamos si la palabra está completa.
			//Hacemos un array auxiliar a partir de palabra para ver si son iguales los dos arrays
			
			String palabra1 = ""; 
			String palabra2 = ""; 
			String[] aux = palabra.split("");
			for(int i = 0; i < arrayUsuario.length; i++) {
				palabra1 += aux[i]; 
			    palabra2 += arrayUsuario[i];
			    if (i == arrayUsuario.length-1) {
					if(palabra1.equalsIgnoreCase(palabra2)) {  //-------   arrayUsuario[i].equals(String.valueOf(palabra.charAt(0))) ---------- arrayUsuario.equals(aux)
						bucle = false;
					}	
			    }

			}
			/*for(String pal1:aux) {
				for(String pal2:arrayUsuario) {
					if(pal1 == pal2) {
						quedanLetras = false;
					}
				}
			}*/
					
			
			
		}while(bucle);
		
		///////////////////////////////////////////////////////////////////////////////////
		
		if(!bucle && intentos >= 10) {
			System.out.println("FIN DEL JUEGO. Has superado el límite de intentos.");
		}
		else if(!bucle) {
			System.out.println("ACERTASTE!!! La palabra es " + palabra);
		}

		sc.close();
	}

}












