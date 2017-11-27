<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");
$conexion->query("SET NAMES 'UTF8'");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
echo "<h4>Animales</h4>";
while($fila!=null) {
    echo "<hr>";
    echo "Nombre:" . $fila['nombre'];
    echo "<br>Especie: $fila[especie]"; // observa la diferencia en el uso de comillas
    $fila=$resultado->fetch_assoc();
}
mysqli_free_result($resultado);
$resultado2 = $conexion -> query("SELECT * FROM cuidador ORDER BY nombre");
if($resultado2->num_rows === 0) echo "<p>No hay cuidadores en la base de datos</p>";
$fila=$resultado2->fetch_assoc();
echo "<h4>Cuidadores</h4>";
while($fila!=null) {
    echo "<hr>";
    echo "Nombre:" . $fila['Nombre'];
    $fila=$resultado2->fetch_assoc();
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href=conexion3.php>Siguiente</a>
<a href=conexion1.php>Anterior</a>

</body>
</html>