package controlDeFlujo;

import java.util.Scanner;

public class Loops {
	// Pedir al usuario un número entero y calcular el factorial de dicho número
	// usando la estructura “do-while”. Repetir el ejercicio usando la estructura
	// “while”, y repetirlo una vez más usando la estructura “for”.

	private static int numero() {
		Scanner sc = new Scanner(System.in);
		int num=Integer.MAX_VALUE;

		do {

		try {

			System.out.println("Introduce un numero.");
			num = sc.nextInt();
		} catch (Exception e) {
			sc = new Scanner(System.in);		
		}
		} while (num==Integer.MAX_VALUE);
						return num;


	}

	public static void Do_while() {
		int num = numero();
		int c = 1;
		int fac = num;
		do {
			fac *= c;
			c += 1;
		} while (c < num);

		System.out.println("El factorial de " + num + " es " + fac);
	}

	public static void While() {
		int num = numero();
		int c = 1;
		int fac = num;
		while (c < num) {
			fac *= c;
			c += 1;
		}
		System.out.println("El factorial de " + num + " es " + fac);

	}

	public static void For() {
		int num = numero();

		int fac = num;

		for (int i = 1; i < num; i++)
			fac *= i;

		System.out.println("El factorial de " + num + " es " + fac);

	}
}
