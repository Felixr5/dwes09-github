package figuras;

public class Problema {

	public static void main(String[] args) {

		Cuadrado cuad = new Cuadrado(4.2);
		Circunferencia circ1 = new Circunferencia(4.8);
		Circunferencia circ2 = new Circunferencia(1.5);
		Triangulo tri = new Triangulo(8, 15);

		cuad.setArea(Math.pow(cuad.getLado(), 2));
		cuad.setPerimetro(cuad.getLado() * 4);

		circ1.setArea(Math.PI * Math.pow(circ1.getRadio(), 2));
		circ1.setPerimetro(2 * Math.PI * circ1.getRadio());
		circ2.setArea(Math.PI * Math.pow(circ2.getRadio(), 2));
		circ2.setPerimetro(2 * Math.PI * circ2.getRadio());
		tri.setArea((tri.getAltura() * tri.getBase()) / 2);

		double a, b, raiz;
		a = tri.getAltura();
		b = tri.getBase();
		raiz = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		tri.setPerimetro(a + b + raiz);

		double areaTotal, perTotal;
		areaTotal = cuad.getArea() + (circ1.getArea() / 2) + (circ2.getArea() * 0.75) + tri.getArea();
		perTotal = (cuad.getPerimetro() * 0.75) + (circ1.getPerimetro() / 2) + (circ2.getPerimetro() * 0.75)
				+ (tri.getPerimetro() - circ2.getRadio() * 2);

		System.out.println(cuad.toString());
		System.out.println(circ1.toString());
		System.out.println(circ2.toString());
		System.out.println(tri.toString());

		System.out.println("Area total: " + areaTotal);
		System.out.println("Perimetro total: " + perTotal);

	}

}
