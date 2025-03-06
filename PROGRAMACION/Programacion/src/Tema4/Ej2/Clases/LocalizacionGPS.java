package Tema4.Ej2.Clases;

public class LocalizacionGPS {
	private Integer latitud;
	private Integer longitud;

	public LocalizacionGPS(Integer latitud, Integer longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Integer getLatitud() {
		return latitud;
	}

	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

}
