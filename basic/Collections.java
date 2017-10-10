package basic;

import java.util.*;

/**
 *List: ArrayList, LinkedList
 *Deque: ArrayDeque, LinkedList
 *Set: HashSet, TreeSet, LinkedHashSet
 *Map: HashMap, TreeMap, LinkedHashMap
 *
 *List: Collection ordenada. ArrayList: Resizable. LinkedList: velocidad de insercion? solo secuencial?
 *Set: Collection sin duplicados.
 *Queue: Collection con comportamiento de cola: add(e), remove(). HashSet: no ordenado.
 *Deque: Queue pero con add y remove en los dos extremos. ArrayDeque: resizable.
 *Map: Collection que mapea claves a valores
 *
 */
class Collections {
	public static void main(String[] args) {
	//	ArrayList<String> arli = new ArrayList<>(Arrays.asList("uno", "dos", "tres"));
		ArrayList<String> arli = new ArrayList<>();
	//Métodos principales: add(E), add(int, E), addAll(...), clear(), contains(Object), get(int), indexOf(Object)
	//iterator(), isEmpty(), remove(int), set(int, E), size(), toArray(), 
		arli.add("uno");
		arli.add("dos");
		arli.add("tres");
		System.out.println("Elemento de ArrayList: "+arli.get(1));

		System.out.println("Recorrer ArrayList");
		for (int x = 0; x < arli.size(); x++) {
			System.out.print(arli.get(x)+",");
		}

		System.out.println("\nRecorrer ArrayList como iterator");
		Iterator iter = arli.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next()+",");
		}

		//usando toArray. Hay dos formas. Con la segunda forma ya viene con el tipo correcto
		Object[] miob = arli.toArray();
		String[] miar = arli.toArray(new String[arli.size()]);
		
	}


}
