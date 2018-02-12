package figuras;

public class Rectangulo extends Figura {

	public Rectangulo() {
		// TODO Auto-generated constructor stub
	}
	
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public Rectangulo(double ancho, double largo, Color color) {
		super.setColor(color);
		this.ancho = ancho;
		this.largo = largo;
	}

	private double ancho, largo;
	
	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return ancho*2+largo*2;
	}

	@Override
	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", largo=" + largo + ", calcularPerimetro()=" + calcularPerimetro()
				+ ", calcularArea()=" + calcularArea() + ", toString()=" + super.toString() + "]";
	}

	public Rectangulo(double ancho, double largo) {
		super();
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return largo*ancho;
	}

}
