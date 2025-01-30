package Tema4.Ej33;

public class Semaforo {
	public static final String ROJO = "ROJO";
	public static final String AMBAR = "AMBAR";
	public static final String VERDE = "VERDE";

	Boolean parpadeando;
	String color;

	public Semaforo() {
		this.color = ROJO;
		this.parpadeando = false;
	}

	public Boolean getParpadeando() {
		return parpadeando;
	}

	public void setParpadeando(Boolean parpadeando) {
		if (this.color.equals(AMBAR)) {
			this.parpadeando = parpadeando;
		}
	}

	@Override
	public String toString() {
		if (this.color.equals(ROJO)) {
			return "Semáforo en ROJO";
		} else if (this.color.equals(VERDE)) {
			return "Semáforo en VERDE";
		} else if (this.color.equals(AMBAR) && this.parpadeando) {
			return "Semáforo en AMBAR parpadeando";
		} else if (this.color.equals(AMBAR)) {
			return "Semáforo en AMBAR";
		}
		return "ERROR";
	}

	public void cambiarEstado() {

		if (this.color.equals(VERDE)) {
			this.color = AMBAR;
			this.parpadeando = true;
			return;
		}

		if (this.color.equals(AMBAR) && this.parpadeando) {
			this.color = AMBAR;
			this.parpadeando = false;
			return;
		}

		if (this.color.equals(AMBAR) && !this.parpadeando) {
			this.color = ROJO;
			return;
		}

		if (this.color.equals(ROJO)) {
			this.color = VERDE;
			return;
		}

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color.equals(ROJO) || color.equals(AMBAR) || color.equals(VERDE)) {
			this.color = color;
		}
	}

	public static String getRojo() {
		return ROJO;
	}

	public static String getAmbar() {
		return AMBAR;
	}

	public static String getVerde() {
		return VERDE;
	}

}
