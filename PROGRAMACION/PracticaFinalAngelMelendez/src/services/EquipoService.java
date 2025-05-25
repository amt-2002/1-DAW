package services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Tema6.Ej1Repaso.modelo.ProductoGourmet;
import modelo.Equipo;
import modelo.Jugador;

public class EquipoService {

	private OpenConnection openConn;

	public EquipoService() {
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
			while (rs.next()) {
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

	public void insertarJugador(Jugador jugador) {
		String sql = "INSERT INTO PERSONAS VALUES (?, ?, ?, ?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, jugador.getNumero());
			stmt.setString(2, jugador.getCodEquipo());
			stmt.setString(3, jugador.getNombre());
			stmt.setDate(4, Date.valueOf(jugador.getFechaNacimiento()));
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void crearEquipo(Equipo equipo) throws EquipoServiceException {
		String sql = "INSERT INTO EQUIPO VALUES (?, ?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			try {
				stmt.setString(1, equipo.getCodigo());
				stmt.setString(2, equipo.getNombre());
				List<Jugador> jugadores = equipo.getJugadores();

				for (Jugador jugador : jugadores) {
					jugador.setCodEquipo(equipo.getCodigo());
					;
					insertarJugador(jugador);
				}

			} catch (SQLException a) {
				conn.rollback();
				throw a; 
			} finally {
				conn.setAutoCommit(true);
			}
			conn.commit();
		} catch (SQLException e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}

	public void borrarEquipoCompleto(String codigo) throws NotFoundException, EquipoServiceException {

		String sqlJugadores = "DELETE FROM jugadores WHERE codigo_equipo = ?";
		try (Connection conn = openConn.getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlJugadores)) {
			conn.setAutoCommit(false);
			try {
				stmt.setString(1, codigo);
				stmt.executeUpdate();
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e; 
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e1) {
			throw new EquipoServiceException(e1.getMessage());
		}

		String sqlEquipo = "DELETE FROM equipos WHERE codigo = ?";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sqlEquipo)) {
			conn.setAutoCommit(false);
			try {
				stmt.setString(1, codigo);
				int affectedRows = stmt.executeUpdate();
				if (affectedRows == 0) {
					throw new NotFoundException("Equipo no encontrado");
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e1) {
			throw new EquipoServiceException(e1.getMessage());
		}

	}

	public void añadirJugadorAEquipo(Jugador jugador) throws EquipoServiceException {

		String sql = "INSERT INTO jugadores (numero, codigo_equipo, nombre, fecha_nacimiento) VALUES (?, ?, ?, ?)";

		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, jugador.getNumero());
			stmt.setString(2, jugador.getCodEquipo());
			stmt.setString(3, jugador.getNombre());
			stmt.setDate(4, Date.valueOf(jugador.getFechaNacimiento()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new EquipoServiceException("Error al añadir jugador: " + e.getMessage());
		}
		
	}
	
    public void exportarJugadores(String codigo, String ruta) throws EquipoServiceException, NotFoundException {
        try {
            List<Jugador> jugadores = consultarJugadoresEquipo(codigo);
            if (jugadores.isEmpty()) throw new NotFoundException("Equipo sin jugadores");
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
                for (Jugador j : jugadores) {
                    writer.println(j.getNumero() + " - " + j.getNombre() + " - " 
                        + j.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            }
        } catch (IOException e) {
            throw new EquipoServiceException("Error al exportar: " + e.getMessage());
        }
    }

}
