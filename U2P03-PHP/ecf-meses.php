<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>


<?php

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un valor (Meses)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Valor: <input type="text" name="cad"> <br/>
		Bisiesto: <input type="radio" name="bis" >   
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $meses = array("Enero" => 31, "Febrero" => 28, "Marzo" => 31,"Abril" => 30,"Mayo" => 31,"Junio" => 30,"Julio" => 31,"Agosto" => 31,"Septiembre" => 30,"Octubre" => 31,"Noviembre" => 30,"Diciembre" => 31);
    $meses2 = array("1" => 31, "2" => 28, "3" => 31, "4" => 30, "5" => 31, "6" => 30, "7" => 31, "8" => 31, "9" => 30, "10" => 31, "11" => 30, "12" => 31);
      $valido=false;
    foreach ($meses as $mes => $numero){
        if (strcasecmp($mes, $_POST['cad']) == 0) {
            if (strcasecmp($mes, "Febrero")==0 && isset($_POST['bis']))  {
                echo  "Tiene ". ($numero+1) ." días";
                $valido=true;
            }else{
                echo  "Tiene $numero días";
                $valido=true;
            }
        }
    }
    
    foreach ($meses2 as $mes => $numero){
        if (strcasecmp($mes, $_POST['cad']) == 0) {
            if (strcasecmp($mes, "2")==0 && isset($_POST['bis']))  {
                echo  "Tiene ". ($numero+1) ." días";
                $valido=true;
                
            }else{
                $valido=true;
                echo  "Tiene $numero días";
            }
        }
    }
      
    if ($valido==false){
        echo "No se ha introducido un valor valido.";
    }
}
echo "<a href='index.php'> <h3>Volver</h3> </a>";
?>

</body>
</html>