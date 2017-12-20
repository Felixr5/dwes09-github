<?php
session_start();
if ($_SESSION['admin']!=1 || !isset($_SESSION['admin']))
header('Location:admin-login.php');

include 'conexionAlumno_rw.php';

if (isset($_REQUEST['id'])){
    $conexion->query("DELETE FROM temas WHERE id=".$_REQUEST['id']);    
    header('Location:admin-baja.php');
}
    
   
    
$resultado= $conexion -> query("SELECT nombre_i,id from temas");


?>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
    footer {
  position: fixed;
  right: 0;
  bottom: 0;
  left: 0;
  padding: 1rem;
  background-color: #efefef;
  text-align: center;
}</style>
</head>
<?php include 'header.php';?>

<body>
<h3 style="color:red;">BAJA </h3>

<table style='border: 0;'>
		<tr style='background-color: silver'>
			<th>Título</th>	
		</tr>
		<?php 
while ($dis = $resultado->fetch_assoc()) {
    echo "<tr bgcolor= 	#00BFFF>";
        echo "<td>" . $dis['nombre_i'] ." ------  <a href=admin-baja.php?id=$dis[id] style=color:#8B0000;>ELIMINAR</a> </td>\n";
    echo "</tr>";
}
?>
</table>
</body>

<footer><a href='admin-login.php'>Haz click aqui para volver al login de admin.</a></footer>

</html>
