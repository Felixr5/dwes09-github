package controlDeFlujo;

import java.util.Scanner;

public class Calendario {
	// Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es
	// bisiesto (sí o no). Escribir su número de días. Si los datos no están bien
	// introducidos se volverán a pedir. Utilizar estructura switch.

	public static void cal() {
		int mes;
		String bisiesto;
		mes = comprobarMes();
		bisiesto = comprobarBis();

		switch (mes) {
		case 1:
			System.out.println("Enero tiene 31 días");
			break;

		case 2:
			if (bisiesto.equals("si"))
				System.out.println("Febrero tiene 29 días");
			else
				System.out.println("Febrero tiene 28 días.");
			break;

		case 3:
			System.out.println("Marzo tiene 31 días");
			break;

		case 4:
			System.out.println("Abril tiene 30 días");
			break;

		case 5:
			System.out.println("Mayo tiene 31 días");
			break;

		case 6:
			System.out.println("Junio tiene 30 días");
			break;

		case 7:
			System.out.println("Julio tiene 31 días");
			break;
		case 8:
			System.out.println("Agosto tiene 31 días");
			break;

		case 9:
			System.out.println("Septiembre tiene 30 días");
			break;

		case 10:
			System.out.println("Octubre tiene 31 días");
			break;

		case 11:
			System.out.println("Noviembre tiene 30 días");
			break;

		case 12:
			System.out.println("Diciembre tiene 31 días");
			break;

		}

	}

	private static int comprobarMes() {
		int valor = -1;
		Scanner sc = new Scanner(System.in);
		while (valor < 1 || valor > 12)
			try {
				System.out.println("¿Qué mes es? (1-12)");

				valor = sc.nextInt();

			} catch (Exception e) {

				System.out.println("No es un numero");
				sc = new Scanner(System.in);

			}
		return valor;
	}

	private static String comprobarBis() {
		Scanner scan = new Scanner(System.in);
		String valor="si";
		do {

			System.out.println("Introduce \"sí\" si es un año bisiesto o \"no\" si no lo es.");
			valor = scan.next();			
		}while(!(valor.equalsIgnoreCase("si") || valor.equalsIgnoreCase("no")));

		scan.close();
		return valor;
	}
}
