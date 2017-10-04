/*
 *Compilar: javac -d . DoThings.java
 *	Crea un direcorio "basic" y los ficheros DoThings.class y One.class en el
 *Ejecutar: java basic.DoThings	
 *
 */

package basic;

class One {

	private static final int MAX_LISTA = 5; //Este viene a ser una constante

	private int var;
	private int[] lista = new int[MAX_LISTA];
	private int contador = 0;

	public One()
	{
		var = 1;
	}

	public One(int param) {
		var = param;
	}

	public int getVar()
	{
		return var;
	}

	public void addElement(int param) throws Exception {
		if (contador == MAX_LISTA) {
			throw new Exception();
		}
		lista[contador++] = param;
	}

	public int getElement() throws Exception { //si lanza excepciones hay que declararlo...en realidad no siempre
		if (contador < 0) {
			throw new Exception();
		}
		return lista[--contador];
	}
}

public class DoThings {
	public static void main(String[] args) {
		One uno;
		uno = new One();
		System.out.println("One sin param: "+uno.getVar());

		uno = new One(4);
		System.out.println("One con param: "+uno.getVar());

		try { //Las excepciones hay que cogerlas siempre
			uno.addElement(3);
			uno.addElement(10);
			System.out.println("Get element: "+uno.getElement());
			uno.getElement();
			uno.getElement();
		} catch (Exception ex) {
			System.out.println("Exception catched...do nothing");
		}


	}
}
