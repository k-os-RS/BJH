//Comprobar DNI
        function comprobacion(e) {
          var i = 0;
          var dni = document.frmEntrar.txtDNI.value;
          var letra = document.frmEntrar.sLetra.value;
          var valido = true;
          var resto;

          alert(letra);

          if (dni == "") {
            alert("Complete el campo DNI");
            document.frmEntrar.txtDNI.value = "";
            document.frmEntrar.txtDNI.focus();
            e.preventDefault();
            return 0;
          }
          if (dni.length < 8) {
            alert("Ponga los ocho números del DNI");
            document.frmEntrar.txtDNI.value = "";
            document.frmEntrar.txtDNI.focus();
            e.preventDefault();
            return 0;
          }
          do {
            caracter = dni.codePointAt(i);
            valido = (caracter > 47 && caracter < 58);
            i++;
          } while (i < dni.length && valido);
          if (!valido) {
            alert("Ponga su DNI sin letras");
            document.frmEntrar.txtDNI.value = "";
            document.frmEntrar.txtDNI.focus();
            e.preventDefault();
            return 0;
          }
          if (valido) {
            resto = dni % 23;
          }
        }

        function validar(e) {
          comprobacion(e);
        }

        document.frmEntrar.addEventListener("submit", validar);