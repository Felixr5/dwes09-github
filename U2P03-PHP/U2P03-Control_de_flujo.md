###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P03 - Control de flujo
#### Entrega de: *Félix Rojo*
----
#### 1. Descripción:

Vamos a practicar las sentencias de control de flujo en PHP

#### 2. Formato de entrega:

Este u otro documento en el que se incluya el codigo fuente del archivo o archivos generados, así como una captura de pantalla de una ejecución.

#### 3. Trabajo a realizar:

Crea un nuevo proyecto PHP *U2P03-PHP-Control de flujo* que consistirá en una página web “index.php” o “index.html” con enlaces a las siguientes páginas, que resolverán diferentes problemas. En cada una de las páginas se incluirá un enlace “Volver” para regresar a la página principal.

##### Parte 1: “ecf-diferencia.php”

Pedir al usuario dos números A y B entre el 1 y el 10. Escribir en pantalla tantos asteriscos como diferencia haya entre los números (resolviéndolo con while, mientras uno sea menor que otro se escribe asterisco) y repetir con almohadillas (resolviéndolo con for utilizando la diferencia entre a y b como número de repeticiones).

![C1](img/Captura.png)

![C2](img/Captura2.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 



if (! isset($_POST['Enviar*'])) {
    ?>
    <h2>Introduce 2 numeros (*)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		A: <input type="text" name="a"> <br/>
		B: <input type="text" name="b"> 
		<input type="submit" name="Enviar*">
	</form>
	<?php 
} else {
    $a=$_POST["a"];
    $b=$_POST["b"];
    
    while ($a!=$b) {
        if ($a>$b) {
            $b+=1;
            echo "*";
        }else {
            $a+=1;
            echo "*";
        }
    }
}   

if (! isset($_POST['Enviar#'])) {
    ?>
    <h2>Introduce 2 numeros (#)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		A: <input type="text" name="a"> <br/>
		B: <input type="text" name="b"> 
		<input type="submit" name="Enviar#">
	</form>
	<?php 
} else {
    $a=$_POST["a"];
    $b=$_POST["b"];
    if ($a<$b) {
        $tope=$b-$a;
    }elseif ($b<$a){
        $tope=$a-$b;
    }
    
    for ($i = 0; $i < $tope; $i++) {
        echo "#";
    }
   
    
} 


echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 2: “ecf-suma.php”

Pedir un número X y calcular la suma de los X primeros números naturales (1 + 2 + 3 + …).

![C3](img/Captura3.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];  
    
    $x=0;
 for ($i = 0; $i <= $num; $i++) {
     $x+=$i;
 }  
    echo "El total de los $num numeros naturales es $x";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 3: “ecf-potencia.php”

Pedir dos números A y B y calcular la potencia A elevado a B utilizando iteraciones (no una función matemática predefinida).

![C4](img/Captura4.png)

![C5](img/Captura5.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce dos numeros</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero1: <input type="text" name="num1"> <br/>
		Numero2: <input type="text" name="num2"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num1=$_POST["num1"];
    $num2=$_POST["num2"];
    $potencia=1;
  echo "La potencia es ";
  for ($i = 1; $i <= $num2; $i++) {
      $potencia*=$num1;
  }
  echo "$potencia";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 4: “ecf-factorial.php”

Pedir un número X y calcular su factorial utilizando iteraciones.

![C6](img/Captura6.png)

![C7](img/Captura7.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Factorial)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    $fac=1;
  echo "El factorial de $num es ";
  for ($i = 1; $i <= $num; $i++) {
      $fac*=$i;
  }
  echo "$fac";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 5: “ecf-multiplicacion.php”

Pedir un número X y mostrar su tabla de multiplicar.

![C8](img/Captura8.png)

![C9](img/Captura9.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Tabla de multiplicar)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    $res=0;
  for ($i = 0; $i <= 10; $i++) {
      $res=$num*$i;
      echo "$num x $i es $res <br/>";
  }
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 6: “ecf-recorte.php”

Pedir una cadena de texto y mostrarla varias veces: en cada línea se mostrará un carácter menos que en la anterior. Sólo se puede usar una función de strings: “strlen()”

```
Mi casa
Mi cas
Mi ca
Mi c
Mi 
Mi
M
```



![C10](img/Captura10.png)

![C11](img/Captura11.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce una cadena (Recorte)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Cadena: <input type="text" name="cad"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {

    for ($i = strlen($_POST["cad"]); $i >= 0; $i-- ){
      for ($j = 0; $j < $i; $j++ ){
          echo $_POST['cad'][$j];
          
          
      }
      
      echo "<br/>";
 }
} 



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```





##### Parte 7: “ecf-meses”

En un formulario se recogerá un valor en un cuadro de texto y un radio group para indicar si el año actual es bisiesto o no. Habrá que comprobar si el valor leído corresponde al número de un mes (de 1 a 12) o a su nombre (“enero”, “febrero”). Si es así se mostrará el número de días que tiene ese mes, y si no es así se mostrará un error. Nota:para comparar String, busca referencia de las funciones *strcmp* y *strcasecmp*. 

![C12](img/Captura12.png)

![C13](img/Captura13.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>


<?php

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un valor (Meses)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Valor: <input type="text" name="cad"> <br/>
		Bisiesto: <input type="radio" name="bis" >   
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $meses = array("Enero" => 31, "Febrero" => 28, "Marzo" => 31,"Abril" => 30,"Mayo" => 31,"Junio" => 30,"Julio" => 31,"Agosto" => 31,"Septiembre" => 30,"Octubre" => 31,"Noviembre" => 30,"Diciembre" => 31);
    $meses2 = array("1" => 31, "2" => 28, "3" => 31, "4" => 30, "5" => 31, "6" => 30, "7" => 31, "8" => 31, "9" => 30, "10" => 31, "11" => 30, "12" => 31);
      
    foreach ($meses as $mes => $numero){
        if (strcasecmp($mes, $_POST['cad']) == 0) {
            if (strcasecmp($mes, "Febrero")==0 && isset($_POST['bis']))  {
                echo  "Tiene ". ($numero+1) ." días";
            }else echo  "Tiene $numero días";
        }
    }
    
    foreach ($meses2 as $mes => $numero){
        if (strcasecmp($mes, $_POST['cad']) == 0) {
            if (strcasecmp($mes, "2")==0 && isset($_POST['bis']))  {
                echo  "Tiene ". ($numero+1) ." días";
            }else echo  "Tiene $numero días";
        }
    }
      
      echo "<br/>";
}
echo "<a href='index.php'> <h3>Volver</h3> </a>";
?>

</body>
</html>
```





##### Parte 8: “ecf-acumulador”

Ir pidiendo por formulario una serie de números enteros (de uno en uno) e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir entonces la suma de todos los números introducidos. Pista: para poder mantener el valor acumulado (antes de estudiar técnicas más avanzadas) utilizar un campo de formulario de tipo oculto (“hidden”).

![C14](img/Captura14.png)

![C15](img/Captura15.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    $_POST["num"]=0;
    $_POST["ac"]=0;
    $ac=0;
 }
        if ($_POST['ac']<50) {
            echo " <h3>Aun no se ha llegado a 50 </h3>";
            
        ?>
    
    <h2>Introduce un numero (Acumulador)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<?php $ac=$_POST["num"]+$_POST["ac"];?>
		<input type="hidden" value=<?php echo $ac ;?> name="ac">
		<input type="submit" name="Enviar">
	</form>
	<?php } else{
	           echo " Ya se ha llegado a 50 ";
          } 	    




echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```





##### Parte 9: “ecf-multiplos”

Mostrar en pantalla los múltiplosde 3 y 5 entre el 1 y el 1000. A continuación mostrar en pantalla los 20 primeros múltiplos de 3 y 5.

![C16](img/Captura16.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

echo "<h3>Múltiplos de 3 y 5 entre el 1 y el 1000</h3>";
for ($i = 0; $i < 1000; $i++) {
    if ($i%5==0 || $i%3==0) {
        echo "$i    ";
    }
}

echo "<h3>20 primeros múltiplos de 3 y 5.</h3>";
          $c=0;
for ($i = 1; $i <= 20; $i++) {
    do{
    $c+=1;
    }while ($c%5!=0 && $c%3!=0);
          
        
    echo "$c es el numero $i de 20";
    echo "<br/>";
}

     
echo "<br/>";
 

echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```



##### Parte 10: “ecf-cuadrado”

Pedir un número X y generar un cuadrado como el que se muestra en la figura (en este caso X vale 10). Una vez resuelto, mejorarlo para que las filas pares salgan en un color más claro (lightblue por ejemplo) para facilitar la lectura. En la figura se ha usado un “padding” de 3 para los elementos de celda (td).

![U2P03](U2P03.png)



![C17](img/Captura17.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<style>
 table,th,td {
     border: 1px solid black;
}
th,td{
  padding: 3px;
}
</style>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Cuadrado)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    echo "<table>";
    for ($i = 1; $i <= $num; $i++) {
        echo "<tr>";
        for ($j = 1; $j <= $num; $j++) 
            echo "<td >".$i*$j."</td>";
        echo "</tr>";
    }

echo "<table>";
}
echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```

![C18](img/Captura18.png)

```php+HTML
<!DOCTYPE html>
<html>
<head>
<style>
 table,th,td {
     border: 1px solid black;
}
th,td{
  padding: 3px;
}
</style>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Cuadrado)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    echo "<table>";
    for ($i = 1; $i <= $num; $i++) {
        if ($i%2==0){
        echo "<tr bgcolor='lightblue'>";
        }else{
            echo "<tr>";
            
        }
        for ($j = 1; $j <= $num; $j++) 
             echo "<td>".$i*$j."</td>";
            
        
    }
        echo "</tr>";
    

echo "<table>";
}
echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>
```

