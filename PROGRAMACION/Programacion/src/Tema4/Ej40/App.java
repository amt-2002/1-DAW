package Tema4.Ej40;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilaCola<String> pilaCola = new PilaCola<String>();
		
		pilaCola.añadirObjeto("primero");
		pilaCola.añadirObjeto("segundo");
		
		System.out.println("Sacado de la pilaCola " + pilaCola.sacarObjeto() + " No array");

		pilaCola.añadirObjeto("tercero");
		
		System.out.println(pilaCola);
		
		
		while(pilaCola.getTamaño() > 0) {
			System.out.println("Sacado de la pilaCola " + pilaCola.sacarObjeto());
		}
		
	
		pilaCola.añadirObjeto("cuarto");
		
		System.out.println(pilaCola);
		
		
		/////////////////////////////////////
		
		
		PilaCola<Integer> pilaCola2 = new PilaCola<Integer>();
		
		pilaCola2.añadirObjeto(1);
		pilaCola2.añadirObjeto(2);
		
		System.out.println("Sacado de la pilaCola " + pilaCola2.sacarObjeto() + " No array");

		pilaCola2.añadirObjeto(3);
		
		System.out.println(pilaCola2);
		
		
		while(pilaCola2.getTamaño() > 0) {
			System.out.println("Sacado de la pilaCola " + pilaCola2.sacarObjeto());
		}
		
	
		pilaCola2.añadirObjeto(4);
		
		System.out.println(pilaCola2);
		
	}

}
