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



echo "<h2>Listado de cuidadores</h2>";
echo "<h3>Pulsa en cada cuidador para ver los animales de los que se ocupa</h3>";

$resultado = $conexion-> query("SELECT * FROM cuidador");
if($resultado->num_rows === 0) echo "<p>No hay cuidadores en la base de datos</p>";
echo "<ul>\n";
while($fila=$resultado->fetch_assoc()) {
    echo "<li><a href='cuidador.php?idCuidador=$fila[idCuidador]'>$fila[Nombre]</a></li>\n";
    // Ejemplo: <li><a href='cuidador.php?idCuidador=12345'>Alberto</a></li>
}
echo "</ul>";



echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href=conexion7.php>Siguiente</a>
<a href=conexion5.php>Anterior</a>

</body>
</html>