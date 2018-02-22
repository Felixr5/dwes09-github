package model;

public class Cancion {

	private int ID_CANCION, ID_ALBUM, ID_AUTOR;
	private String NOMBRE;
	private float DURACION;
	public int getID_CANCION() {
		return ID_CANCION;
	}
	public void setID_CANCION(int iD_CANCION) {
		ID_CANCION = iD_CANCION;
	}
	public int getID_ALBUM() {
		return ID_ALBUM;
	}
	public void setID_ALBUM(int iD_ALBUM) {
		ID_ALBUM = iD_ALBUM;
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
	public float getDURACION() {
		return DURACION;
	}
	public void setDURACION(float dURACION) {
		DURACION = dURACION;
	}
	public Cancion(int iD_CANCION, int iD_ALBUM, int iD_AUTOR, String nOMBRE, float dURACION) {
		super();
		ID_CANCION = iD_CANCION;
		ID_ALBUM = iD_ALBUM;
		ID_AUTOR = iD_AUTOR;
		NOMBRE = nOMBRE;
		DURACION = dURACION;
	}

}
