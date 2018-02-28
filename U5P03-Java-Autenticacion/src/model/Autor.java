package model;

import java.sql.Date;

public class Autor {
	private int ID_AUTOR, A_CREACION;
	private String NOMBRE, NACIONALIDAD, NACIONALIDAD2, FOTO;
	private Date A_NACIMIENTO;

	public int getID_AUTOR() {
		return ID_AUTOR;
	}

	public void setID_AUTOR(int iD_AUTOR) {
		ID_AUTOR = iD_AUTOR;
	}

	public int getA_CREACION() {
		return A_CREACION;
	}

	public void setA_CREACION(int a_CREACION) {
		A_CREACION = a_CREACION;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getNACIONALIDAD() {
		return NACIONALIDAD;
	}

	public void setNACIONALIDAD(String nACIONALIDAD) {
		NACIONALIDAD = nACIONALIDAD;
	}

	public String getNACIONALIDAD2() {
		return NACIONALIDAD2;
	}

	public void setNACIONALIDAD2(String nACIONALIDAD2) {
		NACIONALIDAD2 = nACIONALIDAD2;
	}

	public String getFOTO() {
		return FOTO;
	}

	public void setFOTO(String fOTO) {
		FOTO = fOTO;
	}

	public Date getA_NACIMIENTO() {
		return A_NACIMIENTO;
	}

	public void setA_NACIMIENTO(Date a_NACIMIENTO) {
		A_NACIMIENTO = a_NACIMIENTO;
	}

	@Override
	public String toString() {
		return "Autor [ID_AUTOR=" + ID_AUTOR + ", A_CREACION=" + A_CREACION + ", NOMBRE=" + NOMBRE + ", NACIONALIDAD="
				+ NACIONALIDAD + ", NACIONALIDAD2=" + NACIONALIDAD2 + ", FOTO=" + FOTO + ", A_NACIMIENTO="
				+ A_NACIMIENTO + "]";
	}

	public Autor(int iD_AUTOR, int a_CREACION, String nOMBRE, String nACIONALIDAD, String nACIONALIDAD2, String fOTO,
			Date a_NACIMIENTO) {
		super();
		ID_AUTOR = iD_AUTOR;
		A_CREACION = a_CREACION;
		NOMBRE = nOMBRE;
		NACIONALIDAD = nACIONALIDAD;
		NACIONALIDAD2 = nACIONALIDAD2;
		FOTO = fOTO;
		A_NACIMIENTO = a_NACIMIENTO;
	}

}
