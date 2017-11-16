<?php
session_name('P08');
session_start();
if (!isset($_SESSION['nombre']))
    header("Location: registro.php");
else if (!isset($_SESSION['test1'])) 
    header("Location: test1.php");
    

 if (isset($_POST['enviar'])){
     if ($_POST["resp"]=="Home")
         $_SESSION['test2']="acierto";
         else
             $_SESSION['test2']="fallo";
             
             
             
     if (isset($_SESSION['test2']))
        header("Location: test3.php");
        
    
    
    
    
 } 
?> 


 
 <html>
<head>
<title>Test2</title>
<meta charset="UTF-8" />
</head>
<body>
 
 <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		<label>Elige una de las siguientes respuestas a esta pregunta: ¿Cuál de los siguientes no es el nombre de un cantante?<br></label>
		 <input type="radio" name="resp" value="Pump"> Lil Pump<br>
  		 <input type="radio" name="resp" value="Xan"> Lil Xan<br>
 		 <input type="radio" name="resp" value="Wayne"> Lil Wayne<br/>
 		 <input type="radio" name="resp" value="Home"> Lil Home<br/>
 		 <input type="radio" name="resp" value="Uzi"> Lil Uzi Vert<br/>
 		 <input type="submit" value="Enviar" name="enviar">
	</form>
	
	
	
</body>
</html>