package controlDeFlujo;

import java.util.Scanner;

public class Palindroma {
	public static void main(String[] args) {
		// Dada una cadena por teclado, decidir si es palíndroma, es decir si
		// se lee igual de izquierda a derecha que de derecha a izquierda.
		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Introduce la cadena");
		cadena = sc.nextLine().toLowerCase();
		cadena = quitarEspacios(cadena);
		palindroma(cadena);
	}

	static public String quitarEspacios(String cadena) {
		int espacio = -1, aux = -1, c = 0;
		String cadenaAux = cadena;
		for (int i = 0; i < cadena.length() && espacio == -1; i++) {
			c += 1;
			if (cadena.charAt(i) == ' ') {
				espacio = i;
				aux = i;
				cadenaAux = cadena.substring(0, i);
				break;
			}
		}
		do {
			espacio = -1;
			for (int i = aux + 1; i < cadena.length() && espacio == -1; i++) {
				c += 1;
				if (cadena.charAt(i) == ' ') {
					espacio = i;
					cadenaAux += cadena.substring(aux + 1, i);
					aux = i;
					break;
				}
				if (cadena.charAt(i) != ' ' && i == (cadena.length() - 1) && cadena!=cadenaAux) {
					cadenaAux += cadena.substring(aux + 1, c);
					break;
				}
			}
		} while (c < cadena.length());
		return cadenaAux;
	}

	static public void palindroma(String cadena) {
		String cadenaAux = "";
		for (int i = cadena.length()-1; i >= 0; i--) {
			cadenaAux += cadena.charAt(i);
		}
		if (cadena.compareToIgnoreCase(cadenaAux) == 0)
			System.out.println("La cadena introducida es palindroma.");
		else
			System.out.println("La cadena no era palindroma.");
	}

}
