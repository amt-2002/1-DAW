package Tema4.EjerciciosBasicos;

public class Calculadora {

	public static Integer sumar(Integer num1, Integer num2) {
		
		Integer calculoRealizado = num1 + num2; 
		
		return calculoRealizado;
		
	}
	

    // Ejercicio 7

	public static Integer restar(Integer num1, Integer num2) {
		
		Integer calculoRealizado = num1 - num2; 
		
		return calculoRealizado;
		
	}
	
	public static Integer multiplicar(Integer num1, Integer num2) {
		
		Integer calculoRealizado = num1 * num2; 
		
		return calculoRealizado;
		
	}
	
	
	public static Integer dividir(Integer num1, Integer num2) {
		
		if (num2 == 0) {
			return 0;
		}
		
		Integer calculoRealizado = num1 / num2; 
		
		return calculoRealizado;
		
	}

	
	// Ejercicio 8
	
	public static final String SUMAR = "ADD"; 
	public static final String RESTAR = "SUB"; 
	public static final String MULTIPLICAR = "MUL"; 
	public static final String DIVIDIR = "DIV"; 
	
	public static Integer calcular(String operacion, Integer num1, Integer num2) {
			
		Integer resultado = 0; 
		
		if (operacion.equalsIgnoreCase(SUMAR)) {
			resultado = sumar(num1, num2);
		} else if (operacion.equalsIgnoreCase(RESTAR)) {
			resultado = restar(num1, num2);
		} else if (operacion.equalsIgnoreCase(MULTIPLICAR)) {
			resultado = multiplicar(num1, num2);
		} else if (operacion.equalsIgnoreCase(DIVIDIR)) {
			resultado = dividir(num1, num2);
		}
		
		return resultado;
		
	}


}
