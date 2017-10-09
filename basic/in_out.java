/**
 * System.in (stream predefinido) -> inputStreamReader -> BufferedReader
 * InputStreamReader: Flujo de entrada que convierte bytes en caracteres
 * BufferedReader: proporciona un buffer
 * System.out (stream de salida predefindo)
 * Para consola utilizar PrintWriter en lugar de system.out directamente. Soporta métodos print y println
 *
 * FileOutputStream -> escribir en un fichero
 * FileInputStream -> leer de un fichero. Extiende Reader, clase abstracta para leer flujos de catacteres
 * que implementa el interface Readable.
 * Estas dos clases tratan las entradas y salidas como integers.
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

		FileOutputStream fo = new FileOutputStream("javatest.txt");
		PrintWriter pw = new PrintWriter(System.out, true);
		do {
			c = (char) br.read(); //retorna un int. Pues tiene que retornar -1 y valores entre 0-255, y char es entre -128 y 127.
//			System.out.println(c);
			pw.println(c);
			fo.write(c);
		} while (c != 'q');
		fo.close();

		int cr;

		System.out.println("Leemos el contenido que acabamos de escrbir en un fichero");
		FileInputStream fi = new FileInputStream("javatest.txt");
		while ((cr = fi.read()) != -1) { //Lee un integer, no un char. -1 es fin de fichero.
			System.out.print( (char) cr);
		} 
		fi.close();
	}
}
