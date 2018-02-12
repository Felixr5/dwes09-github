package figuras;

import java.util.ArrayList;
import java.util.Collections;


public class GestionFiguras  {
	
	ArrayList <Figura> figuras ;
	private double sum=0;
	private boolean eliminada=false;
	public GestionFiguras() {
		figuras= new ArrayList<Figura>();
	}
	
	
	public void añadirFiguras(Figura f) {
		figuras.add(f);
	}

	public void borrarFiguras(String titulo) {
		for(int i=0;i<figuras.size();i++) {
			if(figuras.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				figuras.remove(i);
				eliminada=true;
			}
		}
		if(eliminada) {
			System.out.println("La figura ha sido eliminada");
		}else {
			System.out.println("La figura no ha sido eliminada, no existia.");
		}
	}
	
	public void mostrarFiguras() {
		Collections.sort(figuras);
		for(Figura a:figuras) {
			System.out.println(a.toString());
		}
	}

	public void calcularSumatorioAreas() {
		for(Figura a:figuras) {
			sum+=a.calcularArea();
		}
		System.out.println("La suma de las areas es "+sum);
		sum=0;
	}
	
}