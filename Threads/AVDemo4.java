import java.util.concurrent.atomic.AtomicLongArray;

public class AVDemo4 
{
	private static AtomicLongArray atomicLongArray = new AtomicLongArray(5);

	public static void main(final String[] arguments) throws InterruptedException 
	{
		for (int i = 0; i<atomicLongArray.length(); i++) {
			atomicLongArray.set(i, 1);
		}
		Thread t1 = new Thread(new Increment());
		Thread t2 = new Thread(new Compare());
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Values: ");

		for (int i = 0; i<atomicLongArray.length(); i++) {
			System.out.print(atomicLongArray.get(i) + " ");
		}
	}  
	static class Increment implements Runnable 
	{
		public void run() 
		{
			for(int i = 0; i<atomicLongArray.length(); i++) 
			{
				long add = atomicLongArray.incrementAndGet(i);
				System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: "+ add);
			}
		}
	}
	static class Compare implements Runnable 
	{
		public void run() 
		{
			for(int i = 0; i<atomicLongArray.length(); i++) 
			{
				boolean swapped = atomicLongArray.compareAndSet(i, 2, 3);
				if(swapped) {
					System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: 3");
				}
			}
		}
	}
}