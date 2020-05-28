/*-- Facilitamos la introduccionde datos --*/
formulario.email.focus();
/*-- Quitamos el boton de intro para que nose envie el formulario por error --*/
window.addEventListener("keypress", function(event){
    if (event.keyCode == 13){
        event.preventDefault();
    }
}, false);
/*-- Para pasar de pagina en index --*/
function pasa(){
    document.getElementById("uno").style.display = 'none';
    document.getElementById("dos").style.display = 'block' ;
    document.getElementById("registro").style.display = 'block' ;
    document.getElementById("cuenta").style.display = 'none';
    document.getElementById("siguiente").style.display = 'none';
    document.getElementById("Keh").style.display = 'none';
    document.getElementById("cont").style.height = '450px';
    if (window.innerWidth > 1800) {
        alert(window.innerWidth);
        document.getElementById("cont").style.height = '650px';
    }
    formulario.nombre.focus();
}
/*-- validamos los primeros datos de index --*/
function validar() {
    /*-- variables generales --*/
    var email,contrasena,comprueba,expresion;
    email = document.getElementById("email").value;
    contrasena = document.getElementById("contrasena").value;
    comprueba = document.getElementById("comprobar").value;
    expresion = /\w+@+\w+\.+[a-z]/;
    /*-- Comprueba que el email y la contraseña son escritos --*/
    if( email ===""  || contrasena ==="") {
        alert('Todos los campos son obligatorios');
        document.getElementById("email").focus();
        return false;
    }
    /*-- Comprueba que el email no supera el limite de caracteres --*/
    else if(email.length>50) {
        alert("Tu email supero mi vision de 'nadie hará esto', Congratulations \nBueno debe de ser menor que 50 caracteres #CreateUnoNuevo");
        document.getElementById("email").focus();
        return false;
    }
    /*-- Comprueba que el email tenga un formato valido --*/
    else if(!expresion.test(email)) {
        alert("Tu email no es valido, compruebalo");
        document.getElementById("email").focus();
        return false;
    }
    /*-- Comprueba que la contraseña no supera el limite de caracteres --*/
    else if(contrasena.length>50) {
        alert("Tu contraseña excede todo rango de seguridad, seguro es perfecto. \nBueno debe de ser menor que 50 caracteres, nadie te va a quitar nada aqui.");
        document.getElementById("contrasena").focus();
        return false;
    }
    /*-- Comprueba que la contraseña no supera el limite de caracteres --*/
    else if(comprueba.length>50) {
        alert("Tu contraseña excede todo rango de seguridad, pero te equivocaste al confirmar. \nBueno debe de ser menor que 50 caracteres, nadie te va a quitar nada aqui.");
        document.getElementById("comprueba").focus();
        return false;
    }
    /*-- Comprobar que la contraseña coincide con la otra --*/
    else if( contrasena != comprueba) {
        alert('Las contraseñas no coinciden');
        document.getElementById("comprobar").focus();
        return false;
    }
    /*-- pasa pagina --*/
    else{
        pasa();
    }
}
/*-- Validamos los datos de registro en la segunda pagina de index --*/
function registro() {
    /*-- variables generales --*/
    var nombre,apellidos,direccion,dni,usuario;
    nombre = document.getElementById("nombre").value;
    apellidos = document.getElementById("apellidos").value;
    dni = document.getElementById("dni").value;
    direccion = document.getElementById("direccion").value;
    usuario = document.getElementById("usuario").value;
    /*-- Comprobamos que tenemos todos los campos rellenados --*/
    if(nombre ==="" || apellidos ===""  || dni === "" || direccion ==="" || usuario ==="") {
        alert('Todos los campos son obligatorios');
        document.getElementById("nombre").focus();
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
        alert("Tu DNI debe tener 8 numeros y una letra. \nNo llegaste a los 9 caracteres.");
        document.getElementById("dni").focus();
        return false;
    }
    /*-- Comprobamos que el DNI cumple con los requisitos --*/
    else if(dni.length == 9) {
        /*-- variables para el dni --*/
        var letraDni,numDni,operacion,charDni,caracter,i;
        i = 0;
        numDni = dni.substring(0,8);
        alert(numDni); 
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
            alert("Introduzca su DNI con números");
            document.getElementById("dni").value = "";
            document.getElementById("dni").focus();
            return false;
          }
        /*-- Comprobamos que la letra del dni sea la correcta --*/
        if(charDni[operacion] != letraDni) {
            alert('La letra de tu DNI es incorrecta compruebela')
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