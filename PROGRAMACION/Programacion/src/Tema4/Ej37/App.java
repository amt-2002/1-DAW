package Tema4.Ej37;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ColaCadenas cola = new ColaCadenas();
		
		cola.añadirCadena("primero");
		cola.añadirCadena("segundo");
		
		System.out.println("Sacado de la cola " + cola.sacarCadena() + " No array");

		cola.añadirCadena("tercero");
		
		System.out.println(cola);
		
		
		while(cola.getTamaño() > 0) {
			System.out.println("Sacado de la cola " + cola.sacarCadena());
		}
		
	
		cola.añadirCadena("cuarto");
		
		System.out.println(cola);
		
	}

}
