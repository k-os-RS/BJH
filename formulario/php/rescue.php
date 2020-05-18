<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Al rescate</title>
    </head>
    <body>
    <?php
        /*-- Conexion a la base de datos --*/
        $link = mysqli_connect("localhost", "root","");
        mysqli_select_db($link,"bjh");
        /*-- Variables --*/
        $Usuario = $_POST["usuario"];
        $Email = $_POST["email"];
        $Dni = $_POST["dni"];
        $result=mysqli_query($link,"select*from persona"); 
        //codigo
        $bug="INSERT INTO persona VALUES ('$Usuario','$Email,$Dni')";
        if ($bug){
            /*-- Variables de uso general --*/
            $comprueba = mysqli_query($link, "SELECT * FROM persona where username = '$Usuario'");
            /*-- Comprobamos que es la contraseña correcta --*/
            $array = mysqli_fetch_array($comprueba);
            if(strcmp ($array['DNI'],$Dni) != 0 || strcmp ($array['email'],$Email) != 0) {
                echo "
                <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                        <h1>Datos incorrectos</h1> <hr>
                            <a href='/formulario/olvido.html'>
                                <input class='nuevo' type='button' value='Reintentar'> 
                            </a>
                        </div>
                    </body>
                ";
            }
            /*-- Le damos la bienvenida y que vaya a la app --*/
            else{
                $contrasena = $array["password"];
                echo "
                    <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Debe ser más cuidadoso la próxima vez</h1>
                            <h3>Su contraseña es :</h3>
                            <h2>$contrasena</h2><hr>
                            <a href='/formulario/log.html'>
                                <input class='nuevo' type='button' value='Volver a Inicio sesión'> 
                            </a>
                        </div>
                    </body>
                    ";
            }
        }
    ?>
    </body>
</html>