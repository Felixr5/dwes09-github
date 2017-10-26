<!DOCTYPE html>
<html>
<head>
<style>
 table,th,td {
     border: 1px solid black;
}
th,td{
  padding: 3px;
}
</style>
<meta charset="UTF-8" />
</head>
<body>
<?php 

if (! isset($_POST['Enviar'])) {
    ?>
    <h2>Introduce un numero (Cuadrado)</h2>
	<form action=" <?php echo $_SERVER['PHP_SELF']; ?> " method="post">
		Numero: <input type="text" name="num"> <br/>
		<input type="submit" name="Enviar">
	</form>
	<?php 
} else {
    $num=$_POST["num"];
    echo "<table>";
    for ($i = 1; $i <= $num; $i++) {
        if ($i%2==0){
        echo "<tr bgcolor='lightblue'>";
        }else{
            echo "<tr>";
            
        }
        for ($j = 1; $j <= $num; $j++) 
             echo "<td>".$i*$j."</td>";
            
        
    }
        echo "</tr>";
    

echo "<table>";
}
echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>