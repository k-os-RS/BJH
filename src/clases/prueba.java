package clases;

import java.util.*;

public class prueba {

//	public static void main(String[] args) {
//		Scanner teclado = new Scanner(System.in);
//		String email;
//		
//		do {
//			System.out.print("DNI: ");
//			email = teclado.nextLine();
//			isDNI(email);
//			
//		} while (email != "salir");
//		
//
//	}
//	
//	//Comprobacion de validez 
//    public static void isDNI (String dni) {
//        boolean valido = false;
//        int caracter= 0, miDNI = 0, resto = 0, i= 0;
//        char letra = ' ';
//        char[] asigLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
//        
//        //Comprobamos que el DNI introducido tiene una longitud de 9 caracterez y que el ultimo caracter es un letra
//        if(dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
//        	do {
//                caracter = dni.codePointAt(i);
//                valido = (caracter > 47 && caracter < 58);
//                i++;
//            } while(i < dni.length() - 1 && valido);
//        }//Fin del if
//        if(valido) {
//        	//Validamos que la letra corresponda al DNI
//            letra = Character.toUpperCase(dni.charAt(8));
//            miDNI = Integer.parseInt(dni.substring(0,8));
//            resto = miDNI % 23;
//            valido = (letra == asigLetra[resto]);
//        }//Fin del if
//        
//        System.out.println(asigLetra[resto]);
//
//    }

}
