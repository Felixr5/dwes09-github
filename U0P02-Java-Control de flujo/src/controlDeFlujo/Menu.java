package controlDeFlujo;
//as
import java.util.Scanner;

public class Menu {

	public static void menu0() {
		Scanner sc = new Scanner(System.in);

		int opcion;
		try {
			do {
				System.out.println("Introduce una opcion del 1 al 4.\n"
						+ "1.-A \n" 
						+ "2.-B \n" 
						+ "3.-C \n" 
						+ "4.- Salir \n");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:

					menu1();

				case 2:
					menu2();

					break;

				case 3:
					menu3();

					break;

			
				}

			} while (opcion < 1 || opcion > 4);
		} catch (Exception e) {
			sc = new Scanner(System.in);
			menu0();
		}

	}

	private static void menu1() {
		Scanner sc = new Scanner(System.in);

		int opcion;
		try {

			do {

				System.out.println("Introduce una opcion del 1 al 4.\n" 
						+ "1.-a \n" 
						+ "2.-b \n" 
						+ "3.-c \n" 
						+ "4.- Volver \n");
				opcion = sc.nextInt();
			} while (opcion < 1 || opcion > 4);

			switch (opcion) {
			case 1:
				System.out.println("Aa");
				break;

			case 2:
				System.out.println("Ab");

				break;

			case 3:
				System.out.println("Ac");

				break;

			case 4:
				menu0();
				break;

			}

		} catch (Exception e) {
			sc = new Scanner(System.in);
		}

	}

	private static void menu2() {
		Scanner sc = new Scanner(System.in);

		int opcion;
		try {

			do {

				System.out.println("Introduce una opcion del 1 al 4. \n" 
						+ "1.-a \n" 
						+ "2.-b \n" 
						+ "3.-c \n" 
						+ "4.- Volver\n");
				opcion = sc.nextInt();
			} while (opcion < 1 || opcion > 4);

			switch (opcion) {
			case 1:
				System.out.println("Ba");
				break;

			case 2:
				System.out.println("Bb");

				break;

			case 3:
				System.out.println("Bc");

				break;

			case 4:
				menu0();
				break;

			}

		} catch (Exception e) {
			sc = new Scanner(System.in);
		}

	}

	private static void menu3() {
		Scanner sc = new Scanner(System.in);

		int opcion;
		try {

			do {

				System.out.println("Introduce una opcion del 1 al 4.\n" 
						+ "1.-a \n" 
						+ "2.-b \n" 
						+ "3.-c \n" 
						+ "4.- Volver\n");
				opcion = sc.nextInt();
			} while (opcion < 1 || opcion > 4);

			switch (opcion) {
			case 1:
				System.out.println("Ca");
				break;

			case 2:
				System.out.println("Cb");

				break;

			case 3:
				System.out.println("Cc");

				break;

			case 4:
				menu0();
				break;

			}

		} catch (Exception e) {
			sc = new Scanner(System.in);
		}

	}

}
