package figuras;

import java.util.ArrayList;

public class GestorFiguras {

	private ArrayList<Figura> listaFiguras;

	public GestorFiguras() {
		listaFiguras = new ArrayList<>();
	}
	
	private Figura comprobarnombre(String nombre) {
		for (Figura figura : listaFiguras)
			if (figura.getTitulo().equals(nombre))
				return figura;

		return null;

	}

	public void anyadirFig(Figura figura) {

		if (comprobarnombre(figura.getTitulo()) == null)
			listaFiguras.add(figura);
		else
			System.out.println("No se ha podido añadir porque ya existia ese titulo.");
	}

	
	public void borrarFigura (String titulo) {
		if (comprobarnombre(titulo)!=null) 
			listaFiguras.remove(comprobarnombre(titulo));
			else
			System.out.println("No existia ese titulo por lo que no se ha borrado.");
			}
	
	public void mostrarFiguras () {
		for (Figura figura : listaFiguras) 
			System.out.println(figura.toString());
		
	}
	
		
		public void sumaAreas() {
			double total=0;
		
			for (Figura figura : listaFiguras) 
				total+=figura.area();
			
			
			System.out.println("La suma de todas las areas es "+total);
			
		}
	

}
