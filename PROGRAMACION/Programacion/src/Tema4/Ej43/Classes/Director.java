package Tema4.Ej43.Classes;

public class Director extends Empleado {

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getSueldo() {
		// TODO Auto-generated method stub
		return 200000;
	}

	@Override
	public String toString() {
		return "Director [getNombre()=" + getNombre() + ", getAño_nacimiento()=" + getAño_nacimiento()
				+ ", getNacionalidad()=" + getNacionalidad() + "]";
	}
	
	
	

}
