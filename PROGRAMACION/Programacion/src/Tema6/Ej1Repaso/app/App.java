package Tema6.Ej1Repaso.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Tema6.Ej1Repaso.modelo.ProductoGourmet;
import Tema6.Ej1Repaso.services.ProductoNoEncontradoException;
import Tema6.Ej1Repaso.services.ProductosService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sca = new Scanner(System.in); 
		
		List<ProductoGourmet> productos = new ArrayList<>(); 
		ProductosService srv = new ProductosService();
		
		
	/*	while(productos.size() < 3) { 
			System.out.println("Indica la ID del producto");
			Integer id = sca.nextInt();
			sca.nextLine(); // clear buffer
			System.out.println("Indica el NOMBRE del producto");
			String nombre = sca.nextLine();
			System.out.println("Indica el TIPO del producto");
			String tipo = sca.nextLine();
			System.out.println("Indica el PRECIO del producto");
			BigDecimal precio = new BigDecimal(sca.nextDouble());
			precio = precio.setScale(2, RoundingMode.HALF_DOWN); 
			System.out.println("Indica si esta DISPONIBLE o no"); 
			Boolean dispo = sca.nextBoolean(); 
			
			ProductoGourmet producto = new ProductoGourmet(id, nombre, tipo, precio, dispo); 
			productos.add(producto); 
			System.out.println();
			System.out.println("Producto añadido correctamente");
			System.out.println();
		}
		
		
		try {
			srv.insertarProductos(productos);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		*/
		try {
			BigDecimal pTotal = BigDecimal.ZERO;
			List<ProductoGourmet> productosRec = srv.consultarTipoProductos("verdura");
			System.out.println("*** PRODUCTOS DE TIPO ‘VERDURA’ ***");
			for (ProductoGourmet productoGourmet : productosRec) {
				System.out.println(productoGourmet);
				pTotal = pTotal.add(productoGourmet.getPrecio());
			}
			System.out.println("TOTAL DE PRODUCTOS DE TIPO ‘VERDURA’: " + pTotal + " €");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProductoNoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		sca.close();
		
	}

}
