<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 

echo "<h3>Múltiplos de 3 y 5 entre el 1 y el 1000</h3>";
for ($i = 0; $i < 1000; $i++) {
    if ($i%5==0 || $i%3==0) {
        echo "$i    ";
    }
}

echo "<h3>20 primeros múltiplos de 3 y 5.</h3>";
          $c=0;
for ($i = 1; $i <= 20; $i++) {
    do{
    $c+=1;
    }while ($c%5!=0 && $c%3!=0);
    
    
           
        
    echo "$c es el numero $i de 20";
    echo "<br/>";
}

      
      
echo "<br/>";
 




echo " <a href='index.php'> <h3>Volver</h3> </a> ";

?>

</body>
</html>