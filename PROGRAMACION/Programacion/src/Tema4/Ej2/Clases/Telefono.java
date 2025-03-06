package Tema4.Ej2.Clases;

public class Telefono {

	private Integer nTelefono;
	private Boolean enLlamada;

	public Telefono(Integer tel) {
		super();
		this.nTelefono = tel;
		this.enLlamada = false;
	}

	public Integer consultarNumero() {
		return this.nTelefono;
	}
	
	public void marcar(Integer tel) {
		System.out.println("LLAMANDO A " + tel);
		if (this.nTelefono.equals(tel)) {
			System.out.println("COMUNICANDO");
			return;
		}
		System.out.println("EN COMUNICACION");
		this.enLlamada = true;
	}
	
	public void colgar() {
		if (this.enLlamada) {
			System.out.println("COMUNICACION TERMINADA");
			this.enLlamada = false; 
		}
	}

}
