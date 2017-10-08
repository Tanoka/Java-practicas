/**
 * System.in (stream predefinido) -> inputStreamReader -> BufferedReader
 * InputStreamReader: Flujo de entrada que convierte bytes en caracteres
 * BufferedReader: proporciona un buffer
 * System.out (stream de salida predefindo)
 * Para consola utilizar PrintWriter en lugar de system.out directamente. Soporta métodos print y println
 */

package basic;

import java.io.*;

public class in_out {
	public static void main(String[] args) throws IOException {
		char c;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		En este caso no hay diferencia en utilizar buffer o no...
		InputStreamReader br = new InputStreamReader(System.in);
		System.out.println("Introduce caracteres y pulsa q para salir");

		PrintWriter pw = new PrintWriter(System.out, true);
		do {
			c = (char) br.read();
//			System.out.println(c);
			pw.println(c);
		} while (c != 'q');

	}
}
