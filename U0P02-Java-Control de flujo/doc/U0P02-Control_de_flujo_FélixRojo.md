###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P02 - Repaso: estructuras de control de flujo
#### Entrega de: *Félix Rojo Archidona*
----
#### 1. Descripción:

Vamos a instalar el Java Develompent Kit (JDK) y el entorno de desarrollo Eclipse. A continuación crearemos un proyecto Java en el que practicaremos las estructuras de control de flujo (tanto de selección como de iteración) a través de diferentes programas.

#### 2. Formato de entrega:

Completa este documento incluyendo tras cada apartado el código necesario para resolver el problema (sin incluir el método `main`, sólo el código correspondiente a la solución) y el resultado de una ejecución.

* Para el código utiliza bloques de código Markdown
* Para el resultado puedes utilizar también bloques, o bien incluir capturas de pantalla de Eclipse

#### 3. Trabajo a realizar:

Antes de comenzar, escribe tu / vuestros nombres en la cabecera de este documento

##### Parte 1: Configuración del espacio de trabajo en la máquina virtual de Windows 

1. Desinstala la versión actual de Java. Recuerda que normalmente cuando decimos que un ordenador "tiene instalado Java" lo que en realidad tiene instalado es el Java Runtime Environment (JRE).
2. Descarga la última versión del [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java 8 Update 144. Localiza la descarga en la web oficial, pero si lo deseas puedes descargar el archivo desde el FTP del instituto. **Utilizaremos esta versión de Java durante todo el curso. Es muy importante que tengas la misma en casa y no la actualices para evitar problemas al compartir proyectos posteriormente**.
3. Desde el menú de inicio, abre el panel de configuración de Java (`Configurar Java`). Recuerda: hablamos del JRE. El JDK no tiene ninguna aplicación gráfica
4. Comprueba que la versión es la esperada haciendo clic en el botón `Acerca de` en la pestaña `General`
5. En la pestaña `Actualizar` desmarca la casilla *Comprobar actualizaciones automáticamente*. Esto garantizará que todos tengamos la misma versión de Java a lo largo del curso.
6. Descarga la última versión de Eclipse, llamada Oxygen. Como más adelante desarrollaremos aplicaciones Java EE, no queremos el paquete básico de instalación: en la [web de descargas de Eclipse](http://www.eclipse.org/downloads/) debes hacer clic en *Download Packages* y escoger la edición para desarrolladores Java EE. Tienes el archivo disponible en el servidor FTP del instituto.
7. Descomprime el archivo de forma que la carpeta llamada `eclipse` (sin la versión) quede donde desees, por ejemplo en la raíz `C:\`
8. Crea un acceso directo al ejecutable de Eclipse en el escritorio y/o en la barra de tareas
9. Ejecuta Eclipse: la primera decisión será la ubicación de la carpeta de espacio de trabajo o *workspace*: puedes dejar la que viene por defecto o escoger otra a tu gusto
10. Inicialmente aparecerá la pantalla de bienvenida: desmarca la casilla para que no vuelva a aparecer en el futuro

#####Parte 2: Creación y organización de un proyecto

1. Crea un nuevo proyecto Java: `File` → `New` → `Project` → `Java Project`. El nombre es importante, puesto que seguiremos la misma nomenclatura durante todo el curso: *Número de práctica - Lenguaje utilizado - Título o descripción*, en este caso: *U0P02-Java-Control de flujo* 
2. Crea desde Eclipse una carpeta `doc` en la raíz del proyecto (junto a la carpeta `src`) y copia en ella el archivo de este enunciado (arrastra el archivo a la carpeta de Eclipse). A lo largo del curso seguiremos este esquema para agrupar cada proyecto con su correspondiente enunciado.
3. Indica que queremos editar los archivos Markdown con Typora: *clic secundario sobre el archivo → Open with → Other → Browse → Localizar el ejecutable de Typora en la carpeta de archivos de programa*. No olvides marcar la casilla para indicar que queremos utilizar este programa para abrir todos los archivos Markdown
4. Comprueba que al hacer doble clic sobre un archivo Markdown en Eclipse, se abre con Typora
5. Crea una clase *HolaMundo* con un código sencillo para probar que tu instalación de Java es correcta y puedes compilar y ejecutar programas en Java. 
6. Recuerda que dispones de plantillas de código para escribir rápidamente sentencias o bloques. Por ejemplo si escribes "sout" y pulsas Ctrl + Espacio, se escribirá `System.out.println();`. También hay plantillas para escribir un bloque if-else, while, try-catch... Consulta las plantillas en `Window` → `Preferences` → `Java` → `Editor` → `Templates`


#####Parte 3: Repaso de Java: estructuras de control de flujo

Crea un paquete llamado `ControlDeFlujo` y codifica en una o varias clases los siguientes programas:

1) Preguntar al usuario el día de la semana e indicar si es laborable o no. Resolver utilizando la estructura `switch`.

- *Código*:

```java
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
```

- *Ejecución*:

        Introduzca un dia de la semana
        martes
        El martes es laborable

2) Pedir al usuario cinco cadenas de texto y generar una sola cadena uniéndolas todas. Escribir esa cadena por pantalla.

- *Código*:

````java
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
````



- *Ejecución*:

  ``` 		
  Introduce 5 cadenas
  a
  b
  c
  d
  e
  La cadena final es 
  abcde
  ```




3) Ir pidiendo por teclado una serie de números enteros e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir por pantalla la suma de todos los números introducidos.

- *Código*:

```java
	public static void SumaNums() {

		Scanner sc = new Scanner(System.in);
		int numero, total = 0;

		do {
			System.out.println("Introduce un numero hasta llegar a un minimo de 50 		(Actualmente " + total + ")");
			numero = sc.nextInt();
			total += numero;
		} while (total < 50);
		System.out.println("El total es " + total);
		sc.close();
	}
```



- *Ejecución*:

```
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 0)
2
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 2)
9
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 11)
14
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 25)
14
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 39)
10
Introduce un numero hasta llegar a un minimo de 50 (Actualmente 49)
20
El total es 69
```



4) Pedir al usuario un número. Si introduce un valor inválido (por ejemplo una letra), se le volverá a solicitar que introduzca el número. 

Cuando termines, añade a continuación una expansión de este problema: pedir al usuario un número entre el 1 y el 10, pidiéndolo de nuevo si lo introduce mal.

Observa que estos dos bloques de código pueden ser reutilizados en cualquier punto de tus futuros programas en el que desees leer un número.


- *Código*:

```java
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
```




- *Ejecución*:

  ````
  Introduce un numero del 1 al 10
  a

  El numero no estaba entre los valores 1 y 10.
  Introduce un numero del 1 al 10
  11
  Introduce un numero del 1 al 10
  10

  El numero 10 es valido.
  ````

  ​

5) Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es bisiesto (sí o no). Escribir su número de días. Si los datos no están bien introducidos se volverán a pedir. Utilizar estructura `switch`.

- *Código*:

```java
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
```

- *Ejecución*:

```
¿Qué mes es? (1-12)
2
Introduce "sí" si es un año bisiesto o "no" si no lo es.
si
Febrero tiene 29 días
```



6) Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e incrementar en una unidad el número menor.

- *Código*:

 ```java
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
 ```



- *Ejecución*:

```
Introduce el primer numero (1-10).
2
Introduce el segundo numero (1-10).
11
Introduce el primer numero (1-10).
2
Introduce el segundo numero (1-10).
qq
No se ha introducido un numero.
Introduce el primer numero (1-10).
1
Introduce el segundo numero (1-10).
5
*
 a=2  b=5
