
package controlDeFlujo;

import java.util.Scanner;

public class Cadenas {
	public static void cadena() {

		Scanner sc = new Scanner(System.in);
		String cadena;
		String total = "";
		System.out.println("Introduce 5 cadenas");
		for (int i = 0; i < 5; i++) {
			cadena = sc.nextLine();
			total = total.concat(cadena);
		}
		sc.close();

		System.out.println("La cadena final es \n" + total);
	}

}
