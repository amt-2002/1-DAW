package Tema4.Ej22;

public class Ej22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alumno alumno = new Alumno();
		
		Curso curso = new Curso();
		
		curso.setDescripcion("Prueba");
		curso.setIdentificador("111");
	
		alumno.setCurso(curso);
			
		System.out.println(alumno.toString());

	}

}
