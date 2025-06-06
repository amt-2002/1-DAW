package Tema4.Ej35;

import java.util.Objects;

public class Alumno {
	
	private String dni;
	private Double nota;
	private Curso curso;
	
	
	public Alumno() {
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Alumno [ " + curso.getIdentificador() + " / " + curso.getDescripcion() + " ] " + " [ DNI: " + this.dni + " / NOTA: " + this.nota + " ] ";
	}
	
	

	
}