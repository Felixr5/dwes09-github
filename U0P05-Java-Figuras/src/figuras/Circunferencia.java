package figuras;

public class Circunferencia {
	private double radio;
	private double perimetro, area;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Circunferencia(double radio) {
		this.radio = radio;

	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

}
