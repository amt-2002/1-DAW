package Tema4.Ej44.Classes;

public class Parasito extends Personaje {

	@Override
	public String toString() {
		return "Parasito [vida=" + vida + ", nombre=" + nombre + ", codigo=" + codigo + ", dañoAtaque()=" + dañoAtaque()
				+ ", tiempoAtaque()=" + tiempoAtaque() + "]";
	}

	public Parasito(String nombre, String codigo) {
		super(nombre, codigo);
		this.vida = 200; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer dañoAtaque() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Integer tiempoAtaque() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void setDañoAtaque(EquipoCombate equipoEnemigo) {
		// TODO Auto-generated method stub
		Integer vidaActual = equipoEnemigo.getNum_vidas();
		this.dañoEnviado = vidaActual - dañoAtaque();
		equipoEnemigo.setNum_vidas(this.dañoEnviado);
	}



}
