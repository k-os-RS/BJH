package clases;
import java.time.*;
public class comprobaciones {
	
	//Comprobacion de validez 
    public boolean isDNI (String dni) {
        boolean valido = false;
        int caracter= 0, miDNI = 0, resto = 0, i= 0;
        char letra = ' ';
        char[] asigLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        //Comprobamos que el DNI introducido tiene una longitud de 9 caracterez y que el ultimo caracter es un letra
        if(dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
        	do {
                caracter = dni.codePointAt(i);
                valido = (caracter > 47 && caracter < 58);
                i++;
            } while(i < dni.length() - 1 && valido);
        }//Fin del if
        if(valido) {
        	//Validamos que la letra corresponda al DNI
            letra = Character.toUpperCase(dni.charAt(8));
            miDNI = Integer.parseInt(dni.substring(0,8));
            resto = miDNI % 23;
            valido = (letra == asigLetra[resto]);
        }//Fin del if
        
        return valido;
    }
    
    public boolean isEmail (String email) {
    	boolean valido = false;
    	
    	if (email.indexOf('@') != -1 && email.indexOf('.') != -1) {
    		valido = true;
    	} else {
    		valido = false;
    	}
    	
    	return valido;
    	
    }

	//Obtencion de la fecha y hora actual
    public String isFechaActual () {
    	String fechanow, dia, mes, anio;
    	
    	LocalDateTime fechas = LocalDateTime.now();
    	LocalDate fecha = fechas.toLocalDate();
    	//Cambia el orden
    	fechanow= fecha.toString();
    	dia= fechanow.substring(8, 10);
    	mes= fechanow.substring(5, 7);
    	anio= fechanow.substring(0, 4);
    	fechanow= dia+"/"+mes+"/"+anio;

    	return fechanow;
    }
    public String isHoraActual () {
    	String horanow;
    	int pospunto;
    	
    	LocalDateTime horas = LocalDateTime.now();
    	LocalTime hora = horas.toLocalTime();
    	//Quita los milisegundos
    	horanow= hora.toString();
    	pospunto= horanow.indexOf('.');
    	horanow= horanow.substring(0, pospunto);

    	return horanow;
    }
//	comprobaciones ia= new comprobaciones();
//	System.out.println(ia.isFechaActual());
//	System.out.println(ia.isHoraActual());
	
}
