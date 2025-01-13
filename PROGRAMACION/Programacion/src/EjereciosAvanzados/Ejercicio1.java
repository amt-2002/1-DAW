package EjereciosAvanzados;

import java.util.Scanner;

public class Ejercicio1 {
	
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escribe un texto:");
        String cadena = scanner.nextLine();

        cadena = cadena.toLowerCase();
        
        String resultado = "";
        boolean nuevaPalabra = false; 

        for (int i = 0; i < cadena.length(); i++) {
        	String actual = cadena.substring(i, i+1);
            if (actual.equals(" ")) {
                nuevaPalabra = true; 
            } 
            else {
                if (nuevaPalabra) {
                    if (resultado.length() > 0) {
                        resultado += actual.toUpperCase();
                    } else {
                        resultado += actual; 
                    }
                    nuevaPalabra = false; 
                } else {
                    resultado += actual; 
                }
            }
        }

        System.out.println("Resultado " + resultado);
        
        scanner.close();
    }
}
