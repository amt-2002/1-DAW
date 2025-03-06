package Tema4.Ej2.Clases;

public class Movil extends Telefono {
	private LocalizacionGPS gps;

	public Movil(Integer tel, LocalizacionGPS gps) {
		super(tel);
		this.gps = gps;
	} 
	
	
}
