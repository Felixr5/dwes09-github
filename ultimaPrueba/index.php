<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Último ejemplo de PHP</title>
</head>
<body>
<?php
/*
$x=4;
$y=5;

echo "$x es la variable. $y es y\n <br>";

$x += $y;
echo '$x += $y' . ": $x es la variable x. $y es la variable y.\n <br>";

$x -= $y;
echo '$x -= $y' . ": $x es la variable x. $y es la variable y.\n <br>";

$x *= $y;
echo '$x *= $y' . ": $x es la variable x. $y es la variable y.\n <br>";

$x /= $y;
echo '$x /= $y' . ": $x es la variable x. $y es la variable y.\n <br>";

$x .= $y;
echo '$x .= $y' . ": $x es la variable x. $y es la variable y. <br>";



if($x > $y):
echo "x es mayor";
echo " segundaa linea";
endif;  


$ciclos = array("SMR", "ASIR", "DAW");
$ciclos2 = array(0=>"SMR", 1=>"ASIR", 4=>"DAW");
$ciclos3= array();

$ciclos3[0] = "SMR";
$ciclos3[1] = "SMR";
$ciclos3[4] = "SMR";
echo "<br>tamaño de ciclos1 es ".sizeof($ciclos);
echo "<br>tamaño de ciclos2 es ".sizeof($ciclos2);
echo "<br>tamaño de ciclos3 es ".sizeof($ciclos3);


define("PRUEBA","CONSTANTE");
echo "<p>es una prueba de una ".PRUEBA."</p>";

*/
echo "Lista de ciclos";
echo "<ul>";
$ciclos = array("SMR", "ASIR", "DAW");
foreach ($ciclos as $actual){
    echo "<li>$actual</li>";
}
echo "</ul>";



$capitales = array("España"=>"Madrid", "Alemania"=>"Berlín", "Rusia"=>"Moscú");

$horas["DWES"]=9;
$horas["DAW"]=4;
$horas["EIE"]=3;

print_r($capitales);
echo "<br/>"; 
print_r($horas);



echo "<ul>";
foreach ($capitales as $capital){
    echo "<li>$capital</li>";
}
echo "</ul>";



echo "<ul>";
foreach ($capitales as $pais=>$capital){
    echo "<li>La capital de $pais es $capital</li>";
}

echo "</ul>";









?>




</body>
</html>   





