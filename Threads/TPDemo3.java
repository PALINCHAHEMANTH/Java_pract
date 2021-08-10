import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Creating ThreadPool through newScheduledThreadPool method
public class TPDemo3 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final ScheduledFuture<?> beepHandler = scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

		scheduler.schedule(new Runnable() {
											 @Override
											 public void run() {
												beepHandler.cancel(true);
												scheduler.shutdown();			
											 }
										  }, 10, TimeUnit.SECONDS);
	}  
	static class BeepTask implements Runnable 
	{
		public void run() {
			System.out.println("Beep...");
		}
	}
}



// A scheduled thread pool can be obtainted by calling the static newScheduledThreadPool() method of Executors class.
// Syntax : ExecutorService executor = Executors.newScheduledThreadPool(1);

// public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
// Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.