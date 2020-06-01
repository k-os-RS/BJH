package clases;

import java.util.*;

public class prueba {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		
		do {
			numero = (int)(Math.random()*9999+1);
			System.out.println(numero);
			
		} while (numero == 10 );
		
    }

}
