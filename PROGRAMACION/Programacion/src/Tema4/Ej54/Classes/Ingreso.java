package Tema4.Ej54.Classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ingreso extends Movimiento {

	private String descripcion; 
	
	public Ingreso(BigDecimal importe, LocalDate fechaIngresada, CuentaAhorro cuentaAhorro, String desc) {
		super(importe, fechaIngresada, cuentaAhorro);
		this.setCuentaAhorro(cuentaAhorro);
		this.setImporte(importe);
		this.setFechaIngresada(fechaIngresada);
		this.descripcion = desc;
		this.setMoney(cuentaAhorro);
		// TODO Auto-generated constructor stub
	}

	
	public String toString() {
		return "[ I - " + this.getFechaIngresada() + " - " + this.getImporte() +  " - " + this.descripcion + "]";
	}


	public void setMoney(CuentaAhorro cuentaAhorro) {
		this.getCuentaAhorro().setDineroCuenta(this.getCuentaAhorro().getDineroCuenta().add(this.getImporte()));
	}


	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "ingreso";
	}
}
