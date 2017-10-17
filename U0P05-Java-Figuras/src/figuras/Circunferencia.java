package figuras;


public class Circunferencia  extends Figura{
	private double radio;
	private double perimetro, area;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}



	public Circunferencia(String titulo, Clor color, double radio) {
		super(titulo, color);
		this.radio = radio;

	}

	@Override
	public String toString() {
		return super.toString() + " [radio=" + radio + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double perimetro() {
		return (2 * Math.PI * radio);
	}
	
	
	

}
