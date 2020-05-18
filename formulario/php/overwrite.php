<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Correciones</title>
    </head>
    <body>
        <?php
            /*-- Conexion a la base de datos --*/
            $link = mysqli_connect("localhost", "root","");
            mysqli_select_db($link,"bjh");
            /*-- Variables --*/
            $Nombre = $_POST["nombre"];
            $Apellidos = $_POST["apellidos"];
            $Direccion = $_POST["direccion"];
            $Dni = $_POST["dni"];
            $Usuario = $_POST["usuario"];
            $result=mysqli_query($link,"select*from persona");
            $bug="INSERT INTO persona VALUES ('$Nombre','$Apellidos','$Dni','$Direccion','$Usuario')";
            /*-- Registro de cliente --*/
            if($bug) {
                /*-- Variables de uso general --*/
                $comprueba = mysqli_query($link, "SELECT * FROM persona where DNI = '$Dni'");
                /*-- Comprobamos que es la contraseña correcta --*/
                $array = mysqli_fetch_array($comprueba);
                if(strcmp ($array['DNI'],$Dni) != 0) {
                    echo "
                    <head> 
                        <link rel='stylesheet' href='../css/php.css'>
                    </head>
                    <body>
                        <div class='php' id='head'>
                            <h2>BJH</h2>
                        </div>
                        <div class='php'>
                            <h1>Ese DNI no corresponde a ningún usuario</h1> <hr>
                            <a href='/formulario/log.html'>
                                <input class='nuevo' type='button' value='Probar de nuevo'>                          
                            </a>
                        </div>
                    </body>
                    ";
                }
                /*-- Le damos la bienvenida y que vaya a la app --*/
                else if (strcmp ($array['DNI'],$Dni) == 0){
                    mysqli_query($link,"UPDATE persona SET name='$Nombre', last_names='$Apellidos', address='$Direccion',username='$Usuario' WHERE DNI='$Dni'");
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