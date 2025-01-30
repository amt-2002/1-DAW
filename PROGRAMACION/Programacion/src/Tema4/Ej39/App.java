package Tema4.Ej39;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilaColaCadenas pilaCola = new PilaColaCadenas();
		
		// MODO COLA
		
		System.out.println("MODO COLA");
		
		pilaCola.añadirCadena("primero");
		pilaCola.añadirCadena("segundo");
		
		System.out.println("Sacado de la cola " + pilaCola.sacarCadena() + " No array");

		pilaCola.añadirCadena("tercero");
		
		System.out.println(pilaCola);
		
		
		while(pilaCola.getTamaño() > 0) {
			System.out.println("Sacado de la cola " + pilaCola.sacarCadena());
		}
		
	
		pilaCola.añadirCadena("cuarto");
		
		System.out.println(pilaCola + "\n");
		
		
		// MODO PILA
		
		System.out.println("MODO LISTA");
		
		pilaCola.setModoPila();
		
		pilaCola.añadirCadena("primero");
		pilaCola.añadirCadena("segundo");
		
		System.out.println("Sacado de la cola " + pilaCola.sacarCadena() + " No array");

		pilaCola.añadirCadena("tercero");
		
		System.out.println(pilaCola);
		
		
		while(pilaCola.getTamaño() > 0) {
			System.out.println("Sacado de la cola " + pilaCola.sacarCadena());
		}
		
	
		pilaCola.añadirCadena("cuarto");
		
		System.out.println(pilaCola);
		
	}

}
