<?php
session_name('P08');
session_start();
if (!isset($_SESSION['nombre']))
    header("Location: registro.php");

 if (isset($_POST['enviar'])){
     if ($_POST["resp"]=="2007")
         $_SESSION['test1']="acierto";
         else
             $_SESSION['test1']="fallo";
             
             
             
     if (isset($_SESSION['test1']))
        header("Location: test2.php");
        
    
    
    
    
 } 
?> 


 
 <html>
<head>
<title>Test1</title>
<meta charset="UTF-8" />
</head>
<body>
 
 <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		<label>Elige una de las siguientes respuestas a esta pregunta: ¿En que año empezó Skins (UK)?<br></label>
		 <input type="radio" name="resp" value="2005"> 2005<br>
  		 <input type="radio" name="resp" value="2009"> 2009<br>
 		 <input type="radio" name="resp" value="2007"> 2007<br/>
 		 <input type="submit" value="Enviar" name="enviar">
	</form>
	
	
	
</body>
</html>