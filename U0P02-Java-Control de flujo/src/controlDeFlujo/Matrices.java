package controlDeFlujo;

public class Matrices {
	public static void main(String[] args) {
//		Haz una tabla de 10x10 con numeros enteros entre 1 y 9 de forma aleatoria.
//		Suma filas y columnas por separado visualizando los  resultados por pantalla.
	
		
		int sumafilas=0,sumacolumnas=0;
		int [][] matriz = new int [10][10];

		for (int i=0; i<matriz.length; i++){
			for (int j=0; j<matriz[i].length; j++){
				matriz [i][j]=(int)(Math.random() * 9 + 1);
			}
		}		
		for (int i=0; i<matriz.length; i++){
			System.out.println();
			for (int j=0; j<matriz[i].length; j++){
				sumafilas+=matriz[i][j];
			}
			System.out.println("La suma de la fila "+ (i+1) +" es "+ sumafilas);
			sumafilas=0;
		}
		
		System.out.println();

		for (int i=0; i<matriz.length; i++){
			System.out.println();
			for (int j=0; j<matriz[i].length; j++){
				sumacolumnas+=matriz[j][i];
			}
			System.out.println("La suma de la columna "+ (i+1) +" es "+ sumacolumnas);
			sumacolumnas=0;
		}
	
		
	}
}
