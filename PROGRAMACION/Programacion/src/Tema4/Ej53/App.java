package Tema4.Ej53;

import java.math.BigDecimal;

import Tema4.Ej53.Classes.Hucha;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hucha hucha = new Hucha(); 
		
		System.out.println(hucha);
		
		
		BigDecimal cienEuros = new BigDecimal(100);
		
		hucha.meterDinero(cienEuros);
		
		System.out.println(hucha);
		
		BigDecimal cincuentaEuros = new BigDecimal(50.501);
		
		hucha.meterDinero(cincuentaEuros);
		
		System.out.println(hucha);
		
		BigDecimal veinteEuros = new BigDecimal(20.5);
		
		hucha.sacarDinero(veinteEuros);
		
		System.out.println(hucha);
		
		BigDecimal doscientoEuros = new BigDecimal(200);
		
		hucha.sacarDinero(doscientoEuros);
		
		System.out.println(hucha);
		
		hucha.meterDinero(hucha.getDineroSacado());
		
		System.out.println(hucha);
		
		hucha.meterDinero(hucha.contarDinero());
		
		System.out.println(hucha);
		
		hucha.meterDinero(hucha.romperHucha());
		
		System.out.println(hucha);

	}

}
