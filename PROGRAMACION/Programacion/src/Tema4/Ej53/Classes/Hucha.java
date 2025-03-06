package Tema4.Ej53.Classes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Hucha {

	private BigDecimal dineroHucha;
	private BigDecimal dineroSacado;

	public Hucha() {
		super();
		this.dineroHucha = BigDecimal.ZERO;
	}
	
	public BigDecimal getDineroSacado() {
		return this.dineroSacado;
	}

	public BigDecimal meterDinero(BigDecimal cantidadIntroducida) {
		this.dineroHucha = this.dineroHucha.add(cantidadIntroducida);
		return this.dineroHucha;
	}

	public BigDecimal sacarDinero(BigDecimal cantidadSacada) {

		if (this.dineroHucha.compareTo(cantidadSacada) >= 0) {
			this.dineroSacado = cantidadSacada;
			this.dineroHucha = this.dineroHucha.subtract(cantidadSacada);
		} else {
			this.dineroSacado = this.dineroHucha;
			this.dineroHucha = BigDecimal.ZERO;
		}

		return this.dineroSacado;
	}

	public BigDecimal contarDinero() {
		return this.dineroHucha;
	}

	public BigDecimal romperHucha() {
		BigDecimal dineroSacado = this.dineroHucha;
		this.dineroHucha = BigDecimal.ZERO;
		return dineroSacado;
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00 €");
		return formato.format(this.dineroHucha);
	}
	

}
