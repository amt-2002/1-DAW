package Tema4.Ej54.Classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Retirada extends Movimiento {

	public Retirada(BigDecimal importe, LocalDate fechaIngresada, CuentaAhorro cuentaAhorro) {
		super(importe, fechaIngresada, cuentaAhorro);
		this.setCuentaAhorro(cuentaAhorro);
		this.setImporte(importe);
		this.setFechaIngresada(fechaIngresada);
		this.setMoney(cuentaAhorro);
	}
	
	public String toString() {
		return "[ R - " + this.getFechaIngresada() + " - " + this.getImporte() + "]";
	}

	
	public void setMoney(CuentaAhorro cuentaAhorro) {
		this.getCuentaAhorro().setDineroCuenta(this.getCuentaAhorro().getDineroCuenta().subtract(this.getImporte()));
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "retirada";
	}

	
}
