<?php   
session_name('P08');
session_start();
if (!isset($_SESSION['nombre']))
    header("Location: registro.php");
    else if (!isset($_SESSION['test1']))
        header("Location: test1.php");
        else if (!isset($_SESSION['test2']))
            header("Location: test2.php");
            
            
            
            
            if (isset($_POST['enviar'])){
                if ($_POST["resp"]=="Poe")
                   $_SESSION['test3']="acierto";
                else
                   $_SESSION['test3']="fallo";
                        
                if (isset($_SESSION['test3']))
                  header("Location: resultados.php");
                            
                            
            }
?> 



 
 <html>
<head>
<title>Test3</title>
<meta charset="UTF-8" />
</head>
<body>
 
 <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		<label>Elige una de las siguientes respuestas a esta pregunta: ¿Cuál de los siguientes autores no es Inglés?<br></label>
		 <input type="radio" name="resp" value="Poe"> Edgar Allan Poe<br>
  		 <input type="radio" name="resp" value="Dickens"> Charles Dickens<br>
 		 <input type="radio" name="resp" value="Shakespeare"> William Shakespeare<br/>
 		 <input type="submit" value="Enviar" name="enviar">
	</form>
	
	
	
</body>
</html>