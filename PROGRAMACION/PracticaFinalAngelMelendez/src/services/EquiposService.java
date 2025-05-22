package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Jugador;

public class EquiposService {

	private OpenConnection openConn;

	public EquiposService() {
		super();
		this.openConn = new OpenConnection();
	}

	public List<Equipo> consultarEquipos() throws EquipoServiceException {
		String sql = "SELECT * FROM EQUIPO";
		try (Connection conn = openConn.getNewConnection(); Statement stm = conn.createStatement()) {
			ResultSet rs = stm.executeQuery(sql);
			List<Equipo> equipos = new ArrayList<>();
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");

				Equipo equipo = new Equipo();

				equipo.setCodigo(codigo);
				equipo.setNombre(nombre);

				equipos.add(equipo);

			}

			return equipos;
		} catch (SQLException e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	
	
	public List<Jugador> consultarJugadoresEquipo(String cod) {
		String sql = "SELECT * FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		List<Jugador> jugadores = new ArrayList<>();
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cod);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer numero = rs.getInt("numero");
				String codEquip = rs.getString("codigo_equipo"); 
				String nombre = rs.getString("nombre");
				Date date = rs.getDate("nacimiento");
				LocalDate fecha = date.toLocalDate();
				Jugador jugador = new Jugador(); 
				jugador.setCodEquipo(codEquip);
				jugador.setFechaNacimiento(fecha);
				jugador.setNombre(nombre);
				jugador.setNumero(numero);
				jugadores.add(jugador);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return jugadores; 
	}
	
	public Equipo consultarEquipoCompleto(String cod) throws NotFoundException, EquipoServiceException {
		String sql = "SELECT * FROM EQUIPO WHERE CODIGO = ?"; 
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			List<Jugador> jugadores = consultarJugadoresEquipo(cod);
			stmt.setString(1, cod);
			ResultSet rs = stmt.executeQuery(sql);
			Equipo equipo = null;
			while(rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");

				equipo = new Equipo();

				equipo.setCodigo(codigo);
				equipo.setNombre(nombre);
				equipo.setJugadores(jugadores);
			}
			
			if (equipo.equals(null)) {
				throw new NotFoundException(); 
			}
			
			return equipo;
		} catch (SQLException e) {
			throw new EquipoServiceException(e.getMessage());
		}
		
	}

}
