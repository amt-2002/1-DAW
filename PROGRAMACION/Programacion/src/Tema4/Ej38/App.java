package Tema4.Ej38;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilaCadenas pila = new PilaCadenas();
		
		pila.añadirCadena("primero");
		pila.añadirCadena("segundo");
		
		System.out.println("Sacado de la cola " + pila.sacarCadena() + " No array");

		pila.añadirCadena("tercero");
		
		System.out.println(pila);
		
		
		while(pila.getTamaño() > 0) {
			System.out.println("Sacado de la cola " + pila.sacarCadena());
		}
		
	
		pila.añadirCadena("cuarto");
		
		System.out.println(pila);
		
	}

}
