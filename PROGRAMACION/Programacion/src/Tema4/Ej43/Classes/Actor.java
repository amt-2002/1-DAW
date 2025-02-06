package Tema4.Ej43.Classes;

public class Actor extends Empleado {

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getSueldo() {
		return 100000;
	}

	@Override
	public String toString() {
		return "Actor [Nombre =" + getNombre() + ", Año de nacimiento =" + getAño_nacimiento()
				+ ", Nacionalidad =" + getNacionalidad() + "]";
	}
	
}
