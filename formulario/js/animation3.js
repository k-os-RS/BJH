/*-- Facilitamos la introduccionde datos --*/
formulario.email.focus();
/*-- Validar los datos introducidos --*/
function recupera() {
    /*-- variables generales --*/
    var email,dni,usuario,expresion;
    email = document.getElementById("email").value;
    dni = document.getElementById("dni").value;
    usuario = document.getElementById("usuario").value;
    expresion = /\w+@+\w+\.+[a-z]/;
    /*-- Comprobamos que tenemos todos los campos rellenados --*/
    if(email ==="" || dni === "" || usuario ==="") {
        alert('Todos los campos son obligatorios');
        document.getElementById("email").focus();
        return false;
    }
    /*-- Comprobamos que el usuario no supere el limite establecido en la base de datos --*/
    else if(usuario.length>50) {
        alert("Tu usuario sera cool pero asi de largo? para que? \nBueno debe de ser menor que 50 caracteres usa mas la cabeza.");
        document.getElementById("usuario").focus();
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
            return false;
        }
    }
}