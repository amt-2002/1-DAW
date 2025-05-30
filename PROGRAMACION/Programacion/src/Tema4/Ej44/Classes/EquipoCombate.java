package Tema4.Ej44.Classes;

import java.util.ArrayList;
import java.util.List;

public class EquipoCombate {

	private Integer num_vidas = 0;
	private List<Personaje> personajes = new ArrayList<>();

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void añadirPersonaje(Personaje personaje) {
		if (!personajes.contains(personaje)) {
			if (personajes.size() < 5) {
				personajes.add(personaje);
				this.num_vidas += personaje.getVida();
			} else {
				System.err.println("SOLO PUEDE HABER 5 PERSONAJES EN EL EQUIPO");
			}
		} else {
			System.err.println("NO PUEDE HABER DOS PERSONAJES IGUALES");
		}
	}

	public Integer getNum_vidas() {
		return num_vidas;
	}

	public void setNum_vidas(Integer num_vidas) {
		this.num_vidas = num_vidas;
	}

	public EquipoCombate() {
		super();
	}

	@Override
	public String toString() {
		return "EquipoCombate [num_vidas=" + this.num_vidas + ", personajes=" + this.personajes + "]";
	}

}
