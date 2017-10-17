##### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P05 - Figuras
#### Entrega de: *Félix Rojo*
----

#### 1. Descripción:

Vamos a utilizar el enfoque orientado a objetos para solucionar un problema trigonométrico, repasando conceptos como clases y objetos, herencia y polimorfismo, colecciones, o JavaDoc.

#### 2. Formato de entrega:

Incluye al final de este documento el código de las clases que hayas programado, así como el resultado de ejecución.

Puedes utilizar bloques de código Markdown o capturas de Eclipse.

#### 3. Trabajo a realizar:

#### Parte 1: Clases y objetos

Crea un paquete llamado `figuras` y codifica las clases Cuadrado, Triangulo y Circunferencia. Incluye en todas un método para imprimir s	us datos. Después codifica una clase *Problema* que calcule el área y el perímetro de la siguiente figura:

![](U0P05-1.png "...")

##### Código de la clase Cuadrado:

```java
package figuras;

public class Cuadrado {
	private double lado;
	private double perimetro, area;

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

	public double getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}

```

##### Código de la clase Triángulo:

```java
package figuras;

public class Triangulo {
	private double base, altura;
	private double perimetro, area;

	public double getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

}
```



##### Código de la clase Circunferencia:

```java
package figuras;

public class Circunferencia {
	private double radio;
	private double perimetro, area;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Circunferencia(double radio) {
		this.radio = radio;
		
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", perimetro=" + perimetro + ", area=" + area + "]";
	}

}
```



##### Código del método main en la clase Problema:

```java
package figuras;

public class Problema {

	public static void main(String[] args) {

		Cuadrado cuad = new Cuadrado(4.2);
		Circunferencia circ1 = new Circunferencia(4.8);
		Circunferencia circ2 = new Circunferencia(1.5);
		Triangulo tri = new Triangulo(8, 15);

		cuad.setArea(Math.pow(cuad.getLado(), 2));
		cuad.setPerimetro(cuad.getLado() * 4);

		circ1.setArea(Math.PI * Math.pow(circ1.getRadio(), 2));
		circ1.setPerimetro(2 * Math.PI * circ1.getRadio());
		circ2.setArea(Math.PI * Math.pow(circ2.getRadio(), 2));
		circ2.setPerimetro(2 * Math.PI * circ2.getRadio());
		tri.setArea((tri.getAltura() * tri.getBase()) / 2);

		double a, b, raiz;
		a = tri.getAltura();
		b = tri.getBase();
		raiz = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		tri.setPerimetro(a + b + raiz);

		double areaTotal, perTotal;
		areaTotal = cuad.getArea() + (circ1.getArea() / 2) + (circ2.getArea() * 0.75) + tri.getArea();
		perTotal = (cuad.getPerimetro() * 0.75) + (circ1.getPerimetro() / 2) + (circ2.getPerimetro() * 0.75)
				+ (tri.getPerimetro() - circ2.getRadio() * 2);

		System.out.println(cuad.toString());
		System.out.println(circ1.toString());
		System.out.println(circ2.toString());
		System.out.println(tri.toString());

		System.out.println("Area total: " + areaTotal);
		System.out.println("Perimetro total: " + perTotal);

	}

}
```





##### Ejecución del método main:

```
Cuadrado [lado=4.2, perimetro=16.8, area=17.64]
Circunferencia [radio=4.8, perimetro=30.159289474462014, area=72.38229473870884]
Circunferencia [radio=1.5, perimetro=9.42477796076938, area=7.0685834705770345]
Triangulo [base=8.0, altura=15.0, perimetro=40.0, area=60.0]
Area total: 119.13258497228719
Perimetro total: 71.74822820780804
```



#### Parte 2: Herencia

Queremos que todas las figuras tengan un título y un color. Para el color puedes utilizar un tipo enumerado Color con al menos cinco valores.

1. Define una clase Figura con estos nuevos atributos
- Haz que nuestras clases de figuras hereden dichos atributos
- ¿Crees que la clase Figura debería ser abstracta? ¿Y los métodos de calcular áreas y perímetros? Si es así haz las modificaciones necesarias
- Utilizando la *reescritura*, haz que de cada figura se impriman en pantalla tanto sus atributos heredados (color y título) como los propios de esa figura particular.
- Crea una clase Principal con un método main en el que instancies diferentes figuras por este procedimiento y escribas sus datos por pantalla.

##### Código de la clase Figura:



```java
package figuras;

public abstract class Figura {
	
	public enum Clor {
		AZUL, VERDE, AMARILLO, ROJO
	};
	Clor color;
	private String titulo;

	public abstract double area();

	public abstract double perimetro();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Figura(String titulo, Clor color) {
		this.titulo = titulo;
		this.color=color;
	}

	@Override
	public String toString() {
		return "Figura [color=" + color + ", titulo=" + titulo + "]";
	}

}
```



##### Código de la clase Cuadrado una vez modificada:

```java
package figuras;

public class Cuadrado extends Figura{
	private double lado;

	public Cuadrado(String titulo, Clor color, double lado) {
		super(titulo, color);
		this.lado = lado;
	}

	@Override
	public String toString() {
		return super.toString() + " [lado=" + lado + ", perimetro=" + perimetro() + ", area=" + area() + "]";
	}

	public double getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.pow(lado, 2);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (lado * 4);
	}


}
```





