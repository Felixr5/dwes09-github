<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php

$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");
$conexion->query("SET NAMES 'UTF8'");

//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Chip</th>
<th>Nombre</th>
<th>Especie</th>
<th>Imagen</th>
</tr>
<?php
$imgs="/U3P02-PHP-BBDD/img/";
$conexion ->query("UPDATE animal SET especie='jabali' WHERE nombre='Babe'");
echo "<h3 style='color:red'>". $conexion->error ."</h3>";
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");

if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
while($fila=$resultado->fetch_assoc()) {
    echo "<tr style='background-color:lightgreen'>";
    echo "<td>$fila[chip]</td>";
    echo "<td>$fila[nombre]</td>";
    echo "<td>$fila[especie]</td>\n";
    echo "<td><img src=$imgs$fila[imagen] height=150 width=150></td>\n";
    echo "</tr>";
}
?>

</table>
<?php

echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href=conexion5.php>Siguiente</a>
<a href=conexion3.php>Anterior</a>

</body>
</html>