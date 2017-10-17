package figuras;


public class Triangulo  extends Figura{
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

	public Triangulo(String titulo, Clor color, double base, double altura) {
		super(titulo, color);
		this.base = base;
		this.altura = altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	
	

	@Override
	public String toString() {
		return super.toString() + " [base=" + base + ", altura=" + altura + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

	@Override
	public double area() {
		return altura * base / 2;
	}

	@Override
	public double perimetro() {
		double a, b, raiz;
		a = altura;
		b = base;
		raiz = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

		return a + b + raiz;
	}

}
