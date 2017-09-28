package controlDeFlujo;

import java.util.Scanner;

public class Incrementar {
	// Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de
	// ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e
	// incrementar en una unidad el número menor.

	public static void numeros() {
		Scanner sc = new Scanner(System.in);
		int a, b;
		do {
			a= Integer.MAX_VALUE;
				 b = Integer.MAX_VALUE;
			try {
				
				if (a < 1 || a > 10)
					System.out.println("Introduce el primer numero (1-10).");
				a = sc.nextInt();

				if (b < 1 || b > 10)
					System.out.println("Introduce el segundo numero (1-10).");
				b = sc.nextInt();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("No se ha introducido un numero.");
				sc = new Scanner(System.in);
			}
		} while ((a < 1 || a > 10) || (b < 1 || b > 10));
		while (a != b) {

			if (a < b)
				a += 1;
			else
				b += 1;
			System.out.println("*\n a=" + a + "  b=" + b);
		}

	}
}