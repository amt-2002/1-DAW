package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Equipo {

	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;

	public Equipo() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
	public BigDecimal getEdadMedia() {
		LocalDate fechaActual = LocalDate.now(); 
		BigDecimal mediaAños = BigDecimal.ZERO;
		for (Jugador jugador : jugadores) {
			LocalDate fechaJugador = jugador.getFechaNacimiento(); 
			Period periodo = fechaJugador.until(fechaActual); 
			Integer añosDiferencia = periodo.getYears();  
			BigDecimal añosBig = new BigDecimal(añosDiferencia);
			mediaAños = mediaAños.add(añosBig); 
		}
		
		mediaAños = mediaAños.divide(new BigDecimal(jugadores.size()));
		
		return mediaAños.setScale(2, RoundingMode.HALF_DOWN); 
	}
	
	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", nombre=" + nombre + ", jugadores=" + jugadores + "]";
	}

}
