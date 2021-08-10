// The ThreadLocal class is used to create thread local variables which can only be read and written by 
// the same thread. Ex: If two threads are accessing code having reference to same threadLocal variable 
// then each thread will not see any modification to threadLocal variable done by other thread.

class RunnableDemo implements Runnable 
{
	int counter;
	ThreadLocal<Integer> tlVar = new ThreadLocal<Integer>();

	public void run() 
	{
		counter++;

		if(tlVar.get() != null) {
			tlVar.set(tlVar.get().intValue()+1);
		} else {
			tlVar.set(1);
		}
		System.out.println("Thread : " + counter);
		System.out.println("ThreadLocal Variable : " + tlVar.get());
	}
}

public class ThreadLocalDemo
{
	public static void main(String args[]) 
	{
		RunnableDemo threadObj = new RunnableDemo();

		Thread t1 = new Thread(threadObj);
		Thread t2 = new Thread(threadObj);
		Thread t3 = new Thread(threadObj);
		Thread t4 = new Thread(threadObj);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// wait for threads to end
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}

// This class provides thread-local variables. These variables differ from their normal counterparts in 
// that each thread that accesses one (via its get or set method) has its own, independently initialized 
// copy of the variable. ThreadLocal instances are typically PRIVATE STATIC fields in classes that wish 
// to associate state with a thread (e.g., a user ID or Transaction ID).

// Each thread holds an implicit reference to its copy of a thread-local variable as long as the thread 
// is alive and the ThreadLocal instance is accessible; after a thread goes away, all of its copies of 
// thread-local instances are subject to garbage collection (unless other references to these copies exist).