<?php
session_name('P08');
session_start();
if (!isset($_SESSION['nombre']))
    header("Location: registro.php");
    else if (!isset($_SESSION['test1']))
        header("Location: test1.php");
        else if (!isset($_SESSION['test2']))
            header("Location: test2.php");
            else if (!isset($_SESSION['test3']))
                header("Location: test3.php");

                $c=0;
                
                
                if ($_SESSION['test1']=="acierto")
                    $c+=1; 
                if ($_SESSION['test2']=="acierto")
                    $c+=1; 
                if ($_SESSION['test3']=="acierto")
                    $c+=1;
                
                    ?>
 
 <html>
<head>
<title>Test1</title>
<meta charset="UTF-8" />
</head>
<body>
<?php echo "<h2>Se han respondido ".$c." preguntas correctamente.</h2>"?>



<h3>Empieza <a href="registro.php?deNuevo=true">de nuevo</a> el test</h3>
	
</body>
</html>