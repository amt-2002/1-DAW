package Tema4.Ej42;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Resultado resultado;

	public Partido() {
	}

	@Override
	public String toString() {
		return equipoLocal + " vs " + equipoVisitante + "[" + resultado + "]";

	}

	public Equipo getEquipoGanador() {
		if (resultado.isVictoriaLocal()) {
			return equipoLocal;
		}
		if (resultado.isVictoriaVisitante()) {
			return equipoVisitante;
		}
		return null;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

}
