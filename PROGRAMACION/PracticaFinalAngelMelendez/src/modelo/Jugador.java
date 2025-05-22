package modelo;

import java.time.LocalDate;

public class Jugador {

	private Integer numero;
	private String codEquipo;
	private String nombre;
	private LocalDate fechaNacimiento;

	public Jugador() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", codEquipo=" + codEquipo + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

}
