<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Factorial)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    $fac=1;
  echo "El factorial de $num es ";
  for ($i = 1; $i <= $num; $i++) {
      $fac*=$i;
  }
  echo "$fac";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>