package Tema4.Ej18;

public class Ej18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ejercicio 18

		Alumno alumno1 = new Alumno();

		alumno1.setDni("21154414J");
		alumno1.setNombre("Angel");
		alumno1.setEdad(22);
		alumno1.setNota(10.0);

		System.out.println("El dni del alumno 1 es " + alumno1.getDni());
		System.out.println("El nombre del alumno 1 es " + alumno1.getNombre());
		System.out.println("La edad del alumno 1 es " + alumno1.getEdad());
		System.out.println("La nota del alumno 1 es " + alumno1.getNota());

	}

}
