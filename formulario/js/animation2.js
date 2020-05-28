window.onload=iniciar();
/*-- Al iniciar tiene que señalar el usuario y ocultar error --*/
function iniciar(){
    formulario.usuario.focus();
    document.getElementById("contrasenaE").style.display='none';
    document.getElementById("usuarioE").style.display='none';
}
/*-- Vuelve invisible el error cuando se solventa --*/
function invisible (){
    if (document.getElementById("usuarioE").style.display='block') {
        document.getElementById("usuarioE").style.display='none';
        document.getElementById("cont").style.height = '380px';
    }
    if (document.getElementById("contrasenaE").style.display='block') {
        document.getElementById("contrasenaE").style.display='none';
        document.getElementById("cont").style.height = '380px';
    }
}
/*-- validamos los datos --*/
function registro() {
    /*-- variables generales --*/
    var usuario,contrasena;
    usuario = document.getElementById("usuario").value;
    contrasena = document.getElementById("contrasena").value;
    /*-- Comprobamos que tenemos todos los campos rellenados --*/
    if( usuario === ""  && contrasena === "") {
        alert('Todos los campos son obligatorios');
        document.getElementById("usuario").focus();
        return false;
    }
    else if (usuario === "") {
        document.getElementById("usuarioE").style.display='block';
        document.getElementById("usuarioE").style.color='red';
        document.getElementById("usuarioE").innerHTML = ("Escribe tu usuario");
        document.getElementById("cont").style.height = '400px';
        document.getElementById("usuario").focus();
        return false;
    }
    else if (contrasena === "") {
        document.getElementById("contrasenaE").style.display='block';
        document.getElementById("contrasenaE").style.color='red';
        document.getElementById("contrasenaE").innerHTML = ("La contraseña es obligatoria");
        document.getElementById("cont").style.height = '410px';
        document.getElementById("contrasena").focus();
        return false;
    }
    /*-- Comprobamos que el usuario no supere el limite establecido en la base de datos --*/
    else if(usuario.length>50) {
        alert("Tu usuario sera cool pero asi de largo? para que? \nBueno debe de ser menor que 50 caracteres usa mas la cabeza.");
        document.getElementById("usuario").focus();
        return false;
    }
    /*-- Comprueba que la contraseña no supera el limite de caracteres --*/
    else if(contrasena.length>50) {
        alert("Tu contraseña excede todo rango de seguridad, seguro es perfecto. \nBueno debe de ser menor que 50 caracteres, nadie te va a quitar nada aqui.");
        document.getElementById("contrasena").focus();
        return false;
    }
}