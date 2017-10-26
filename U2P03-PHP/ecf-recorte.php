<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce una cadena (Recorte)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Cadena: <input type="text" name="cad"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {

    for ($i = strlen($_POST["cad"]); $i >= 0; $i-- ){
      for ($j = 0; $j < $i; $j++ ){
          echo $_POST['cad'][$j];
          
          
      }
      
      echo "<br/>";
 }
} 



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>