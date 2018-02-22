<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor, $usuario, $clave, "catalogo09");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<?php
if (! isset($_REQUEST["idCanc"]))
    die("<h3>ERROR en la petición. Falta identificador de cancion</h3>");
$idCanc = $_REQUEST["idCanc"];

?>
<table style='border: 0'>
		<tr style='background-color: whitesmoke'>
			<th>Nombre</th>
			<th>AUTOR</th>
			<th>ALBUM</th>
			<th>CARATULA</th>
		</tr>
<?php
$resultado = $conexion->query("SELECT albums.PORTADA as caratula, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM and canciones.ID_CANCION=" . $idCanc);
if ($resultado->num_rows === 0)
    die("<h3>ERROR en la petición. Identificador de cancion no válido</h3>");
$cancion = $resultado->fetch_assoc();
echo "<tr bgcolor='lightgreen'>";
echo "<td>" . $cancion['nombre'] . "</td>\n";
echo "<td>" . $cancion["autor"] . "</td>\n";
echo "<td>" . $cancion['album'] . "</td>\n";
echo "<td><img src=/U3P03-PHP-Catalogo/img/" . $cancion['caratula'] . " height=150 width=150 /></td>\n";
echo "</tr>";
// liberamos la memoria del resultado, que reutilizaremos después
mysqli_free_result($resultado);
?>
</table>
	<br>
	<a href=mostrarCatalogo.php>Volver</a> a la lista de canciones.
</body>
</html>