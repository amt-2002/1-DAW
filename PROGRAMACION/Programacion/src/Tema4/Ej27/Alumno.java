package Tema4.Ej27;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		this.dni = dni.toUpperCase(); 
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public Boolean validarDNI(String dni) {
		if (dni.equals(null)) {
			return false;
		} else if (dni.length() < 9) {
			return false;
		}
		
		Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]"); //EJ28
		
		Matcher match = patron.matcher(dni);
		
		if(!match.matches()) {
			return false;
		}
		
		return true;
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
		return "Alumno [ " + curso.getIdentificador() + " / " + curso.getDescripcion() + " ]";
	}
	
	

	
}