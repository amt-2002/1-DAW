package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sca = new Scanner(System.in); 
		
		System.out.println("Indica la cantidad de dinero de la compra");
		
		double cantidadCompra = sca.nextDouble();
		
		System.out.println("Indica las unidades compradas");
		
		double unidadCompra = sca.nextDouble(); 
		
		double cantidadDescuento = 0; 
		
		double descuento = 0; 
		
		if (unidadCompra >= 100) {
			descuento = 0.40; 
			cantidadDescuento = cantidadCompra * descuento; 
		} else if (unidadCompra > 25 && unidadCompra < 100) {
			descuento = 0.20; 
			cantidadDescuento = cantidadCompra * descuento;  
		} else if (unidadCompra > 10 && unidadCompra < 24) {
			descuento = 0.10; 
			cantidadDescuento = cantidadCompra * descuento;  
		}
		
		System.out.println("El subtotal a pagar es " + cantidadCompra + " el descuento aplicado es " + descuento + " y el total a pagar es " + cantidadDescuento);
		sca.close();

	}

}
