package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.*;
import services.EquipoService;
import services.EquipoServiceException;
import services.NotFoundException;


public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static EquipoService equipoService;
    private static Equipo equipoActual;

    public static void main(String[] args) {
        equipoService = new EquipoService();
		mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Ver todos los equipos");
            System.out.println("2. Crear nuevo equipo");
            System.out.println("3. Consultar equipo por código");
            System.out.println("0. Salir");
            
            int opcion = leerEntero("Seleccione una opción: ");
            
            if (opcion == 1) {
                listarEquipos();
            } 
            else if (opcion == 2) {
                crearEquipo();
            } 
            else if (opcion == 3) {
                consultarEquipo();
            } 
            else if (opcion == 0) {
                System.out.println("¡Gracias por usar el sistema!");
                break;
            } 
            else {
                System.out.println("Opción inválida");
            }
        }
    }

    private static void listarEquipos() {
        try {
            List<Equipo> equipos = equipoService.consultarEquipos();
            System.out.println("\n--- EQUIPOS REGISTRADOS ---");
            for (Equipo equipo : equipos) {
            	System.out.println(equipo.getCodigo() + " - " + equipo.getNombre());
			}
        } catch (EquipoServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearEquipo() {
        try {
            System.out.println("\n--- CREAR NUEVO EQUIPO ---");
            String codigo = leerCadena("Código del equipo (2-5 caracteres): ", 2, 5);
            String nombre = leerCadena("Nombre del equipo: ", 1, 50);
            
            List<Jugador> jugadores = new ArrayList<>();
            do {
                Jugador jugador = crearJugador(codigo, jugadores.size() + 1);
                jugadores.add(jugador);
            } while (confirmar("¿Añadir otro jugador? (S/N)"));

            Equipo nuevoEquipo = new Equipo();
            nuevoEquipo.setCodigo(codigo);
            nuevoEquipo.setNombre(nombre);
            nuevoEquipo.setJugadores(jugadores);
            
            equipoService.crearEquipo(nuevoEquipo);
            System.out.println("Equipo creado exitosamente!");
        } catch (EquipoServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Jugador crearJugador(String codigoEquipo, int numero) {
        System.out.println("\n--- NUEVO JUGADOR ---");
        String nombre = leerCadena("Nombre del jugador: ", 1, 100);
        LocalDate fechaNacimiento = leerFecha("Fecha de nacimiento (dd/MM/yyyy): ");
        
        Jugador jugador = new Jugador();
        jugador.setNumero(numero);
        jugador.setCodEquipo(codigoEquipo);
        jugador.setNombre(nombre);
        jugador.setFechaNacimiento(fechaNacimiento);
        
        return jugador;
    }

    private static void consultarEquipo() {
        String codigo = leerCadena("Ingrese el código del equipo: ", 2, 5);
        
        try {
            equipoActual = equipoService.consultarEquipoCompleto(codigo);
            mostrarMenuEquipo();
        } catch (NotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EquipoServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarMenuEquipo() {
        while (true) {
            System.out.println("\nMENÚ DEL EQUIPO: " + equipoActual.getCodigo());
            System.out.println("1. Ver plantilla");
            System.out.println("2. Borrar equipo");
            System.out.println("3. Añadir jugador");
            System.out.println("4. Calcular edad media");
            System.out.println("5. Exportar plantilla");
            System.out.println("0. Volver al menú principal");
            
            int opcion = leerEntero("Seleccione una opción: ");
            
            if (opcion == 1) {
                verPlantilla();
            } 
            else if (opcion == 2) {
                borrarEquipo();
                return;
            } 
            else if (opcion == 3) {
                añadirJugador();
            } 
            else if (opcion == 4) {
                calcularEdadMedia();
            } 
            else if (opcion == 5) {
                exportarPlantilla();
            } 
            else if (opcion == 0) {
                break;
            } 
            else {
                System.out.println("Opción inválida");
            }
        }
    }

    private static void verPlantilla() {
        System.out.println("\n--- PLANTILLA DEL EQUIPO ---");
        List<Jugador> jugadores = equipoActual.getJugadores();
        for (Jugador jugador : jugadores) {
        	System.out.println(jugador);
		}
    }

    private static void borrarEquipo() {
        if (confirmar("¿Está seguro de borrar el equipo? (S/N)")) {
            try {
                equipoService.borrarEquipoCompleto(equipoActual.getCodigo());
                System.out.println("Equipo borrado exitosamente!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void añadirJugador() {
        try {
            List<Jugador> jugadores = equipoService.consultarJugadoresEquipo(equipoActual.getCodigo());
            int nuevoNumero = jugadores.size() + 1;
            
            Jugador nuevo = crearJugador(equipoActual.getCodigo(), nuevoNumero);
            equipoService.añadirJugadorAEquipo(nuevo);
            equipoActual.getJugadores().add(nuevo);
            System.out.println("Jugador añadido exitosamente!");
        } catch (EquipoServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void calcularEdadMedia() {
        BigDecimal edadMedia = equipoActual.getEdadMedia();
        System.out.println("\nEdad media de la plantilla: " + edadMedia + " años");
    }

    private static void exportarPlantilla() {
        String ruta = leerCadena("Ingrese la ruta del archivo: ", 1, 255);
        try {
            equipoService.exportarJugadores(equipoActual.getCodigo(), ruta);
            System.out.println("Plantilla exportada exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido");
            }
        }
    }

    private static String leerCadena(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (input.length() >= min && input.length() <= max) {
                return input;
            }
            System.out.printf("Debe tener entre %d y %d caracteres\n", min, max);
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido (dd/MM/yyyy)");
            }
        }
    }

    private static boolean confirmar(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) return true;
            if (respuesta.equals("N")) return false;
            System.out.println("Ingrese S o N");
        }
    }
}