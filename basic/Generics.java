package basic;

class test<T> {

	T var;

	public test()
	{
	}

	public void setVar(T t) {
		var = t;
	}

	public T getVar() {
		return var;
	}
}

class Generics {
	static public void main(String args[]) {

		test<String> gen = new test<>();

		gen.setVar("hola, soy generic string");
		System.out.println("Que dice el generic: "+gen.getVar());
	}

}


