###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P02 - Fundamentos de PHP
#### Entrega de: *Félix Rojo Archidona*
----
#### 1. Descripción:

El objetivo de la práctica es familiarizarse con el lenguaje PHP y codificar un programa en el que queden ejemplificados sus componentes y estructuras básicas, sirviendo más adelante como referencia básica.

#### 2. Formato de entrega:

Inserta el código en este documento.

#### 3. Trabajo a realizar:

Crea un proyecto *U2P02-PHP* y codifica un programa PHP en el que incluyas ejemplos propios de los elementos que se van indicando. Incluye estos apartados antes de cada prueba en forma de comentario de línea. Recuerda incluir este archivo en la carpeta `doc` dentro del proyecto:

* Comentarios de los tres tipos


```php
// Comentarios de los tres tipos
# Comentarios de los tres tipos
/* Comentarios de los tres tipos */
```



* Sentencias echo con los dos tipos de comillas


```php
echo "Sentencia con comillas dobles \"";
echo 'Sentencia con comillas simples \'';
```

```
Sentencia con comillas dobles " 
Sentencia con comillas simples '
```



* Uso de al menos tres operadores de comparación y dos operadores lógicos


```php
$a=1;
$b=0;

if ($a<$b) {
   echo "No es posible" ;
}elseif ($a>$b){
    $b+=2;
}
while ($b>=$a) {
    $b-=$a;
}
```



* Uso de un operador de asignación


```php
$a=$b;
```



* Declaración y uso de una variable por referencia


```php
$x=4;
$y=&$x;
echo " la variable x es $x, y es $y ha cogido el valor de x. \n <br/>";
$x=8;
echo " la variable x es $x, y es $y ha cogido el valor de x. \n <br/>";

```

```
la variable x es 4, y es 4 ha cogido el valor de x. 
la variable x es 8, y es 8 ha cogido el valor de x. 
```



* Declaración y uso de dos constantes, una que obligue a respetar las mayúsculas en su uso y otra que no lo haga


```php
define("PRUEBA","CONSTANTE");
echo "<p>es una prueba de una ".PRUEBA."</p>";

define("PRUEBA","CONSTANTE", true);
echo "<p>es una prueba sin mayus ".prueba."</p>";
```



* Declaración y uso de un variable booleana y otra de tipo double


```php
$bol=true;
echo "la variable bol es $bol<br/>";
$dou =25.5;
echo "la variable dou es $dou<br/>";

```

```
la variable bol es 1
la variable dou es 25.5
```



* Uso de is_numeric, is_bool y is_double con estas variables


```php
if (is_bool($bol) === true) {
    echo "Es un boolean<br/>";
}
if (is_double($dou) === true) {
    echo "Es un double<br/>";
}
if (is_numeric($dou) === true) {
    echo "Es un double<br/>";
}
```

```
Es un boolean
Es un double
Es un double
```



* Declaración de una variable de tipo string. Pruebas con la función *strlen* y con tres de las funciones indicadas en el enlace.


```php
$str = 'abcdef';
echo strlen($str).": strlen<br/>";
echo count($str).": count<br/>";
echo mb_strlen($str).": mb_strlen<br/>";
```

```
6: strlen
1: count
6: mb_strlen
```



* Declaración de un array escalar y uno asociativo


```php
$ciclos = array("SMR", "ASIR", "DAW");
foreach ($ciclos as $actual){
    echo "<li>$actual</li>";
}
echo "<br/>";
    $capitales = array("España"=>"Madrid", "Alemania"=>"Berlín", "Rusia"=>"Moscú");
    print_r($capitales);
```

```

•SMR
•ASIR
•DAW

Array ( [España] => Madrid [Alemania] => Berlín [Rusia] => Moscú ) 
```



* Ordenación y volcado de información con *var_dump* siguiendo dos criterios de ordenación en cada uno de los arrays


```php
$b = 3.1;
$c = true;
var_dump($b, $c);
```

```
float(3.1) bool(true) 
```



* Una estructura de control de cada tipo (if-elsif-else, switch, while, do-while, for)


```php
if ($a<$b) {
   echo "No es posible" ;
}elseif ($a>$b){
    $b+=2;
}

while ($b>=$a) {
    $b-=$a;
}

$i = 2;
do {
    switch ($i) {
        case 0:
            echo "i es igual a 0";
            break;
        case 1:
            echo "i es igual a 1";
            break;
        case 2:
            echo "i es igual a 2";
            break;
    }
    $i-=1;
    echo "<br/>";
    
} while ($i > 0);

for ($i = 1; $i <= 10; $i++) {
    echo $i;
}

```



* Un recorrido por cada uno de los dos arrays utilizando foreach, generando por ejemplo una lista ordenada con sus elementos


```php

$capitales = array("España"=>"Madrid", "Alemania"=>"Berlín", "Rusia"=>"Moscú");

$horas["DWES"]=9;
$horas["DAW"]=4;
$horas["EIE"]=3;

print_r($capitales);
echo "<br/>"; 
print_r($horas);
```

```
Array ( [España] => Madrid [Alemania] => Berlín [Rusia] => Moscú ) 
Array ( [DWES] => 9 [DAW] => 4 [EIE] => 3 ) 
```

* Dos pruebas con la variable superglobal _SERVER


```php
echo $_SERVER['SERVER_NAME'];
echo "<br/>";
echo $_SERVER['HTTP_HOST'];
```

```
localhost
localhost
```



* Dos pruebas de funciones: una devolverá algun tipo, la otra no


```php

function holamundo() {
    echo "Hello world!";
}
holamundo();
$nu=1;
function numb($nu): float {
    return $nu;
}
echo numb($nu);
```

```
Hello world!1 
```



* Impresion de la fecha y hora con todo el detalle posible


```php
echo date('l jS \of F Y h:i:s A');
```

```
Thursday 19th of October 2017 02:06:27 PM 
```



* Una función que utilice una variable global


```php
function holamundo2() {
    global $nu;
    echo "Hello world! $nu";
}
holamundo2();
```

```  
Hello world! 1
```



* Un formulario que reciba tu nombre y lo muestre por pantalla


```php+HTML
if (!isset($_POST['Enviar'])) {
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    Nombre: <input type="text" name="nombre">
    <input type="submit" name="Enviar">
    </form>
    <?php 
}    
else {
    echo "<h2>El nombre introducido es ".$_POST["nombre"]."</h2>";
}
?>
```

