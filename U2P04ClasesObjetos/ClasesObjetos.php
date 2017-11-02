<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 
if (! isset($_POST['Enviar'])) {
    ?>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Base: <input type="text" name="base"> <br/>
		Altura: <input type="text" name="altura"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    include 'Triangulo.php';
    $triangulo = new Triangulo();
    $triangulo->altura= $_POST['altura'];
    $triangulo->base= $_POST['base'];
    
    echo "El area es ".$triangulo->calcularArea();   
}

?>

</body>
