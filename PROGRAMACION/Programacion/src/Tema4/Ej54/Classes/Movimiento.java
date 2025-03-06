package Tema4.Ej54.Classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Movimiento {

	private BigDecimal importe;
	private CuentaAhorro cuentaAhorro;

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public LocalDate getFechaIngresada() {
		return fechaIngresada;
	}

	public void setFechaIngresada(LocalDate fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}

	private LocalDate fechaIngresada;

	public Movimiento(BigDecimal importe, LocalDate fechaIngresada, CuentaAhorro cuentaAhorro) {
		super();
	}

	public CuentaAhorro getCuentaAhorro() {
		return cuentaAhorro;
	}

	public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
		this.cuentaAhorro = cuentaAhorro;
	}
	
	public abstract String getTipo(); 
	
	public abstract void setMoney(CuentaAhorro cuentaAhorro); 

}
