package Tema4.Ej43.Classes;

public class Guionista extends Empleado {

	public Guionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getSueldo() {
		// TODO Auto-generated method stub
		return 50000;
	}

	@Override
	public String toString() {
		return "Guionista [ Nacionalidad = " + getNacionalidad() + " |  Sueldo = " + getSueldo() + "]";
	}

}
