
package Tema4.Ej43;

import java.util.ArrayList;
import java.util.List;

import Tema4.Ej43.Classes.Actor;
import Tema4.Ej43.Classes.Pelicula;
import Tema4.Ej43.Classes.Guionista;
import Tema4.Ej43.Classes.Director;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Actor actor1 = new Actor();
		Actor actor2 = new Actor();
		Actor actor3 = new Actor();
		Actor actor4 = new Actor();
		
		
		actor1.setNombre("Blas Blau");
		actor1.setNacionalidad("España");
		actor1.setAño_nacimiento(1983);
		
		actor2.setNombre("Laura Pozo");
		actor2.setNacionalidad("Italia");
		actor2.setAño_nacimiento(1981);
		
		actor3.setNombre("Marcel Cade");
		actor3.setNacionalidad("Suiza");
		actor3.setAño_nacimiento(2001);
		
		actor4.setNombre("Violeta Volo");
		actor4.setNacionalidad("Rusia");
		actor4.setAño_nacimiento(1999);
		
		
		Director director = new Director();
		
		director.setNombre("Sara Marea");
		director.setNacionalidad("Portugal");
		director.setAño_nacimiento(1994);
		
		Guionista guionista1 = new Guionista();
		Guionista guionista2 = new Guionista();
		
		guionista1.setNombre("Marco Smith");
		guionista1.setNacionalidad("Reino Unido");
		guionista1.setAño_nacimiento(1988);
		
		guionista2.setNombre("Cheng Shu");
		guionista2.setNacionalidad("China");
		guionista2.setAño_nacimiento(1977);
		
		
		Pelicula peli1 = new Pelicula();
		
		peli1.setAño_estreno(2027);
		
		peli1.setDirector(director);
		peli1.setGuionista(guionista1);
		
		List<Actor> actoresPeli1 = new ArrayList<>();
		
		actoresPeli1.add(actor1);
		actoresPeli1.add(actor2);
		
		peli1.setActores(actoresPeli1);
	
		peli1.setTitulo("Do you know Joe Blas?");
	
		
		Pelicula peli2 = new Pelicula();
		
		peli1.setDirector(director);
		peli1.setAño_estreno(2027);
		
		peli1.setGuionista(guionista2);
		
		List<Actor> actores = new ArrayList<>();
		
		actores.add(actor1);
		actores.add(actor2);
		actores.add(actor3);
		actores.add(actor4);
		
		peli2.setActores(actores);
		peli2.setTitulo("Muerte en la sombra");
		
		
		System.out.println(actoresPeli1 + "\n");
		
		System.out.println(guionista1 + "\n");
		
		actores.remove(actor3);
		
		actoresPeli1.add(actor3);
		
		System.out.println(actoresPeli1 + "\n");
		System.out.println(actores + "\n");
		
		
		
		
	}

}
