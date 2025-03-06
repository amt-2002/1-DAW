package Tema4.Ej54.Classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Cargo extends Movimiento {

	
	private String cif;
	
	public Cargo(BigDecimal importe, LocalDate fechaIngresada, CuentaAhorro cuentaAhorro, String cifEmpresa) {
		super(importe, fechaIngresada, cuentaAhorro);
		this.cif = cifEmpresa;
		this.setCuentaAhorro(cuentaAhorro);
		this.setFechaIngresada(fechaIngresada);
		this.setImporte(importe);
		this.setMoney(cuentaAhorro);
	}

	public String toString() {
		return "[ C - " + this.getFechaIngresada() + " - " + this.getImporte() +  " - " + this.cif + "]";
	}
	
	public void setMoney(CuentaAhorro cuentaAhorro) {
		this.getCuentaAhorro().setDineroCuenta(this.getCuentaAhorro().getDineroCuenta().subtract(this.getImporte()));
	}

	@Override
	public String getTipo() {
		return "cargo";
	}
	
}
