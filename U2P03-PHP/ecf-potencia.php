<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce dos numeros</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero1: <input type="text" name="num1"> <br/>
		Numero2: <input type="text" name="num2"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num1=$_POST["num1"];
    $num2=$_POST["num2"];
    $potencia=1;
  echo "La potencia es ";
  for ($i = 1; $i <= $num2; $i++) {
      $potencia*=$num1;
  }
  echo "$potencia";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>