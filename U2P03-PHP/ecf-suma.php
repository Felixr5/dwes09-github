<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];  
    
    $x=0;
 for ($i = 0; $i <= $num; $i++) {
     $x+=$i;
 }  
    echo "El total de los $num numeros naturales es $x";
}



echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>