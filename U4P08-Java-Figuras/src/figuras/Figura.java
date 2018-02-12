package figuras;


public abstract class Figura  implements Comparable<Figura>{

	private String titulo ;
	private Color color ;
	
	
	abstract public double calcularPerimetro();
	
	abstract public double calcularArea();
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Figura [titulo=" + titulo + ", color=" + color + "]";
	}
	
	public int compareTo(Figura o) {
		return this.getTitulo().compareTo(o.getTitulo());
		
	}

}