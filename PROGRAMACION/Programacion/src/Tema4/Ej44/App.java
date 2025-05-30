package Tema4.Ej44;


import Tema4.Ej44.Classes.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Jugador jugador1 = new Jugador();
		jugador1.setNombre("Angel");
		
		EquipoCombate equipo1 = new EquipoCombate();

		Asesino asesino1 = new Asesino("Pepe", "B13");
		Asesino asesino2 = new Asesino("Angel", "H45");
		Asesino asesino3 = new Asesino("Juan", "K78");
		
		equipo1.añadirPersonaje(asesino1);
		equipo1.añadirPersonaje(asesino2);
		equipo1.añadirPersonaje(asesino3);

		jugador1.setEquipo_combate(equipo1);
		System.out.println(equipo1 + "\n");
		
		Parasito parasito1 = new Parasito("Blas", "B69"); 
		System.out.println(parasito1.toString() + "\n");
		
		equipo1.añadirPersonaje(parasito1);
		
		// equipo1.añadirPersonaje(parasito1); -- No añade por duplicidad

		
		System.out.println(equipo1 + "\n");
		
		Parasito parasito2 = new Parasito("Kiko", "J69");
		Parasito parasito3 = new Parasito("Rafa", "L69");
		

		//equipo1.añadirPersonaje(parasito2);
		equipo1.añadirPersonaje(parasito3); 
		
		System.out.println(equipo1.getNum_vidas());
		
	}

}
