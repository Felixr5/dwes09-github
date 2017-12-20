
<?php 
session_name("autenticacion");
session_start();

if ($_SESSION["login"]!=1) {
    header("Location: ./login/login.php");
}


    if (isset($_REQUEST["cS"])) 
        $_SESSION['filtro']="";
    ?>
<html>
<head>
<title>Catalogo Canciones</title>
<meta charset="UTF-8" />
<style>
div.left
{
float:left;
}
div.right
{
float:left;
margin-left: 20px;
}
</style>
</head>
<body>
<?php
require "Cancion.php";
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor, $usuario, $clave, "catalogo09");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
//EXTRA

$NOA = ' href= mostrarCatalogo.php?res=NOA';
$NOZ = ' href= mostrarCatalogo.php?res=NOZ';
$AUA = ' href= mostrarCatalogo.php?res=AUA';
$AUZ = ' href= mostrarCatalogo.php?res=AUZ';
$ALA = ' href= mostrarCatalogo.php?res=ALA';
$ALZ = ' href= mostrarCatalogo.php?res=ALZ';


// CAMBIANDO SOLO EL VALOR DEL ORDER BY
if (! isset($_REQUEST['res'])){
    $order ='canciones.nombre asc';
    $NOA='';
}
if (isset($_REQUEST['res'])){
if ($_REQUEST['res'] == 'NOA'){
    $order ='canciones.nombre asc';
    $NOA='';
}
if ($_REQUEST['res'] == 'NOZ'){
    $order ='canciones.nombre desc';
    $NOZ='';
}
if ($_REQUEST['res'] == 'AUA'){
    $order = 'autores.nombre asc';
    $AUA='';
}
if ($_REQUEST['res'] == 'AUZ'){
    $order = 'autores.nombre desc';
    $AUZ='';
}
if ($_REQUEST['res'] == 'ALA'){
    $order = 'albums.nombre asc';
    $ALA='';
}
if ($_REQUEST['res'] == 'ALZ'){
    $order = 'albums.nombre desc';
    $ALZ='';
}
}

if (isset($_POST['id']))  
    if ($_POST['id']!="")
        $_SESSION['filtro']=" and canciones.ID_AUTOR=".$_POST['id'];
    else {
        $_SESSION['filtro']=" and canciones.ID_AUTOR=0";
        $_POST['id']="0";
    }
    if (isset($_SESSION['filtro']))
$resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor,autores.ID_AUTOR as idAut 
FROM canciones,autores,albums
where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM ".$_SESSION['filtro']." order by ".$order);
else
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor,autores.ID_AUTOR as idAut
FROM canciones,autores,albums
where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by ".$order);
    
    
/* CAMBIANDO LA QUERY
 if (! isset($_REQUEST['$resultado']))
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM");

if ($_REQUEST['$resultado'] == '$nombreA')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by canciones.nombre asc");
if ($_REQUEST['$resultado'] == '$nombreZ')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by canciones.nombre desc");

if ($_REQUEST['$resultado'] == '$autorA')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by autores.nombre asc");
if ($_REQUEST['$resultado'] == '$autorZ')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by autores.nombre desc");

if ($_REQUEST['$resultado'] == '$albumA')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by albums.nombre asc");
if ($_REQUEST['$resultado'] == '$albumZ')
    $resultado = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor FROM canciones,autores,albums where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by albums.nombre desc");
*/
?>
<div>

<div class="left">

	<table style='border: 0'>
		<tr style='background-color: whitesmoke'>
			<th>Nombre <a <?php echo $NOA ?>>&#9652</a>
			<a <?php echo $NOZ?>>&#9662</a></th>
			
			<th>AUTOR <a <?php echo $AUA ?>>&#9652</a>
			<a <?php echo $AUZ ?>>&#9662</a></th>
			
			<th>ALBUM <a <?php echo $ALA ?>>&#9652</a>
			<a <?php echo $ALZ ?>>&#9662</a></th>
		</tr>
<?php

if ($resultado->num_rows === 0)
    echo "<p>No hay canciones en la base de datos</p>";

    if (!isset($_POST['can']))
