package Tema4.Ej33;

import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaforo semaforo1 = new Semaforo();
		
		semaforo1.setColor("AZUL");
		
		System.out.println("Comprobacion color || " + semaforo1.getColor());
		
		semaforo1.setColor("VERDE");
		
		semaforo1.setParpadeando(true);
		
		semaforo1.setColor("AMBAR");
		
		semaforo1.setParpadeando(true);
		
		
		
		for (int i = 1; i <= 5; i++) {
			semaforo1.cambiarEstado();
			System.out.println("Cambio de estado || " + semaforo1);
		}
		
		
		Semaforo semaforo2 = new Semaforo(); 
		
		semaforo2.setColor(semaforo1.getColor());
		semaforo2.setParpadeando(semaforo1.getParpadeando());
		System.out.println("Semaforo copia || " + semaforo2);
	}

}
