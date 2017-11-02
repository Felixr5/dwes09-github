###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## 	U2P04 - Clases y objetos
#### Entrega de: *Félix Rojo Archidona*
----
#### 1. Descripción:

Practica sencilla para trabajar con clases y objetos en PHP.

#### 2. Formato de entrega:

Un documento en el que se incluya el codigo fuente del archivo o archivos generados, así como una captura de pantalla de una ejecución.

#### 3. Trabajo a realizar:

Realiza una aplicación web que recoja en un formulario unos datos y los utilice para crear un objeto de una clase, llamar a uno de sus metodos, y mostrar el resultado por pantalla.

Ejemplo basado en la documentacion: 

1. Mostrar un formulario con dos campos para introducir la base y la altura de un triángulo.

   ![Captura](imagenes\Captura.PNG)

   ```php+HTML
   <?php 
   if (! isset($_POST['Enviar'])) {
       ?>
   	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
   		Base: <input type="text" name="base"> <br/>
   		Altura: <input type="text" name="altura"> <br/>
   		<input type="submit" name="Enviar">
   	</form>
   ```



2. Instanciar un objeto de la clase Triangulo

   ![Captura2](imagenes\Captura2.PNG)

   ```php+HTML
   <?php
       class Triangulo {
           public $base;
           public $altura;
           
       
           
           function calcularArea() {
               return ($this->base * $this->altura) / 2;
               
           }
       }
   ?>
   ```



```php
	include 'Triangulo.php';
    $triangulo = new Triangulo();
    $triangulo->altura= $_POST['altura'];
    $triangulo->base= $_POST['base'];
```
  

3. Invocar el método *calcularArea*

```php
    echo "El area es ".$triangulo->calcularArea();
```



4. Mostrar el resultado cuidando la presentación 

   ![Captura3](imagenes\Captura3.PNG)

   ```
   El area es 100
   ```

   ​

Se pide pensar en un ejemplo diferente a este, de igual o mayor complejidad.

Si te sobra tiempo y lo deseas puedes investigar e incorporar a tu actividad otros elementos de programación orientada a objetos en PHP, como:

 * [La herencia](http://php.net/manual/es/language.oop5.inheritance.php "")
 * [La impresion de todos los atributos de un objeto utilizando *foreach*](http://php.net/manual/es/language.oop5.iterations.php "")
 * [Las referencias a objetos](http://php.net/manual/es/language.oop5.references.php "")



