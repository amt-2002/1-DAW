package Tema4.Ej36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Alumno[] AlumnoArray = new Alumno[] { alumno1};

		Scanner sca = new Scanner(System.in);
		
		List <Alumno> alumnos = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			Alumno creacionAlumno = new Alumno(null, null, null, null, null);
			alumnos.add(creacionAlumno);
		}
		
		Curso curso = new Curso("1", "DAM-DAW", 6);
		
		
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println("Cual es el dni del alumno");
			alumnos.get(i).setDni(sca.nextLine());

			System.out.println("Cual es la nota del alumno");
			alumnos.get(i).setNota(sca.nextDouble());

			alumnos.get(i).setCurso(curso);

			sca.nextLine(); 
			
			System.out.println("Cual es el nombre del alumno");
			
			alumnos.get(i).setNombre(sca.nextLine());
			
			System.out.println("Cual es la edad del alumno");
			
			alumnos.get(i).setEdad(sca.nextInt());
			
			if (alumnos.get(i).validar())  {
				System.out.println("El alumno se ha creado correctamente \n");
			} else {
				System.out.println("Faltan campos en la creacion del alumno o los datos no son correctos \n");
				break;
			}
			
			sca.nextLine();
		}
		
		
		Boolean encontradoIguales = false; 
		
		for( int i = 0; i < alumnos.size(); i++) {
			
			if (encontradoIguales) {
				break;
			}
			
			for( int x = i+1; x < alumnos.size(); x++) {
				if (alumnos.get(i).equals(alumnos.get(x))) {
					System.err.println("NO PUEDEN HABER DOS ALUMNOS IGUALES");
					encontradoIguales = true;
					break;
				}
			}

		}
		
		for(Alumno alumno:alumnos) {
			curso.addAlumno(alumno);
		}
		
		for (Alumno alumno : curso.getAlumnos()) {
			System.out.println("El alumno es " + alumno);
		}

		/*for (int i = 0; i < AlumnoArray.length; i++) {

			System.out.println("Cual es el dni del alumno " + i);

			AlumnoArray[i].setDni(sca.nextLine());

			System.out.println("Cual es la nota del alumno " + i);

			AlumnoArray[i].setNota(sca.nextDouble());

			AlumnoArray[i].setCurso(curso);

			sca.nextLine(); // Limpiamos buffer

			System.out.println("Cual es el nombre del alumno " + i);

			AlumnoArray[i].setNombre(sca.nextLine());

			System.out.println("Cual es la edad del alumno " + i);

			AlumnoArray[i].setEdad(sca.nextInt());

			if (AlumnoArray[i].validar()) {
				System.out.println("El alumno se ha creado correctamente \n");
			} else {
				System.out.println("Faltan campos en la creacion del alumno o los datos no son correctos \n");
				break;
			}
				System.out.println("Faltan campos en la creacion del alumno o los datos no son correctos \n");
				break;
		}

		Boolean encontradoIguales = false;

		for (int i = 0; i < AlumnoArray.length; i++) {

			if (encontradoIguales) {
				break;
			}

			for (int x = i + 1; x < AlumnoArray.length; x++) {
				if (AlumnoArray[i].equals(AlumnoArray[x])) {
					System.err.println("NO PUEDEN HABER DOS ALUMNOS IGUALES");
					encontradoIguales = true;
					break;
				}
			}

		}
		
		
		for (Alumno alumno : AlumnoArray) {
			curso.addAlumno(alumno);
		}
		
		
		for (Alumno alumno : curso.getAlumnos()) {
			System.out.println("El alumno es " + alumno);
		}
		
		*/
		sca.close();

	}

}
