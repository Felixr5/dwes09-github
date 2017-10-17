package figuras;

public abstract class Figura {
	
	public enum Clor {
		AZUL, VERDE, AMARILLO, ROJO
	};
	Clor color;
	private String titulo;

	public abstract double area();

	public abstract double perimetro();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Figura(String titulo, Clor color) {
		this.titulo = titulo;
		this.color=color;
	}

	@Override
	public String toString() {
		return "Figura [color=" + color + ", titulo=" + titulo + "]";
	}

}
