package figuras;

import figuras.Figura.Clor;

public class Problema {

	public static void main(String[] args) {

		Cuadrado cuad = new Cuadrado("Cuadrado", Clor.AMARILLO, 4.2);
		Circunferencia circ1 = new Circunferencia("circ1", Clor.AZUL, 4.8);
		Circunferencia circ2 = new Circunferencia("circ2", Clor.VERDE, 1.5);
		Triangulo tri = new Triangulo("Triangulo", Clor.ROJO, 8, 15);

		double areaTotal, perTotal;
		areaTotal = cuad.area() + (circ1.area() / 2) + (circ2.area() * 0.75) + tri.area();
		perTotal = (cuad.perimetro() * 0.75) + (circ1.perimetro() / 2) + (circ2.perimetro() * 0.75)
				+ (tri.perimetro() - circ2.getRadio() * 2);

		

		System.out.println(cuad.toString());
		System.out.println(circ1.toString());
		System.out.println(circ2.toString());
		System.out.println(tri.toString());

		System.out.println("Area total: " + areaTotal);
		System.out.println("Perimetro total: " + perTotal);

	}

}
