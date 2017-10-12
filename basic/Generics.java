package basic;

//Generics works only with reference types, not primitive types
// T is a type parameter
// Se pueden declarar tanto clases como interfaces genéricos y se pueden heredar clases genéricas.
// y se implementan class Test<T> implements interfacename<T>
class Test<T> {

	T var;

	public Test()
	{
	}

	public void setVar(T t) {
		var = t;
	}

	public T getVar() {
		return var;
	}
}

//Bounded types. V solo podrá ser de una clase tipo Number, como Integer, Float, etc..
class TestTwo<T, V extends Number> {
	T vars;
	V vari;

	//It is possible for constructors to be generic, even if their class is not.
	// <V extends Number> TestTwo(T t, V v), if class TestTwo<T>
	TestTwo(T t, V v) {
		vars = t;
		vari = v;
	}

	public T getVars() {
		return vars;
	}

	public V getVari() {
		return vari;
	}

	//wildcards. < ? >. wildcards can be bounded. Test<? extends Number>
	public boolean getTestVar(Test<?> ob) {
		return ob.getVar() == getVars();
	}

}


class Generics {

	//Generic type exclusivo de un método
	//En este caso T tiene que implementar el interface Comparable<T> y V extender de T
        static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        	for(int i=0; i < y.length; i++) {
			if (x.equals(y[i])) return true;
		}
		return false;
	}

	//No static member can use a type parameter declared by the enclosing class
	//static T getob() { .. //Ilegal. Por eso Generic type exclusivo de un método
	//
	// T vals[]; ok | vals = new T[10]; Ilegal
							        
	public static void main(String args[]) {

		//Prior to JDK 7: Test<String> gen = new Test<String>(); now is type inference, use diamond <>.
		Test<String> gen = new Test<>();

		gen.setVar("hola, soy generic string");
		System.out.println("Que dice el generic: "+gen.getVar());

		//No hace falta Integer(10), autoboxing
		TestTwo<String, Integer> testtwo = new TestTwo<>("Hola", 10);
		 
		System.out.println("Que dice generic 2: "+testtwo.getVars()+" y "+testtwo.getVari());

		System.out.println("Usando wildcards: "+testtwo.getTestVar(gen));

		//Integer implementa Comparable<Integer>
		Integer nums[] = {1,2,3,4};
		if (isIn(2, nums))
			System.out.println("Integer is in");

		String strg[] = {"uno", "dos", "tres" };
		if (isIn("dos", strg))
			System.out.println("String is in");

	}

}


