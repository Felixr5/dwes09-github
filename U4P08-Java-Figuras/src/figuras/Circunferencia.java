package figuras;

public class Circunferencia extends Figura {

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", calcularPerimetro()=" + calcularPerimetro() + ", calcularArea()="
				+ calcularArea() + ", toString()=" + super.toString() + "]";
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Circunferencia(double radio) {
		super();
		this.radio = radio;
	}

	public Circunferencia() {
		// TODO Auto-generated constructor stub
	}

	private double radio;
	
	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Circunferencia(double radio, Color color) {
		super.setColor(color);
		this.radio = radio;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
