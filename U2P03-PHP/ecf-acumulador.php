<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    $_POST["num"]=0;
    $_POST["ac"]=0;
    $ac=0;
 }
        if ($_POST['ac']<50) {
            echo " <h3>Aun no se ha llegado a 50 </h3>";
            
        ?>
    
    <h2>Introduce un numero (Acumulador)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<?php $ac=$_POST["num"]+$_POST["ac"];?>
		<input type="hidden" value=<?php echo $ac ;?> name="ac">
		<input type="submit" name="Enviar">
	</form>
	<?php } else{
	           echo " Ya se ha llegado a 50 ";
          } 	    




echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>