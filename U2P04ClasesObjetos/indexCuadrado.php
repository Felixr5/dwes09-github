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
    include 'Cuadrado.php';
    $cuad = new Cuadrado();
    $cuad->altura= $_POST['altura'];
    $cuad->base= $_POST['base'];
    
    echo "El area es ".$cuad->calcularArea();
    echo "<br>El perimetro es ".$cuad->calcularPerimetro();
    
    }

?>

</body>
