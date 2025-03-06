package Tema4.Ej54;

import java.math.BigDecimal;
import java.time.LocalDate;

import Tema4.Ej54.Classes.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CuentaAhorro cuenta1 = new CuentaAhorro("34567891234567891234"); 
		
		System.out.println(cuenta1.getDineroCuenta());
		
		BigDecimal importe1 = new BigDecimal(30);
		BigDecimal importe2 = new BigDecimal(200);
		BigDecimal importe3 = new BigDecimal(76);
		
		LocalDate fecha = LocalDate.now();
		
		Cargo cargo1 = new Cargo(importe1, fecha, cuenta1, "98765432F");
		Cargo cargo2 = new Cargo(importe3, fecha, cuenta1, "42765432F");
		
		Ingreso ingreso1 = new Ingreso(importe2, fecha, cuenta1, "Sueldo");
		Ingreso ingreso2 = new Ingreso(importe3, fecha, cuenta1, "Sueldo");
		
		Retirada retirada1 = new Retirada(importe1, fecha, cuenta1);
		
		cuenta1.anadirMovimiento(cargo1);
		cuenta1.anadirMovimiento(cargo2);
		cuenta1.anadirMovimiento(ingreso1);
		cuenta1.anadirMovimiento(ingreso2);
		cuenta1.anadirMovimiento(retirada1);
		
		System.out.println("Dinero " + cuenta1.getDineroCuenta());
		
		System.out.println("Movimientos " + cuenta1.getMovimientos());
		
		System.out.println("Retiradas " + cuenta1.getRetiradas());
		
		System.out.println("Cargos " + cuenta1.getCargos());
		
		System.out.println("Ingresos " + cuenta1.getIngresos());
		
		
		
	}

}
