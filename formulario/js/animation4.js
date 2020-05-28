window.onload=iniciar();
/*-- Al iniciar tiene que señalar el email y ocultar error --*/
function iniciar(){
    formulario.nombre.focus();
    document.getElementById("nombreE").style.display='none';
    document.getElementById("apellidoE").style.display='none';
    document.getElementById("dniE").style.display='none';
    document.getElementById("direccionE").style.display='none';
    document.getElementById("usuarioE").style.display='none';
}
/*-- Validar los datos introducidos --*/
function validar() {
    /*-- variables generales --*/
    var nombre,apellidos,direccion,dni,usuario;
    nombre = document.getElementById("nombre").value;
    apellidos = document.getElementById("apellidos").value;
    dni = document.getElementById("dni").value;
    direccion = document.getElementById("direccion").value;
    usuario = document.getElementById("usuario").value;
    /*-- Comprobamos que tenemos todos los campos rellenados --*/
    if(nombre === "" && apellidos === ""  && dni === "" && direccion === "" && usuario === "") {
        alert('Todos los campos son obligatorios');
        document.getElementById("nombre").focus();
        return false;
    }
    else if (nombre === "") {
        document.getElementById("nombreE").style.display='block';
        document.getElementById("nombreE").style.color='red';
        document.getElementById("nombreE").innerHTML = ("Escribe tu nombre");
        document.getElementById("cont2").style.height = '550px';
        document.getElementById("nombre").focus();
        return false;
    }
    else if (apellidos === "") {
        document.getElementById("apellidoE").style.display='block';
        document.getElementById("apellidoE").style.color='red';
        document.getElementById("apellidoE").innerHTML = ("Escribe tus apellidos");
        document.getElementById("cont2").style.height = '550px';
        document.getElementById("apellidos").focus();
        return false;
    }
    else if (dni === "") {
        document.getElementById("dniE").style.display='block';
        document.getElementById("dniE").style.color='red';
        document.getElementById("dniE").innerHTML = ("Escribe tu dni");
        document.getElementById("cont2").style.height = '550px';
        document.getElementById("dni").focus();
        return false;
    }
    else if (direccion === "") {
        document.getElementById("direccionE").style.display='block';
        document.getElementById("direccionE").style.color='red';
        document.getElementById("direccionE").innerHTML = ("Escribe tu direccion");
        document.getElementById("cont2").style.height = '550px';
        document.getElementById("direccion").focus();
        return false;
    }
    else if (usuario === "") {
        document.getElementById("usuarioE").style.display='block';
        document.getElementById("usuarioE").style.color='red';
        document.getElementById("usuarioE").innerHTML = ("Escribe tu usuario");
        document.getElementById("cont2").style.height = '490px';
        document.getElementById("usuario").focus();
        return false;
    }
    /*-- Comprobamos que el nombre no supere el limite establecido en la base de datos --*/
    else if(nombre.length > 50) {
        alert("Tu nombre? que eres. \nBueno debe de ser menor que 50 caracteres ponte un alias o algo.");
        document.getElementById("nombre").focus();
        return false;
    }
    /*-- Comprobamos que los apellidos no superen el limite establecido en la base de datos --*/
    else if(apellidos.length > 50) {
        alert("Tus apellidos? superaste mis espectativas. \nBueno debe de ser menor que 50 caracteres haz un acronimo y seguro cabe.");
        document.getElementById("apellidos").focus();
        return false;
    }
    /*-- Comprobamos que el DNI llegue a los caracteres que debe tener --*/
    else if(dni.length < 9) {
        document.getElementById("dniE").style.display='block';
        document.getElementById("dniE").style.color='red';
        document.getElementById("dniE").innerHTML = ("No llegaste a los 9 caracteres.");
        document.getElementById("cont2").style.height = '550px';
        document.getElementById("dni").focus();
        return false;
    }
    /*-- Comprobamos que el DNI cumple con los requisitos --*/
    else if(dni.length == 9) {
        /*-- variables para el dni --*/
        var letraDni,numDni,operacion,charDni,caracter,i;
        i = 0;
        numDni = dni.substring(0,8); 
        letraDni = dni.substring(8,9);
        operacion = numDni % 23;
        charDni = ["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"];
        /*-- Comprobamos que tenga 8 números --*/
        do {
            caracter = numDni.codePointAt(i);
            valido = (caracter > 47 && caracter < 58);
            i++;
          } while (i < numDni.length && valido);
          if (!valido) {
            document.getElementById("dniE").style.display='block';
            document.getElementById("dniE").style.color='red';
            document.getElementById("dniE").innerHTML = ("Introduzca su DNI con números");
            document.getElementById("cont2").style.height = '550px';
            document.getElementById("dni").focus();
            document.getElementById("dni").value = "";
            return false;
          }
        /*-- Comprobamos que la letra del dni sea la correcta --*/
        if(charDni[operacion] != letraDni.toUpperCase()) {
            document.getElementById("dniE").style.display='block';
            document.getElementById("dniE").style.color='red';
            document.getElementById("dniE").innerHTML = ('La letra de tu DNI es incorrecta compruebela');
            document.getElementById("cont2").style.height = '565px';
            document.getElementById("dni").focus();
            document.getElementById("dni").value = "";
            return false;
        }
    }
    /*-- Comprobamos que la direccion no supere el limite establecido en la base de datos --*/
    else if(direccion.length>50) {
        alert("Tu direccion si que es peculiar... siiiiiiiiiiiiii. \nBueno debe de ser menor que 50 caracteres quiza con siglas quepa, suerte.");
        document.getElementById("direccion").focus();
        return false;
    }
    /*-- Comprobamos que el usuario no supere el limite establecido en la base de datos --*/
    else if(usuario.length>50) {
        alert("Tu usuario sera cool pero asi de largo? para que? \nBueno debe de ser menor que 50 caracteres usa mas la cabeza.");
        document.getElementById("usuario").focus();
        return false;
    }
}
function invisible () {
    if (document.getElementById("nombreE").style.display='block') {
        document.getElementById("nombreE").style.display='none';
        document.getElementById("cont2").style.height = '515px';
    }
    if (document.getElementById("apellidoE").style.display='block') {
        document.getElementById("apellidoE").style.display='none';
        document.getElementById("cont2").style.height = '515px';
    }
    if (document.getElementById("dniE").style.display='block') {
        document.getElementById("dniE").style.display='none';
        document.getElementById("cont2").style.height = '515px';
    }
    if (document.getElementById("direccionE").style.display='block') {
        document.getElementById("direccionE").style.display='none';
        document.getElementById("cont2").style.height = '515px';
    }
    if (document.getElementById("usuarioE").style.display='block') {
        document.getElementById("usuarioE").style.display='none';
        document.getElementById("cont2").style.height = '515px';
    }
}