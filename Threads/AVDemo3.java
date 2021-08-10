import java.util.concurrent.atomic.AtomicIntegerArray;

public class AVDemo3 
{
	private static AtomicIntegerArray aia = new AtomicIntegerArray(10);

	public static void main(final String[] arguments) throws InterruptedException 
	{
		for (int i = 0; i<aia.length(); i++) {
			aia.set(i, 1);
		}

		Thread t1 = new Thread(new Increment());
		Thread t2 = new Thread(new Compare());
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Values: ");

		for (int i = 0; i<aia.length(); i++) {
			System.out.print(aia.get(i) + " ");
		}
	}
	static class Increment implements Runnable 
	{
		public void run() 
		{
			for(int i = 0; i<aia.length(); i++) {
				int add = aia.incrementAndGet(i);
				System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: "+ add);
			}
		}
	}
	static class Compare implements Runnable 
	{
		public void run() 
		{
			for(int i = 0; i<aia.length(); i++) 
			{
				boolean swapped = aia.compareAndSet(i, 2, 3);		// Atomically sets the element at position i to the given updated value if the current value == the expected value.
				if(swapped) {
					System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: 3");
				}
			}
		}
	}
}

// A java.util.concurrent.atomic.AtomicIntegerArray class provides operations on underlying int array that can 
// be read and written atomically, and also contains advanced atomic operations. AtomicIntegerArray supports 
// atomic operations on underlying int array variable. It have get and set methods that work like reads and 
// writes on volatile variables. That is, a set has a happens-before relationship with any subsequent get on 
// the same variable.
