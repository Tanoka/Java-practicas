package intermediate;

//Para crear thread podemos implemtar Runnable o extender Thread (sino vamos a sobreescribir nada, mejor runnable)
class MyThreadPut implements Runnable {
	String name;
	Thread t;
	Q q;

	MyThreadPut(String nombre, Q q) {
		this.q = q;
		t = new Thread(this, nombre); //Creamos el nuevo thread
		//Si extendemos Thread, en lugar de new sería super("My Thread"); 
		//
		name = nombre;
		System.out.println("Child thread: " + t);
		t.start();  //Lanzamos el thread...esto ejecutará el método run()
	}

	public void run() {
		int i = 0;
		while(true) {
			try {
				Thread.sleep(10);
	                } catch (InterruptedException e) {
                	       System.out.println("Main thread interrupted.");
			}						               

			q.put(++i);
			System.out.println("Put: "+i);
		}
	}

}

class MyThreadGet implements Runnable {
	Thread t;
	Q q;
	MyThreadGet(String name, Q q) {
		this.q = q;
		Thread t = new Thread(this, name);
		t.start();
	}
	public void run() {
		while(true) {
			try { 
				Thread.sleep(10);
                	} catch (InterruptedException e) {
	                        System.out.println("Main thread interrupted.");
		        }

			int i = q.get();
			//Si la clase Q no tuviera los métodos synchronized podemos usar synchronized block
			//synchronized(target) { // synchronized block
			//	q.get();
			//}
			System.out.println("Get: "+i);
		}
	}	
}

class Q {
	int n;
	boolean valueSet = false;  

	synchronized int get() {  //synchronized, cuando un thread accede, ningún otro thread podrá acceder
				  //a este método u otro método synchronized de este objecto hasta que termine.
				  
		if (!valueSet) //en el ejemplo pone while..... 
			try {
				wait(); //le decimos al thread que ha entrado que se ponga en espera. 
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		valueSet = false;
		notify();  //despertamos el thread que llamó a wait() en este mismo objecto.
		return n;
	}

	synchronized void put(int n) {
		if(valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		notify();
	}
}

class ThreadDemo {
	public static void main(String args[ ] ) {
		Q q = new Q();
		MyThreadPut my1 = new MyThreadPut("uno", q); // create a new thread
		MyThreadGet my2 = new MyThreadGet("dos", q);
		
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}

		//El hilo principal debe terminar el último, esperamos al resto de threads.
		try {
			System.out.println("Waiting for threads to finish.");
			my1.t.join();
			my2.t.join();
			my3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}	

		System.out.println("Main thread exiting.");
	}
}
