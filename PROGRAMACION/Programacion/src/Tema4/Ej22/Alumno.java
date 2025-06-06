package Tema4.Ej22;

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
	public String toString() {
		return "Alumno [ " + curso.getIdentificador() + " / " + curso.getDescripcion() + " ]";
	}
	
	

	
}