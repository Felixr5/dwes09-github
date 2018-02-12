package figuras;

public class Elipse extends Figura {

	public Elipse() {
		// TODO Auto-generated constructor stub
	}

	public Elipse(double radioA, double radioB) {
		super();
		this.radioA = radioA;
		this.radioB = radioB;
	}

	public double getRadioA() {
		return radioA;
	}

	public void setRadioA(double radioA) {
		this.radioA = radioA;
	}

	public double getRadioB() {
		return radioB;
	}

	public void setRadioB(double radioB) {
		this.radioB = radioB;
	}

	public Elipse(double radioA, double radioB, Color color) {
		super.setColor(color);
		this.radioA = radioA;
		this.radioB = radioB;
	}

	private double radioA, radioB;

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 2*Math.PI*Math.sqrt(((Math.pow(radioA, 2)+Math.pow(radioB, 2))/2));
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.PI*radioA*radioB;
	}

	@Override
	public String toString() {
		return "Elipse [radioA=" + radioA + ", radioB=" + radioB + ", calcularPerimetro()=" + calcularPerimetro()
				+ ", calcularArea()=" + calcularArea() + ", toString()=" + super.toString() + "]";
	}

}