*
 a=3  b=5
*
 a=4  b=5
*
 a=5  b=5
```

7) Pedir al usuario un número entero y calcular el factorial de dicho número usando la estructura “do-while”. Repetir el ejercicio usando la estructura “while”, y repetirlo una vez más usando la estructura “for”.

- *Código (las tres versiones seguidas)*:

 ```java
	private static int numero() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("Introduce un numero.");
		num = sc.nextInt();

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
 ```



- *Ejecución*:

```
Introduce un numero.
4
El factorial de 4 es 24
Introduce un numero.
5
El factorial de 5 es 120
Introduce un numero.
6
El factorial de 6 es 720
```



8) Basándote en la estructura `do-while`, diseña un menú de dos niveles, es decir: en un primer momento se pedirá escoger entre varias opciones, y en cada una de ellas se pedirá de nuevo escoger entre un nuevo conjunto. La temática es libre (cálculo de áreas, enciclopedia, etc). Es importante que tu programa reaccione correctamente ante entradas erróneas del usuario, y que en todos los menús haya una opción para volver.

  Ten en cuenta que codificar un menú correctamente no es trivial, conviene que pienses lo que vas a hacer antes de empezar a codificar.





```java

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

```

```
Introduce una opcion del 1 al 4.
1.-A 
2.-B 
3.-C 
4.- Salir 

1
Introduce una opcion del 1 al 4.
1.-a 
2.-b 
3.-c 
4.- Volver 

4
Introduce una opcion del 1 al 4.
1.-A 
2.-B 
3.-C 
4.- Salir 

2
Introduce una opcion del 1 al 4. 
1.-a 
2.-b 
3.-c 
4.- Volver

1
Ba
```



9) (opcional) Inventa un problema sencillo sobre estructuras de control de flujo. Resuélvelo para comprobar que el nivel de dificultad es adecuado y comparte el enunciado con tu compañer@ de al lado. Incluye aquí tanto tu enunciado como la solución.

- *Enunciado*:	 Dada una cadena por teclado, decidir si es palíndroma (se lee igual de izquierda a derecha que de derecha a izquierda).
- *Código de la solución*:


```java
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
```






- *Ejecución*:


```
Introduce la cadena
aa bb a b a bb aa
La cadena introducida es palindroma.
```





10) (opcional) Resuelve el problema que tu compañer@ plantee.

- *Enunciado de tu compañer@:* Haz una tabla de 10x10 con numeros enteros entre 1 y 9 de forma aleatoria. Suma filas y columnas por separado visualizando los  resultados por pantalla.

- *Código de la solución*

```java
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
```

- *Ejecución*:
```

La suma de la fila 1 es 62

La suma de la fila 2 es 60

La suma de la fila 3 es 42

La suma de la fila 4 es 51

La suma de la fila 5 es 58

La suma de la fila 6 es 48

La suma de la fila 7 es 59

La suma de la fila 8 es 59

La suma de la fila 9 es 51

La suma de la fila 10 es 50


La suma de la columna 1 es 63

La suma de la columna 2 es 49

La suma de la columna 3 es 47

La suma de la columna 4 es 59

La suma de la columna 5 es 50

La suma de la columna 6 es 59

La suma de la columna 7 es 64

La suma de la columna 8 es 60

La suma de la columna 9 es 53

La suma de la columna 10 es 36
```

