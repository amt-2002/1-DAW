package examen.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LibroSegundaMano extends Libro {

	private Integer antiguedad;
	
	public LibroSegundaMano() {
		super();
	}

	@Override
	public BigDecimal getPrecio() {
		// TODO Auto-generated method stub
		return super.getPrecio().divide(BigDecimal.TWO, 2, RoundingMode.HALF_DOWN);
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	} 
	
	
}
