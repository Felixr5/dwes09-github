<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php
// Comentarios de los tres tipos
// Comentarios de los tres tipos
/* Comentarios de los tres tipos */

// Sentencias echo con los dos tipos de comillas
echo "Sentencia con comillas dobles \" <br/>";
echo 'Sentencia con comillas simples \'<br/>';
echo "<br/>";
// Uso de al menos tres operadores de comparación y dos operadores lógicos

$a = 1;
$b = 0;

if ($a < $b) {
    echo "No es posible<br/>";
} elseif ($a > $b) {
    $b += 2;
}
while ($b >= $a) {
    $b -= $a;
}

// Uso de un operador de asignación
$a = $b;

// Declaración y uso de una variable por referencia
$x = 4;
$y = &$x;
echo " la variable x es $x, y es $y ha cogido el valor de x. \n <br/>";
$x = 8;
echo " la variable x es $x, y es $y ha cogido el valor de x. \n <br/>";
echo "<br/>";
// Declaración y uso de dos constantes, una que obligue a respetar las mayúsculas en su uso y otra que no lo haga

define("PRUEBA", "CONSTANTE");
echo "<p>es una prueba de una " . PRUEBA . "</p>";

define("PRUEBA", "CONSTANTE", true);
echo "<p>es una prueba sin mayus " . prueba . "</p>";

echo "<br/>";
// Declaración y uso de un variable booleana y otra de tipo double
$bol = true;
echo "la variable bol es $bol<br/>";
$dou = 25.5;
echo "la variable dou es $dou<br/>";
echo "<br/>";
// Uso de is_numeric, is_bool y is_double con estas variables
if (is_bool($bol) === true) {
    echo "Es un boolean<br/>";
}
if (is_double($dou) === true) {
    echo "Es un double<br/>";
}
if (is_numeric($dou) === true) {
    echo "Es un double<br/>";
}
echo "<br/>";
// Declaración de una variable de tipo string. Pruebas con la función strlen y con tres de las funciones indicadas en el enlace.
$str = 'abcdef';
echo strlen($str) . ": strlen<br/>";
echo count($str) . ": count<br/>";
echo mb_strlen($str) . ": mb_strlen<br/>";
echo "<br/>";
// Declaración de un array escalar y uno asociativo
$ciclos = array(
    "SMR",
    "ASIR",
    "DAW"
);
foreach ($ciclos as $actual) {
    echo "<li>$actual</li>";
}
echo "<br/>";
$capitales = array(
    "España" => "Madrid",
    "Alemania" => "Berlín",
    "Rusia" => "Moscú"
);
print_r($capitales);
echo "<br/>";
echo "<br/>";

// Ordenación y volcado de información con var_dump siguiendo dos criterios de ordenación en cada uno de los arrays
$b = 3.1;
$c = true;
var_dump($b, $c);
echo "<br/>";
echo "<br/>";

// Una estructura de control de cada tipo (if-elsif-else, switch, while, do-while, for)
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
echo "<br/>";
echo "<br/>";

// Un recorrido por cada uno de los dos arrays utilizando foreach, generando por ejemplo una lista ordenada con sus elementos

$capitales = array("España"=>"Madrid", "Alemania"=>"Berlín", "Rusia"=>"Moscú");

$horas["DWES"]=9;
$horas["DAW"]=4;
$horas["EIE"]=3;

print_r($capitales);
echo "<br/>";
print_r($horas);
// Dos pruebas con la variable superglobal _SERVER
echo "<br/>";
echo "<br/>";

echo $_SERVER['SERVER_NAME'];
echo "<br/>";
echo $_SERVER['HTTP_HOST'];

echo "<br/>";
echo "<br/>";

// Dos pruebas de funciones: una devolverá algun tipo, la otra no

function holamundo() {
    echo "Hello world!";
}
holamundo();
$nu=1;
function numb($nu): float {
    return $nu;
}
echo numb($nu);

echo "<br/>";
echo "<br/>";

// Impresion de la fecha y hora con todo el detalle posible
echo date('l jS \of F Y h:i:s A');
echo "<br/>";
echo "<br/>";

// Una función que utilice una variable global
function holamundo2() {
    global $nu;
    echo "Hello world! $nu";
}
holamundo2();
echo "<br/>";
echo "<br/>";
    
    // Un formulario que reciba tu nombre y lo muestre por pantalla
if (! isset($_POST['Enviar'])) {
    ?>
	<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
		Nombre: <input type="text" name="nombre"> 
		<input type="submit" name="Enviar">
	</form>
	<?php
} else {
    echo "<h2>El nombre introducido es " . $_POST["nombre"] . "</h2>";
}
?>


</body>
</html>


