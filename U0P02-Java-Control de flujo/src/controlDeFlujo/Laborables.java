package controlDeFlujo;

import java.util.Scanner;

public class Laborables {

	public static void diaSemana () {
		Scanner sc = new Scanner(System.in);



		System.out.println("Introduzca un dia de la semana");
		String dia = sc.next();
		sc.close();
		switch (dia.toLowerCase()) {

		case "lunes":
			System.out.println("El " + dia + " es laborable");
			break;

		case "martes":
			System.out.println("El " + dia + " es laborable");
			break;

		case "miercoles":
			System.out.println("El " + dia + " es laborable");
			break;

		case "jueves":
			System.out.println("El " + dia + " es laborable");
			break;

		case "viernes":
			System.out.println("El " + dia + " es laborable");
			break;

		case "sabado":
			System.out.println("El " + dia + " es no laborable");
			break;

		case "domingo":
			System.out.println("El " + dia + " es no laborable");
			break;
		}

	}

}