##### Código del método main en la clase Principal:

```java
package figuras;

import figuras.Figura.Clor;

public class Problema {

	public static void main(String[] args) {

		Cuadrado cuad = new Cuadrado("Cuadrado", Clor.AMARILLO, 4.2);
		Circunferencia circ1 = new Circunferencia("circ1", Clor.AZUL, 4.8);
		Circunferencia circ2 = new Circunferencia("circ2", Clor.VERDE, 1.5);
		Triangulo tri = new Triangulo("Triangulo", Clor.ROJO, 8, 15);

		double areaTotal, perTotal;
		areaTotal = cuad.area() + (circ1.area() / 2) + (circ2.area() * 0.75) + tri.area();
		perTotal = (cuad.perimetro() * 0.75) + (circ1.perimetro() / 2) + 	(circ2.perimetro() * 0.75)
				+ (tri.perimetro() - circ2.getRadio() * 2);

		

		System.out.println(cuad.toString());
		System.out.println(circ1.toString());
		System.out.println(circ2.toString());
		System.out.println(tri.toString());

		System.out.println("Area total: " + areaTotal);
		System.out.println("Perimetro total: " + perTotal);

	}

}
```





##### Ejecución del método main:

```
Figura [color=AMARILLO, titulo=Cuadrado]Cuadrado [lado=4.2, perimetro=16.8, area=17.64]
Figura [color=AZUL, titulo=circ1]Circunferencia [radio=4.8, perimetro=0.0, area=0.0]
Figura [color=VERDE, titulo=circ2]Circunferencia [radio=1.5, perimetro=0.0, area=0.0]
Figura [color=ROJO, titulo=Triangulo]Triangulo [base=8.0, altura=15.0, perimetro=0.0, area=0.0]
Area total: 119.13258497228719
Perimetro total: 71.74822820780804
```



#### Parte 3: Colecciones

1. Codifica una clase GestorFiguras con un único atributo (un ArrayList de figuras) y los siguientes métodos, teniendo cuidado de documentar con código JavaDoc:
  - **constructor**: no recibirá ningún valor pero inicializará el ArrayList
  - **añadirFigura**: recibirá un objeto de la clase Figura y lo añadirá a la lista siempre que no tenga el mismo título
  - **eliminarFigura**: eliminará una figura a partir de su título
  - **mostrarFiguras**: escribirá por pantalla de forma ordenada los datos de todas las figuras del gestor
  - **calcularSumatorioAreas**: escribirá la suma de las áreas de todas las figuras

2. Modifica el método main de la clase Principal para crear un gestor de figuras y hacer pruebas con él: añadir alguna, eliminarla, imprimirlas... 

##### Código de la clase GestorFiguras:

````java
package figuras;

import java.util.ArrayList;

public class GestorFiguras {

	private ArrayList<Figura> listaFiguras;

	public GestorFiguras() {
		listaFiguras = new ArrayList<>();
	}
	
	private Figura comprobarnombre(String nombre) {
		for (Figura figura : listaFiguras)
			if (figura.getTitulo().equals(nombre))
				return figura;

		return null;

	}

	public void anyadirFig(Figura figura) {

		if (comprobarnombre(figura.getTitulo()) == null)
			listaFiguras.add(figura);
		else
			System.out.println("No se ha podido añadir porque ya existia ese titulo.");
	}

	
	public void borrarFigura (String titulo) {
		if (comprobarnombre(titulo)!=null) 
			listaFiguras.remove(comprobarnombre(titulo));
			else
			System.out.println("No existia ese titulo por lo que no se ha borrado.");
			}
	
	public void mostrarFiguras () {
		for (Figura figura : listaFiguras) 
			System.out.println(figura.toString());
		
	}
	
		
		public void sumaAreas() {
			double total=0;
		
			for (Figura figura : listaFiguras) 
				total+=figura.area();
			
			
			System.out.println("La suma de todas las areas es "+total);
			
		}
	

}
````



##### Código del método main en la clase Principal:

```java
package figuras;

import figuras.Figura.Clor;

public class Main {
	public static void main(String[] args) {
		Cuadrado cuad = new Cuadrado("Cuadrado", Clor.AMARILLO, 4.2);
		Circunferencia circ2 = new Circunferencia("circ2", Clor.VERDE, 1.5);

		GestorFiguras gestor = new GestorFiguras();

		gestor.anyadirFig(cuad);
		gestor.anyadirFig(circ2);
		gestor.mostrarFiguras(); 
		gestor.anyadirFig(cuad);
		gestor.borrarFigura("Cuadrado");
		gestor.sumaAreas();

	}
}
```



##### Ejecución del método main:

```
Figura [color=AMARILLO, titulo=Cuadrado] [lado=4.2, perimetro=16.8, area=17.64]
Figura [color=VERDE, titulo=circ2] [radio=1.5, perimetro=0.0, area=0.0]
No se ha podido añadir porque ya existia ese titulo.
La suma de todas las areas es 7.0685834705770345
```

