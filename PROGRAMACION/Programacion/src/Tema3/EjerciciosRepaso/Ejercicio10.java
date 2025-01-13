package Tema3.EjerciciosRepaso;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sca = new Scanner(System.in);

		System.out.println("Cuantos alumnos hay en clase");

		Integer nAlumnos = sca.nextInt();

		String[] nombresAlumnos = new String[nAlumnos];

		Integer[] notaMedia = new Integer[nAlumnos];

		for (int nAlumno = 0; nAlumno < nAlumnos; nAlumno++) {
			System.out.println("Cual es el nombre del alumno " + (nAlumno + 1));
			sca.nextLine();

			nombresAlumnos[nAlumno] = sca.nextLine();

			System.out.println("Cuál es la nota de " + nombresAlumnos[nAlumno] + " para el examen 1?");

			Integer nota1 = sca.nextInt();

			System.out.println("Cuál es la nota de " + nombresAlumnos[nAlumno] + " para el examen 2?");

			Integer nota2 = sca.nextInt();

			System.out.println("Cuál es la nota de " + nombresAlumnos[nAlumno] + " para el examen 3?");

			Integer nota3 = sca.nextInt();

			notaMedia[nAlumno] = (nota1 + nota2 + nota3) / 3;

		}

		System.out.println("LISTADO DE NOTAS ");

		for (int i = 0; i < nombresAlumnos.length; i++) {
			System.out.println("Alumno " + nombresAlumnos[i] + " - " + " Nota media: " + notaMedia[i]);
		}

		Integer mediaClase = 0;

		for (Integer nota : notaMedia) {
			mediaClase += nota;
		}

		System.out.println("Media de los alumnos " + mediaClase / notaMedia.length);
		sca.close();

	}

}
