package Tema5.Ej7;

import java.math.BigDecimal;

public class Persona {
	
	private String genero; 
	private BigDecimal altura;
	
	
	public Persona() {
		super();
		this.altura = BigDecimal.ZERO;
	} 
	

	public void setGenero(String sexo) throws ParametroIncorrectoException {
		if (!sexo.equals("H") && !sexo.equals("M")) {
			throw new ParametroIncorrectoException("El genero debe ser H o M");
		}
		this.genero = sexo;
	}
	
	public void setAltura(BigDecimal altu) throws ParametroIncorrectoException {
		BigDecimal num3 = new BigDecimal(3);

		if ((altu.compareTo(BigDecimal.ZERO) > 0 && altu.compareTo(num3) < 0)) {
			this.altura = altu;
		} else {
			throw new ParametroIncorrectoException("El numero debe estar entre el 0 y 3");
		}
	}


	public String getGenero() {
		return genero;
	}


	public BigDecimal getAltura() {
		return altura;
	}

}
