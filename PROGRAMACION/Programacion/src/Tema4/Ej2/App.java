package Tema4.Ej2;

import Tema4.Ej2.Clases.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalizacionGPS locGPS = new LocalizacionGPS(100, 500);
		
		Movil movil = new Movil(654654654, locGPS);
		Fijo fijo = new Fijo(954954954, "Av ramon y cajal 2");
		
		System.out.println(movil.consultarNumero());
		System.out.println(fijo.consultarNumero());
		
		movil.marcar(654654654);
		movil.marcar(610610610);
		movil.colgar();
		movil.colgar();


	}

}
