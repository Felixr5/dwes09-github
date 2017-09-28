package controlDeFlujo;

import java.util.Scanner;

public class Numeros {

	public static void pedirNum1_10() {
		Scanner sc = new Scanner(System.in);
		int numero = -1;
		
		while ((numero < 1 || numero > 10))
			try {
				System.out.println("Introduce un numero del 1 al 10");
				numero = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\nEl numero no estaba entre los valores 1 y 10.");
				sc = new Scanner(System.in);
				numero = -1;
			}

		System.out.println("\nEl numero " + numero + " es valido.");

		sc.close();
	}

	public static void pedirNumNoLetra() {
		Scanner sc = new Scanner(System.in);
		int numero=0;
		boolean nu = false;
		while (!nu)
			try {
				System.out.println("Introduce un numero.");
				numero = sc.nextInt();
				nu = true;

			} catch (Exception e) {
				System.out.println("El valor introducido no era un numero.");
				sc = new Scanner(System.in);
			}

		System.out.println("El numero " + numero + " es valido.");

		sc.close();
	}
}
