package Tema4.Ej36;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String identificador;
	private String descripcion;
	//private Alumno [] alumnos; 
	private List <Alumno> alumnos;
	private Integer maxAlumnos = 0;

	
	public Curso(String i, String d, Integer nAlumnos) {
		this.identificador = i;
		this.descripcion = d;
		//this.alumnos = new Alumno [nAlumnos];
		this.maxAlumnos = nAlumnos;
		this.alumnos = new ArrayList<>();
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public void addAlumno(Alumno alumno) {
		if (alumnos.size() < this.maxAlumnos) {
			alumnos.add(alumno);
		} else {
			System.out.println("CURSO COMPLETO");
		}
	}
	
	
	/*public Alumno[] getAlumnos() {
		return this.alumnos;
	}
	
	public void addAlumno(Alumno alumno) {
		for (int i = 0; i < this.alumnos.length; i++) {
			if (this.alumnos[i] == null) {
				this.alumnos[i] = alumno; 
			}
		}
	}*/


	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
