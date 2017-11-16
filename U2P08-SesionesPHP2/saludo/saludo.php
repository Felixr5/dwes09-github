<?php

$name = "idSesionSaludo09";
session_name($name);
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (isset($_REQUEST["cerrarSesion"])) {
    $_SESSION=array();
    session_unset();
    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(session_name(), '', time() - 42000,
            $params["path"], $params["domain"],
            $params["secure"], $params["httponly"]
            );
    }
    session_destroy();
    header("Location: ".$_SERVER['PHP_SELF']);
}



$_SESSION['error']="";
if(isset($_POST["enviar"]))
    if ($_POST["nombre"]=="")
        $_SESSION['error']="EL campo de nombre se encuentra vacío.";
        else{
            $_SESSION['nombre'] = $_POST["nombre"];
            $_SESSION['error']="";
        }
        
        
        
        ?>


<html>
<head>
<title>Saludo</title>
<meta charset="UTF-8" />
</head>
<body>
<?php if(!isset( $_SESSION['nombre'])) {?>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
		<label>Escribe tu nombre para dirigirnos a ti:</label> <input
			type="text" name="nombre"><br /> <input type="submit" value="Enviar"
			name="enviar">
	</form>
<?php	
if ($_SESSION['error']!="")
    echo $_SESSION['error'];
} else
    echo "<h2>Damos la bienvenida a ". $_SESSION['nombre'] ."</h2>";

?>
<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>

</body>
</html>