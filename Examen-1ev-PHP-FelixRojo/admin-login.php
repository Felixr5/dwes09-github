<?php
session_start();

$mensajeError="";
$pass="";
$user="";
$_SESSION['admin']=0;

if (isset($_REQUEST['log'])){
    $_SESSION['admin']=0;
    header('Location:index.php');
}


if (isset($_POST["enviar"])) {
    
    $pass = $_POST["pass"];
    $user=$_POST["user"];
    
        if ($pass == "secreto" && $user =="admin")
            $_SESSION['admin']=1;
        else
         $mensajeError="Login incorrecto.";
 
    }
    

?>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
    footer {
  position: fixed;
  right: 0;
  bottom: 0;
  left: 0;
  padding: 1rem;
  background-color: #efefef;
  text-align: center;
}</style>
</head>
<?php include 'header.php';?>

<body>
<h3 style="color:red;">LOGIN </h3>

<?php if ($_SESSION['admin']==0){        echo "<p style=color:red>$mensajeError</p>";?>

    <form action="admin-login.php" method="POST">
        Usuario: <input type="text" name="user"><br>
        Contraseña <input type="password" name="pass"><br>
        <input type="submit" value="Enviar" name="enviar">
    </form>
    <?php }else if ($_SESSION['admin']==1){  ?>
    <h2>Bienvenido al login de administrador.</h2>
    <a href='admin-baja.php'>Haz click aqui para dar de baja un tema.</a>
    <?php }?>
</body>

<footer><a href='admin-login.php?log=out'>Haz click aqui para cerrar sesion y volver a la pagina prnicipal.</a></footer>

</html>
