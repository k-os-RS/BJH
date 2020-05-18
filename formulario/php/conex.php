<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bienvenido</title>
    </head>
    <body>
    <?php
        /*-- Conexion a la base de datos --*/
        $link = mysqli_connect("localhost", "root","");
        mysqli_select_db($link,"bjh");
        /*-- Variables --*/
        $Usuario = $_POST["usuario"];
        $Contrasena = $_POST["contrasena"];
        $result=mysqli_query($link,"select*from persona"); 
        //codigo
        $bug="INSERT INTO persona VALUES ('$Usuario','$Contrasena')";
        if ($bug){
            /*-- Variables de uso general --*/
            $comprueba = mysqli_query($link, "SELECT * FROM persona where username = '$Usuario'");
            /*-- Comprobamos que es la contraseña correcta --*/
            $array = mysqli_fetch_array($comprueba);
            if(strcmp ($array['password'],$Contrasena) != 0) {
                echo "
                <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Contraseña incorrecta</h1> <hr>
                            <a href='/formulario/log.html'>
                                <input class='nuevo' type='button' value='Probar de nuevo'>                          
                            </a>
                        </div>
                    </body>
                ";
            }
            /*-- Le damos la bienvenida y que vaya a la app --*/
            else if (strcmp ($array['password'],$Contrasena) == 0){
                $Nombre = $array["name"];
                $Apellidos = $array["last_names"];
                $Email = $array["email"];
                $Direccion = $array["address"];
                $Dni = $array["DNI"];
                echo "
                    <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Bienvenid@ <br> $Nombre $Apellidos</h1>
                            <h3>$Usuario, te agradecemos tu registro</h3>
                            <h3>DNI: $Dni</h3>
                            <h3>Dirección: $Direccion</h3>
                            <p>Alguno de tus datos está mal? si es así pulse Corregir</p>
                            <a href='/formulario/correccion.html'>
                                <input class='boton' type='button' value='Corregir'>
                            </a> <hr> 
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