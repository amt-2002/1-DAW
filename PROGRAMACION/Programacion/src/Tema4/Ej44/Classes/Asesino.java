package Tema4.Ej44.Classes;

public class Asesino extends Personaje {

	private Integer dañoEnviado; 
	
	@Override
	public String toString() {
		return "Asesino [vida=" + vida + ", nombre=" + nombre + ", codigo=" + codigo + ", dañoAtaque()=" + dañoAtaque()
				+ ", tiempoAtaque()=" + tiempoAtaque() + "]";
	}

	public Asesino(String nombre, String codigo) {
		super(nombre, codigo);
		this.vida = 100; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer dañoAtaque() {
		return 10;
		
	}

	@Override
	public Integer tiempoAtaque() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void setDañoAtaque(EquipoCombate equipoEnemigo) {
		// TODO Auto-generated method stub
		Integer vidaActual = equipoEnemigo.getNum_vidas();
		this.dañoEnviado = vidaActual - dañoAtaque();
		equipoEnemigo.setNum_vidas(this.dañoEnviado);
	}


}
