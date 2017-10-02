package figuras;

public class Triangulo {
	private double base, altura;
	private double perimetro, area;

	public double getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
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

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

}
