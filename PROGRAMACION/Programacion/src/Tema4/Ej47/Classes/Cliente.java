package Tema4.Ej47.Classes;

public class Cliente {

	private String dni;
	private String nombre;

	public Cliente(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Dni " + this.dni + " Nombre " + this.nombre;
	}

}