while ($cancion = $resultado->fetch_assoc()) {
    /*
     * echo "<tr bgcolor='lightgreen'>";
     * echo "<td>".$cancion->getNombre()."</td>\n";
     * $aut= $cancion->getIDAUTOR();
     * $resultad2 = $conexion -> query("SELECT NOMBRE FROM AUTORES WHERE ID_AUTOR=$aut");
     * $autor = $resultad2->fetch_assoc();
     * echo "<td>". $autor["NOMBRE"] ."</td>\n";
     * $alb=$cancion->getIDALBUM();
     * $resultad3 = $conexion -> query("SELECT NOMBRE FROM ALBUMS WHERE ID_ALBUM=$alb");
     * $nom = $resultad3->fetch_assoc();
     * echo "<td>". $nom['NOMBRE'] ."</td>\n";
     * echo "</tr>";
     * mysqli_free_result($resultad2);
     * mysqli_free_result($resultad3);
     */
    
        echo "<tr bgcolor=#c18ff0>";
        echo "<td><a href=mostrarObra.php?idCanc=$cancion[id] >" . $cancion['nombre'] . "</a></td>\n";
        echo "<td><a href=MostrarCatalogo.php?idAut=$cancion[idAut] >" . $cancion["autor"] . "</td>\n";
        echo "<td>" . $cancion['album'] . "</td>\n";
        echo "</tr>";
    }
else {
    $resultado1 = $conexion->query("SELECT canciones.ID_CANCION as id, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor,autores.ID_AUTOR as idAut
FROM canciones,autores,albums
 where canciones.NOMBRE like '%". $_POST['can'] ."%' and autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM order by ".$order);
    
    while ($can = $resultado1->fetch_assoc()) {
        echo "<tr bgcolor=#c18ff0>";
        echo "<td><a href=mostrarObra.php?idCanc=$can[id] >" . $can['nombre'] . "</a></td>\n";
        echo "<td><a href=MostrarCatalogo.php?idAut=$can[idAut] >" . $can["autor"] . "</td>\n";
        echo "<td>" . $can['album'] . "</td>\n";
        echo "</tr>";
    }
}
?>
</table>

</div>
<div class="left">

	<form action=" <?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?> " method="post" style="padding-top:4px">
<label>Introduce el ID del artista.</label><br><input type="number" name="id" >
		<br><input type="submit">
</form>
<form action=" <?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?> " method="post" style="padding-top:4px">
<label>Introduce el nombre de la cancion a buscar..</label><br><input type="text" name="can" >
		<br><input type="submit">
</form>
<h3><a href=MostrarCatalogo.php?cS=1>Borrar</a> plantilla</h3>

</div>
<div class="right">

<?php 

if (isset($_POST["id"]) || isset($_REQUEST['idAut'])){
    ?>
<table style='border: 0'>
		<tr style='background-color: lightblue'>
			<th>ID</th>
			<th>Nombre</th>
			<th>Nacimiento</th>
			<th>Creacion</th>
			<th>Nacionalidad</th>
			<th>Nacionalidad2</th>
			<th>Foto</th>
		</tr>	

<?php     
if (isset($_POST["id"])){
    $resultado1 = $conexion->
query("SELECT * ". 
"FROM autores ".
"where ID_AUTOR=".$_POST["id"] );
}else if (isset($_REQUEST['idAut'])){
$resultado1 = $conexion->
query("SELECT * ".
    "FROM autores ".
    "where ID_AUTOR=".$_REQUEST['idAut'] );
}

while ($aut = $resultado1->fetch_assoc()) { 
    $aut['FOTO']="<img src=/U3P03-PHP-Catalogo/img/".$aut['FOTO']." height=150  />";
    
echo "<tr bgcolor= #ff8080>";
foreach  ($aut as $au){
    echo "<td>" . $au ."</td>\n";
}


/*
echo "<td>" . $aut['NOMBRE'] ."</td>\n";
echo "<td>" . $aut["ID_AUTOR"] . "</td>\n";
echo "<td>" . $aut['A_NACIMIENTO'] . "</td>\n";
echo "<td>" . $aut['A_CREACION '] . "</td>\n";
echo "<td>" . $aut['NACIONALIDAD'] . "</td>\n";
echo "<td>" . $aut['NACIONALIDAD2'] . "</td>\n";
echo "<td>" . $aut['FOTO'] . "</td>\n";
*/
echo "</tr>";
}
echo "</table>";

}



?>
</table>
</div>
<?php
mysqli_close($conexion);
?>
</div>
</body>
</html>