package Tema6.Ej1Repaso.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tema6.Ej1Repaso.modelo.ProductoGourmet;

public class ProductosService {

	
	private OpenConnection openConn;

	public ProductosService() {
		openConn = new OpenConnection();
	}
	
	
	public void insertarProducto(ProductoGourmet p) throws SQLException, ProductoInvalidoException {
		
		if (p.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ProductoInvalidoException("No puede ser menor o igual a 0"); 
		}
		
		String sql = "INSERT INTO productos_gourmet VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getTipo());
			stmt.setBigDecimal(4, p.getPrecio());
			stmt.setBoolean(5, p.getDisponible());
			stmt.executeUpdate();
			System.out.println("Producto ingresado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo al ingresar el producto");
		}
	}
	
	public void insertarProductos(List<ProductoGourmet> productos) throws SQLException {
		String sql = "INSERT INTO productos_gourmet VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			try {
				for (ProductoGourmet prod : productos) {
					stmt.setInt(1, prod.getId());
					stmt.setString(2, prod.getNombre());
					stmt.setString(3, prod.getTipo());
					stmt.setBigDecimal(4, prod.getPrecio());
					stmt.setBoolean(5, prod.getDisponible());
					stmt.execute();
				}
			} catch (SQLException a) {
				System.out.println("Error al introducir el usuario");
				conn.rollback();
			}
			conn.commit();
			System.out.println("Todo correcto");
		}
	}
	
	public List<ProductoGourmet> consultarTipoProductos(String tipoR) throws SQLException, ProductoNoEncontradoException {
		String sql = "SELECT * FROM productos_gourmet WHERE tipo = ?";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			List<ProductoGourmet> productos = new ArrayList<>(); 
			
			stmt.setString(1, tipoR);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt("id"); 
				String nombre = rs.getString("nombre"); 
				String tipo = rs.getString("tipo");
				BigDecimal precio = rs.getBigDecimal("precio"); 
				Boolean dispo = rs.getBoolean("disponible"); 
				
				ProductoGourmet producto = new ProductoGourmet(id, nombre, tipo, precio, dispo);
				productos.add(producto); 
			}
			
			if (productos.isEmpty()) {
				throw new ProductoNoEncontradoException("No existe ningun producto con ese tipo"); 
			}
			
			return productos;
		}
	}
	
	public void eliminaProducto(Integer id) throws SQLException, ProductoNoEncontradoException {
		String sql = "DELETE FROM productos_gourmet WHERE id = ?"; 
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			Integer result = stmt.executeUpdate();
			
			if (result == 0) {
				throw new ProductoNoEncontradoException("No hay ningun producto con esa id"); 
			}
		}
	}
	
	
	public Map<Integer, ProductoGourmet> consultarProductosDisponibles() throws SQLException {
		String sql = "SELECT * FROM productos_gourmet WHERE disponible = 1"; 
		
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	
			ResultSet rs = stmt.executeQuery(); 
			Map<Integer, ProductoGourmet> productos = new HashMap<>();
			
			while(rs.next()) {
				Integer id = rs.getInt("id"); 
				String nombre = rs.getString("nombre"); 
				String tipo = rs.getString("tipo");
				BigDecimal precio = rs.getBigDecimal("precio"); 
				Boolean dispo = rs.getBoolean("disponible"); 
				
				ProductoGourmet producto = new ProductoGourmet(id, nombre, tipo, precio, dispo);
				productos.put(id, producto);
			}
			
			return productos; 
			
		}
		
	}
	
	
 

}
