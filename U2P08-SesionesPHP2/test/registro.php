<?php
 session_name('P08');
  session_start();

if (isset($_POST['enviar'])) {
	$_SESSION['nombre']=$_POST['nombre'];
    header("Location: index.php");
    }
if (isset($_REQUEST["deNuevo"])) {
        $_SESSION=array();
     }

     if (isset($_SESSION['nombre']))
      header("Location: index.php");
  
    
    
    
    if (isset($_POST['nombre'])) {
    }
    
 ?>

 
 <html>
<head>
<title>Registro</title>
<meta charset="UTF-8" />
</head>
<body>
 
 <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		<label>Escribe tu nombre para dirigirnos a ti:</label> <input
			type="text" name="nombre"><br /> <input type="submit" value="Enviar"
			name="enviar">
	</form>
	
	
	
</body>
</html>