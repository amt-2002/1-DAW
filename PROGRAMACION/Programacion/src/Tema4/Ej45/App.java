package Tema4.Ej45;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sca = new Scanner(System.in);
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("Escriba su fecha de nacimiento");
		
		String fecha = sca.nextLine();
		
		LocalDate fechaFormatted = LocalDate.parse(fecha, formato);
		
		
		Boolean bisiesto = fechaFormatted.isLeapYear();
		
		if (bisiesto) {
			System.out.println("Has nacido en un año biciesto \n");
		} else {
			System.out.println("No has nacido en un año biciesto \n");
		}
		
		System.out.println("Naciste el dia " +fechaFormatted.getDayOfWeek());
		
		
		LocalDate fechaActual = LocalDate.now();
		
		Period periodo = fechaFormatted.until(fechaActual);
		
		Integer añosDiferencia = periodo.getYears();
		
		System.out.println("Tienes " + añosDiferencia + " años");
		
		LocalDate fechaProxima = fechaFormatted.plusYears(100);
		
		System.out.println(fechaProxima);
		
		Period periodo2 = fechaActual.until(fechaProxima);
		
		Integer añosProximoDiferencia = periodo2.getYears();
		Integer mesesProximoDiferencia = periodo2.getMonths();
		Integer diasProximoDiferencia = periodo2.getDays();
		
		
		System.out.println("Te quedan de vida " + 
			+ añosProximoDiferencia + " años "
			+ mesesProximoDiferencia + " meses "	
			+ diasProximoDiferencia + " dias \n"
		);
		
	
		LocalTime tiempoActual = LocalTime.now();
		
		
		System.out.println("La hora actual es " 
			+ tiempoActual.getHour() + ":"
			+ tiempoActual.getMinute() + ":"
			+ tiempoActual.getSecond()
			
		);
		
		
		
		sca.close();

	}

}
