// The program shows a safe implementation of counter using AtomicInteger in thread based environment.
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AVDemo2
{
	static class Counter 
	{
		private AtomicInteger c = new AtomicInteger(0);
//		private AtomicLong c = new AtomicLong(0);
		public void increment() {
			c.getAndIncrement();
		}
		public int value() {
			return c.get();
		}
//		public long value() {
//			return c.get();
//		}
	}
	public static void main(final String[] arguments) throws InterruptedException 
	{
		final Counter counter = new Counter();
		for(int i = 0; i < 1000 ; i++) 
		{
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