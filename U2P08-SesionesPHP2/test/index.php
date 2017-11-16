<?php
    session_name('P08');
    session_start();
    
    if (!isset($_SESSION['nombre']))
        header("Location: registro.php");
        

?> 


<html>
<head>
<title></title>
<meta charset="UTF-8"/>
</head>
<body>
<?php echo "<h1>Damos la bienvenida a ".$_SESSION['nombre']."</h1>"?>
<h3>Empieza <a href="test1.php">aquí</a> el test</h3>
</body></html>