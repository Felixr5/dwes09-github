<?php
session_start();
if (!isset($_REQUEST["disco"])) die ("<h3>ERROR en la petición. Falta identificador de disco</h3>");
else
    $idDisco = $_REQUEST["disco"];

if (!isset($_COOKIE['lan'])){
    setcookie("lan", "i", time() + (86400 * 30), "./");
    header("Location:disco.php?disco=$idDisco");
}
    

include 'conexionAlumno.php';

if (isset($_REQUEST['lan'])){
$lan=$_REQUEST['lan'];
}
else 
    $lan="i";

    setcookie("lan", $lan, time() + (86400 * 30), "./");
    
if(isset($_REQUEST['lan']))
        header("Location:disco.php?disco=$idDisco");
 
        $resultado1= $conexion -> query("SELECT  id_disco,nombre_".$_COOKIE["lan"]." as nombre, minutos, segundos, numero ".
        " FROM temas WHERE temas.id_disco=$idDisco");
      
?>
<html>
<head>
	<meta charset="UTF-8"/>
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

<?php



?>
 <table style='border: 0;'>
		<tr style='background-color: silver'>
			<th>Título</th>
			
			<th>Discográfica</th>
			
			<th>Año</th>
			
			<th>Formato</th>
			
			<th>Portada</th>
		
			<th>Idioma</th>
		
		</tr>
<?php 
$resultado= $conexion -> query("SELECT nombre as Título, discografica as Discográfica, year as Año, soporte as Formato, imagen as Portada".
    " FROM discos WHERE id=$idDisco");

    
while ($dis = $resultado->fetch_assoc()) {
    $dis['Portada']="<img src=./img/discografia/".$dis['Portada'].".jpg height=150  />";
    echo "<tr bgcolor= #ff8080>";
    foreach  ($dis as $can){
        echo "<td>" . $can ."</td>\n";
    }
    echo "<td><a href=disco.php?disco=$idDisco&lan=i><img src=./img/banderas/is.png ></img></a><br><a href=disco.php?disco=$idDisco&lan=e><img src=./img/banderas/es.png ></img></a> </td>\n";
    echo "</tr>";
}
?>
</table>
<br>
 <table style='border: 0;'>
		<tr style='background-color: silver'>
			<th>Número</th>
			
			<th>Título</th>
			
			<th>Duración</th>
		
		</tr>
		<?php 
		
while ($tem = $resultado1->fetch_assoc()) {
  $duracion=  $tem['minutos'] .":" . $tem['segundos'];
  if ($duracion=="0:0")
      $duracion="";
 
    
    echo "<tr bgcolor= #ff8080>";
     echo "<td>" . $tem['numero'] ."</td>\n";
     echo "<td>" . $tem['nombre'] ."</td>\n";
     echo "<td>" . $duracion ."</td>\n";
    echo "</tr>";
}
?>
		
		
		</table>
<?php 
$resultado3= $conexion -> query("SELECT texto".
    " FROM discos WHERE id=$idDisco");

echo "<h3>Comentarios</h3>";
while($comentario = $resultado3->fetch_assoc())
    echo $comentario['texto'];
    
?>

</body>
<footer><a href=index.php>Volver</a> a la lista de discos.</footer>
</html>