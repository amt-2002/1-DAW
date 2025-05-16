package examen.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import examen.modelo.Libro;

public class LibreriaService {
	
	private OpenConnection openConn;

	public LibreriaService() {
		super();
		this.openConn = new OpenConnection();
	}
	
	
	public void insertarLibroNuevo(Libro libro) throws LibroException {
		String sql = "INSERT INTO LIBROS VALUES (?, ?, ?, ?)";
		
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, libro.getISBN());
			stmt.setString(2, libro.getTitulo());
			stmt.setString(3, libro.getAutor());
			stmt.setBigDecimal(4, libro.getPrecio());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new LibroException("Fallo al guardar en la base de datos");
		}
	}
	
	
	public Boolean actualizarPrecioLibroNuevo(Libro libro) throws LibroException {
		String sql = "UPDATE LIBROS SET PRECIO = ? WHERE ISBN = ?"; 
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setBigDecimal(1, libro.getPrecio());
			stmt.setString(2, libro.getISBN());
			Integer result = stmt.executeUpdate();
			if (result >= 1) {
				return true; 
			}
			return false; 
		} catch (SQLException e) {
			throw new LibroException("Fallo al guardar en la base de datos");
		}
	}
	
	

}
