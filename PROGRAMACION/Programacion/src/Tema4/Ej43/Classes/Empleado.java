package Tema4.Ej43.Classes;

public abstract class Empleado {

	private String nombre;
	private Integer año_nacimiento;
	private String nacionalidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAño_nacimiento() {
		return año_nacimiento;
	}

	public Empleado() {
		super();
	}

	public void setAño_nacimiento(Integer año_nacimiento) {
		this.año_nacimiento = año_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public abstract Integer getSueldo(); 

}
