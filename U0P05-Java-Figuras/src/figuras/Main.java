package figuras;

import figuras.Figura.Clor;

public class Main {
	public static void main(String[] args) {
		Cuadrado cuad = new Cuadrado("Cuadrado", Clor.AMARILLO, 4.2);
		Circunferencia circ2 = new Circunferencia("circ2", Clor.VERDE, 1.5);

		GestorFiguras gestor = new GestorFiguras();

		gestor.anyadirFig(cuad);
		gestor.anyadirFig(circ2);
		gestor.mostrarFiguras(); 
		gestor.anyadirFig(cuad);
		gestor.borrarFigura("Cuadrado");
		gestor.sumaAreas();

	}
}
