package Tema4.Ej44.Classes;

public class Jugador {

	private String nombre;
	private EquipoCombate equipo_combate;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EquipoCombate getEquipo_combate() {
		return equipo_combate;
	}

	public void setEquipo_combate(EquipoCombate equipo_combate) {
		if (this.equipo_combate == null) {
			this.equipo_combate = equipo_combate;
		} else {
			System.err.println("SOLO PUEDES TENER UN EQUIPO");
		}
	}

	public Jugador() {
		super();
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", equipo_combate=" + equipo_combate + "]";
	}
}
