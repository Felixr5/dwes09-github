package model;

public class Usuario {
	private String login, password, nombre, descripción;
	private boolean administrador;

	public Usuario(String login, String password, String nombre, String descripción, boolean administrador) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.descripción = descripción;
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", nombre=" + nombre + ", descripción="
				+ descripción + ", administrador=" + administrador + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
}
