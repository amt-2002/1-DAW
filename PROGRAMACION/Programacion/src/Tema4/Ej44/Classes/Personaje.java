package Tema4.Ej44.Classes;

public abstract class Personaje {

	Integer vida;
	String nombre;
	String codigo;
	Integer dañoEnviado; 

	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}


	public Personaje(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}


	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public abstract Integer dañoAtaque();
	public abstract Integer tiempoAtaque();
	public abstract void setDañoAtaque(EquipoCombate equipoEnemigo);
}
