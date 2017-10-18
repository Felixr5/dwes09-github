<?php
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



if($x>$y):
echo "x es mayor";
echo " segundaa linea";
endif;
?>