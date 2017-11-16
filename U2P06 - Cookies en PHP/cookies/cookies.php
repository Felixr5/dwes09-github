<?php

setcookie("test", "test", time() + 3600, '/');
if(count($_COOKIE) ==0) echo "<h3>Advertencia: tu navegador tiene las cookies deshabilitadas. Esta aplicación no funcionará</h3>";

if (isset($_REQUEST["visit"])){
    setcookie("visitante","caducada", time() - 15, "/U2P06%20-%20Cookies%20en%20PHP/cookies");
}
if(isset($_POST["enviar"])) {
    header("Location: ".$_SERVER['PHP_SELF']);
    setcookie("visitante", $_POST["nombre"], time() + (86400 * 15), "/U2P06%20-%20Cookies%20en%20PHP/cookies"); // 86400 = segundos en 1 día

        
}
if(isset($_COOKIE["visitante"])) {
   
    echo "<h2>Damos la bienvenida a $_COOKIE[visitante]</h2>";
}
else
{ // solicitar nombre al usuario
    
?> 


<html>
<head>
<title>Cookies</title>
<meta charset="UTF-8"/>
</head>
<body>

<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    <label>Escribe tu nombre para dirigirnos a ti:</label>
    <input type="text" name="nombre"><br/>
    <input type="submit" value="Enviar" name="enviar">
</form>
<?php
}


?>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>?visit=false">Borrar Cookie</a></p>

<p><a href="<?php echo $_SERVER['PHP_SELF']?>">Enlace a esta misma página</a></p>
</body></html>