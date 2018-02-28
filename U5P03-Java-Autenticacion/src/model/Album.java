package model;

import java.sql.Date;

public class Album {

	@Override
	public String toString() {
		return "Album [ID_ALBUM=" + ID_ALBUM + ", ID_AUTOR=" + ID_AUTOR + ", NUM_CANCIONES=" + NUM_CANCIONES
				+ ", NOMBRE=" + NOMBRE + ", PORTADA=" + PORTADA + ", FECHA=" + FECHA + "]";
	}

	private int ID_ALBUM, ID_AUTOR, NUM_CANCIONES;

	public int getNUM_CANCIONES() {
		return NUM_CANCIONES;
	}

	public void setNUM_CANCIONES(int nUM_CANCIONES) {
		NUM_CANCIONES = nUM_CANCIONES;
	}

	public String getPORTADA() {
		return PORTADA;
	}

	public void setPORTADA(String pORTADA) {
		PORTADA = pORTADA;
	}

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}

	private String NOMBRE, PORTADA;
	private Date FECHA;

	public int getID_ALBUM() {
		return ID_ALBUM;
	}

	public void setID_ALBUM(int iD_ALBUM) {
		ID_ALBUM = iD_ALBUM;
	}

	public Album(int iD_ALBUM, int iD_AUTOR, int nUM_CANCIONES, String nOMBRE, String pORTADA, Date fECHA) {
		super();
		ID_ALBUM = iD_ALBUM;
		ID_AUTOR = iD_AUTOR;
		NUM_CANCIONES = nUM_CANCIONES;
		NOMBRE = nOMBRE;
		PORTADA = pORTADA;
		FECHA = fECHA;
	}

	public int getID_AUTOR() {
		return ID_AUTOR;
	}

	public void setID_AUTOR(int iD_AUTOR) {
		ID_AUTOR = iD_AUTOR;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

}
