package Tema4.Ej41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);
		List<Equipo> equipos = new ArrayList<>();
		List<Jugador> jugadoresEquipo1 = new ArrayList<>();
		List<Jugador> jugadoresEquipo2 = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			System.out.println("Cual es el nombre del equipo");
			String nEquipo = sca.nextLine();
			Equipo equipo = new Equipo(nEquipo);
			equipos.add(equipo);
			for (int x = 0; x < 3; x++) {
				System.out.println("Cual es el nombre del jugador");
				String nJugador = sca.nextLine();
				System.out.println("Cual es el dorsal del jugador");
				Integer dJugador = sca.nextInt();
				Jugador jugador = new Jugador(nJugador, dJugador);
				if (i == 0) {
					jugadoresEquipo1.add(jugador);
				} else {
					jugadoresEquipo2.add(jugador);
				}
				sca.nextLine();
			}
		}
		
		equipos.get(0).setCapitan(jugadoresEquipo1.get(0));
		equipos.get(1).setCapitan(jugadoresEquipo2.get(1));
		
		
		equipos.get(0).setJugadores(jugadoresEquipo1);
		equipos.get(1).setJugadores(jugadoresEquipo2);
		
		
		Partido partido = new Partido();
		
		partido.setEquipoLocal(equipos.get(0));
		partido.setEquipoVisitante(equipos.get(1));
		
		Resultado resultado = new Resultado();
		
		resultado.setGolesLocales(0);
		resultado.setGolesVisitante(0);
		partido.setResultado(resultado);
		

		System.out.println("Cual ha sido el resultado del equipo local?");
		
		resultado.setGolesLocales(sca.nextInt());
		
		System.out.println("Cual ha sido el resultado del equipo visitante?");
		
		resultado.setGolesVisitante(sca.nextInt());
		
		System.out.println(partido);
		
		System.out.println("Ganador" + partido.getEquipoGanador());
		
		Jugador jugador3 = new Jugador("Blas infiltrado", 99);
		
		jugadoresEquipo2.add(jugador3);
		
		System.out.println(jugadoresEquipo2);
		
		equipos.get(0).setCapitan(jugadoresEquipo1.get(jugadoresEquipo1.size()-1));
		
		System.out.println(jugadoresEquipo1);
		
		
		System.out.println(equipos);
		sca.close();

	}

}
