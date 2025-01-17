package Tema4.Ej24;

public class Alumno {
	
	private String dni;
	private Double nota;
	private String nombre;
	private Integer edad;
	
	public Alumno(String d, Double nt, String n, Integer e) {
		this.dni = d;
		this.edad = e;
		this.nombre = n;
		this.nota = nt;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nota=" + nota + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

}