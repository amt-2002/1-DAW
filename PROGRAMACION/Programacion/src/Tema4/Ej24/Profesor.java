package Tema4.Ej24;

public class Profesor {
	
	private String nombre;
	private Integer edad;
	
	public Profesor(String n, Integer e) {
		this.nombre = n;
		this.edad = e;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
