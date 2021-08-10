// The program shows a unsafe implementation of counter in thread based environment.
public class AVDemo1 
{
	static class Counter 
	{
		private int c = 0;
		public void increment() {
			c++;
		}
		public int value() {
			return c;
		}
   }
   
	public static void main(final String[] arguments) throws InterruptedException 
	{
		final Counter counter = new Counter();
		for(int i = 0; i < 1000 ; i++) {
			new Thread(new Runnable() {
										public void run() {
											counter.increment();
									    }
									  }).start();
		}  
		Thread.sleep(6000);
		System.out.println("Final number : " + counter.value());
	}
}

// A java.util.concurrent.atomic.AtomicInteger class provides operations on underlying int value that can 
// be read and written atomically, and also contains advanced atomic operations. AtomicInteger supports 
// atomic operations on underlying int variable. It have get and set methods that work like reads and writes
// on volatile variables. That is, a set has a happens-before relationship with any subsequent get on the 
// same variable.