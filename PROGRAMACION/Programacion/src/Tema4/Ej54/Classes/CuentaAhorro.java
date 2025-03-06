package Tema4.Ej54.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaAhorro {

	private String nCuenta;
	private BigDecimal dineroCuenta; 
	private List<Movimiento> movimientos;
	
	public CuentaAhorro(String nCuentaCreada) {
		super();
		if (nCuentaCreada.length() == 20) {
			this.nCuenta = nCuentaCreada;
			this.movimientos = new ArrayList<>();
			this.dineroCuenta = BigDecimal.ZERO;
		}
	} 
	
	public BigDecimal getDineroCuenta() {
		return dineroCuenta;
	}
	
	public void setDineroCuenta(BigDecimal dinero) {
		this.dineroCuenta = dinero;
	}

	public void anadirMovimiento(Movimiento movimientoCuenta) {
		this.movimientos.add(movimientoCuenta);
	}
	
	public List<Movimiento> getCargos() {
		List<Movimiento> cargos = new ArrayList<>();
		for (Movimiento movimiento : movimientos) {
			if (movimiento.getTipo().equals("cargo")) {
				cargos.add(movimiento);
			}
		}
		
		return cargos;
	}
	
	public List<Movimiento> getRetiradas() {
		List<Movimiento> retiradas = new ArrayList<>();
		for (Movimiento movimiento : movimientos) {
			if (movimiento.getTipo().equals("retirada")) {
				retiradas.add(movimiento);
			}
		}
		
		return retiradas;
	}
	
	public List<Movimiento> getIngresos() {
		List<Movimiento> ingresos = new ArrayList<>();
		for (Movimiento movimiento : movimientos) {
			if (movimiento.getTipo().equals("ingreso")) {
				ingresos.add(movimiento);
			}
		}
		
		return ingresos;
	}
	
	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}
	
	@Override
	public String toString() {
		return "CuentaAhorro [ Movimientos = " + movimientos + "]";
	}
	
	

	
}
