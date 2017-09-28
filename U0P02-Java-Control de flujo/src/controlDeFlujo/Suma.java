package controlDeFlujo;

import java.util.Scanner;

public class Suma {

	public static void SumaNums() {

		Scanner sc = new Scanner(System.in);
		int numero, total = 0;

		do {
			System.out.println("Introduce un numero hasta llegar a un minimo de 50 (Actualmente " + total + ")");
			numero = sc.nextInt();
			total += numero;
		} while (total < 50);
		System.out.println("El total es " + total);
		sc.close();
	}

}
