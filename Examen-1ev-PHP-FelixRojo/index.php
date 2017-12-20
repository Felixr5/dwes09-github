<?php 
session_start();
include 'conexionAlumno.php';
if (!isset($_SESSION['categoria']))
    $_SESSION['categoria']="Álbumes";
if (isset($_REQUEST['tipo']))
    $_SESSION['categoria']=$_REQUEST['tipo'];

    
    
    $TA = '<a href= '.$_SERVER['PHP_SELF'].'?res=TA> &#9652 </a>';
    $TZ = '<a href= '.$_SERVER['PHP_SELF'].'?res=TZ> &#9662</a>';
    $AA = '<a href='.$_SERVER['PHP_SELF'].'?res=AA> &#9652 </a>';
    $AZ = ' <a href= '.$_SERVER['PHP_SELF'].'?res=AZ> &#9662 </a>';
    
    if (! isset($_REQUEST['res'])){
        $order ='nombre asc';
        $TA='&#9652';
    }else{
    if ($_REQUEST['res']=="TA"){
        $order ='nombre asc';
        $TA='&#9652';
    }
    if ($_REQUEST['res']=="AA"){
        $order ='year asc';
        $AA='&#9652';
    }
    if ($_REQUEST['res']=="AZ"){
        $order ='year desc';
        $AA='&#9662';
    }
    
    if ($_REQUEST['res']=="TZ"){
        $order ='nombre desc';
        $TZ='&#9662';
    }
    }
$resultado= $conexion -> query("SELECT DISTINCT tipo FROM discos");


if (isset($_POST['busqueda']) && $_POST['busqueda']!="")
    $busq="and nombre LIKE '".$_POST['busqueda']."' ";
else 
    $busq="";
    
    
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
<h2 style="color:red;text-align:center;">INDEX. Mostrando <?php echo $_SESSION['categoria'];?> </h2>
    
    
    <div  style=float:left;>
    <p style="font-weight: bold;">Selecciona una categoria</p>
    <ol><?php
    while ($tiposDisco = $resultado->fetch_assoc())
    echo "<li><a href=index.php?tipo=".$tiposDisco['tipo'].">".$tiposDisco['tipo']."</a></li>";
    ?>
    </ol>
    
    </div>
    <div>
    <table style='border: 0;float:left'>
		<tr style='background-color: silver'>
			<th>Título  <?php echo $TA ?>
						<?php echo $TZ?></th>
			
			<th>Discográfica</th>
			
			<th>Año <?php echo $AA ?>
			 <?php echo $AZ?></th>
			
			<th>Formato</th>
			
			<th>Portada</th>
		
		
		</tr>
<?php 

$resultado1= $conexion -> query("SELECT nombre as Título, discografica as Discográfica, year as Año, soporte as Formato, imagen as Portada". 
    " FROM discos WHERE tipo='". $_SESSION['categoria'] ."' ".$busq." order by ".$order);
$idID=$conexion -> query("SELECT id".
    " FROM discos WHERE tipo='". $_SESSION['categoria'] ."' ".$busq." order by ".$order);
if ($resultado1->num_rows === 0){
    echo "<tr bgcolor= #ff8080>";
    echo "<td colspan=5>No hay canciones en la base de datos con ese nombre en esta categoria.</td>";
    echo "</tr>";
}else
       while ($dis = $resultado1->fetch_assoc()) { 
           $identi=$idID->fetch_assoc();
           $dis['Portada']="<a href=disco.php?disco=".$identi['id']."><img src=./img/discografia/".$dis['Portada'].".jpg height=150  /></a>";
            echo "<tr bgcolor= #ff8080>";
            foreach  ($dis as $can){
                echo "<td>" . $can ."</td>\n";
            }
            echo "</tr>";
       }
?>
    </table>
   <form action=" <?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?> " method="post" style="padding-top:4px">
<label>Introduce el disco a buscar.</label><br><input type="text" name="busqueda" >
		<br><input type="submit">
</form>
    </div>
    
    
    
    
    
    
    
</body>
<footer><a href="admin-login.php">login de administrador</a></footer>
</html>
