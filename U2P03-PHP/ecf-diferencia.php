<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 



if (! isset($_POST['Enviar*'])) {
    ?>
    <h2>Introduce 2 numeros (*)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		A: <input type="text" name="a"> <br/>
		B: <input type="text" name="b"> 
		<input type="submit" name="Enviar*">
	</form>
	<?php 
} else {
    $a=$_POST["a"];
    $b=$_POST["b"];
    
    while ($a!=$b) {
        if ($a>$b) {
            $b+=1;
            echo "*";
        }else {
            $a+=1;
            echo "*";
        }
    }
}   

if (! isset($_POST['Enviar#'])) {
    ?>
    <h2>Introduce 2 numeros (#)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		A: <input type="text" name="a"> <br/>
		B: <input type="text" name="b"> 
		<input type="submit" name="Enviar#">
	</form>
	<?php 
} else {
    $a=$_POST["a"];
    $b=$_POST["b"];
    if ($a<$b) {
        $tope=$b-$a;
    }elseif ($b<$a){
        $tope=$a-$b;
    }
    
    for ($i = 0; $i < $tope; $i++) {
        echo "#";
    }
   
    
} 


echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>