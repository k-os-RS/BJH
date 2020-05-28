<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Registro</title>
    </head>
    <body>
        <?php
            /*-- Conexion a la base de datos --*/
            $link = mysqli_connect("localhost", "root","");
            mysqli_select_db($link,"bjh");
            /*-- Variables --*/
            $Nombre = $_POST["nombre"];
            $Apellidos = $_POST["apellidos"];
            $Email = $_POST["email"];
            $Direccion = $_POST["direccion"];
            $Dni = $_POST["dni"];
            $Usuario = $_POST["usuario"];
            $Contrasena = $_POST["contrasena"];
            $result=mysqli_query($link,"select*from cliente");
            $bug="INSERT INTO persona VALUES ('$Nombre','$Apellidos','$Email','$Dni','$Direccion','$Usuario','$Contrasena')";
            /*-- Registro de cliente --*/
            if($bug) {
                /*-- Variables para comprobacion --*/
                $num = '0';
                $comprueba = mysqli_query($link, "SELECT username FROM persona where username = '$Usuario'");
                $comprueba2 = mysqli_query($link, "SELECT username FROM persona where email = '$Email'");
                $array = mysqli_fetch_array($comprueba);
                $array2 = mysqli_fetch_array($comprueba2);
                /*-- Algoritmo para prevenir un falso array --*/
                if($array == "") {
                    $texto = '0';
                }else{
                    $prueba = count($array);
                    $texto = strval($prueba);
                }
                /*-- Comprobacion de usuario --*/
                if(strcmp ($texto,$num) !=0) {
                    echo "
                    <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Tu nombre de usuario ya está en uso</h1> <hr> 
                            <a href='/formulario/index.html'>
                            <input class='nuevo' type='button' value='Volver a registro'>                          
                        </a>
                        </div>
                    </body>
                    ";
                }
                /*-- Guardamos los datos --*/
                else{
                    echo "
                    <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Su cuenta ha sido registrada con ÉXITO</h1> <hr>
                            <a href='/formulario/log.html'>
                            <input class='boton' type='button' value='Iniciar sesión'>                          
                        </a>
                        </div>
                    </body>
                    ";
                    mysqli_query($link,"INSERT INTO persona(name,last_names,email,DNI,address,username,password,employee) VALUES ('$Nombre','$Apellidos','$Email','$Dni','$Direccion','$Usuario','$Contrasena','no')");    
                    $id_array = mysqli_fetch_array(mysqli_query($link, "SELECT id_persona FROM persona where username = '$Usuario'"));
                    $id = $id_array["id_persona"];
                    mysqli_query($link,"INSERT INTO cliente(id_persona_aux,purchases) VALUES ('$id',0)");
                }
            }
        ?>    
    </body>
</html>