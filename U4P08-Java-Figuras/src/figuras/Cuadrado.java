package figuras;

public class Cuadrado extends Figura {

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", calcularPerimetro()=" + calcularPerimetro() + ", calcularArea()="
				+ calcularArea() + ", toString()=" + super.toString() + "]";
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public Cuadrado(double lado, Color color) {
		super.setColor(color);
		this.lado = lado;
	}

	public Cuadrado() {
		// TODO Auto-generated constructor stub
	}
	
	private double lado;
	
	
	@Override
	public double calcularPerimetro() {
		return lado*4;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.pow(lado, 2);
	}

}
