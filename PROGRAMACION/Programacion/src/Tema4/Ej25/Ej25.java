package Tema4.Ej25;

import java.util.Scanner;

public class Ej25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();
		
		Curso curso = new Curso("1", "DAM-DAW");
		
		Alumno [] AlumnoArray = new Alumno [] {alumno1, alumno2, alumno3};
		
		Scanner sca = new Scanner(System.in);
		
		for( int i = 0; i < AlumnoArray.length; i++) {
			
			
			System.out.println("Cual es el dni del alumno " + i);
			
			AlumnoArray[i].setDni(sca.nextLine());
			
			System.out.println("Cual es la nota del alumno " + i);
			
			AlumnoArray[i].setNota(sca.nextDouble());
			
			AlumnoArray[i].setCurso(curso);
			
			sca.nextLine();
			
		}	
		
		Boolean encontradoIguales = false; 
		
		for( int i = 0; i < AlumnoArray.length; i++) {
			
			if (encontradoIguales) {
				break;
			}
			
			for( int x = i+1; x < AlumnoArray.length; x++) {
				if (AlumnoArray[i].equals(AlumnoArray[x])) {
					System.err.println("NO PUEDEN HABER DOS ALUMNOS IGUALES");
					encontradoIguales = true;
					break;
				}
			}

		}	
		
		sca.close();
		
	}

}
