package Tema6.Ej3.app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import Tema6.Ej3.modelo.*;
import Tema6.Ej3.services.PersonasServive;

public class App {

	public static void main(String[] args) {
		PersonasServive service = new PersonasServive();
		Scanner sc = new Scanner(System.in);
		Integer opcion = 0;
		
		try {	
			do {
				System.out.println("Elige una de estas opciones");
				System.out.println("\t (1) Buscar personas por DNI");
				System.out.println("\t (2) Buscar personas por nombre/apellidos");
				System.out.println("\t (3) Insertar persona");
				System.out.println("\t (4) Actualizar persona");
				System.out.println("\t (5) Borrar persona");
				System.out.println("\t (6) Salir");
				
				opcion = sc.nextInt();
				
				if (opcion == 1) {
					sc.nextLine(); // clear buffer
					System.out.println("Indica el DNI de la persona");
					String vDNI = sc.nextLine();
					Persona p = service.consultarPersona(vDNI);
					if (p == null) {
						System.out.println("No existe persona con los datos introducidos");
					} else {
						System.out.println(p);
					}
				} else if (opcion == 2) {
					sc.nextLine(); // clear buffer
					System.out.println("Indica nombre o apellidos a buscar:");
					String filtro = "";
					do {
						filtro = sc.nextLine();
					} while (filtro.isEmpty());
					List<Persona> lista = service.buscarPersona(filtro);
					if (lista.isEmpty())
						System.out.println("No hay ninguna persona con ese filtro");
					for (Persona persona : lista) {
						System.out.println(persona);
					}
				} else if (opcion == 3) {
					sc.nextLine(); // clear buffer
					Persona p = new Persona();
					System.out.println("Indica nombre de la persona");
					String nPers = sc.nextLine();
					p.setNombre(nPers);
					System.out.println("Indica el apellido de la persona");
					String aPers = sc.nextLine();
					p.setApellidos(aPers);
					System.out.println("Indica DNI de la persona");
					String dPers = sc.nextLine();
					p.setDni(dPers);
					System.out.println("Indica la fecha de nacimiento de la persona");
					String vFecha = sc.nextLine();
					
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate fechaNacimiento = LocalDate.parse(vFecha, format);
						p.setFechaNac(fechaNacimiento);
					} catch (DateTimeParseException e) {
						System.err.println("La fecha indicada no es correcta. Empieza de nuevo");
					}
					
	
					try {
						service.insertarPersona(p);
					} catch (SQLException e) {
						System.out.println("Error al ingresar la persona");
					}
				} else if (opcion == 4) {
					sc.nextLine(); // clear buffer
					System.out.println("Escribe el DNI de la persona a actualizar");
					String dniA = sc.nextLine();
					Persona p = new Persona();
					System.out.println("Indica nuevo nombre de la persona");
					String nPers = sc.nextLine();
					p.setNombre(nPers);
					System.out.println("Indica el nuevo apellido de la persona");
					String aPers = sc.nextLine();
					p.setApellidos(aPers);
					System.out.println("Indica nuevo DNI de la persona");
					String dPers = sc.nextLine();
					p.setDni(dPers);
					System.out.println("Indica la nueva fecha de nacimiento de la persona");
					String vFecha = sc.nextLine();
					
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						LocalDate fechaNacimiento = LocalDate.parse(vFecha, format);
						p.setFechaNac(fechaNacimiento);
					} catch (DateTimeParseException e) {
						System.err.println("La fecha indicada no es correcta. Empieza de nuevo");
					}
					
					service.actualizarPersona(dniA, p);
				}  else if (opcion == 5) {
					sc.nextLine(); // clear buffer
					System.out.println("Escribe el DNI de la persona a borrar");
					String dniA = sc.nextLine();
					service.borrarPersona(dniA);
				}
			} while (opcion < 6);

		} finally {
			sc.close();
		}

	}

}
