import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TPDemo6 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		final ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
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
			System.out.println("beep");
		}
	}
}


// java.util.concurrent.ScheduledThreadPoolExecutor is a subclass of ThreadPoolExecutor and can additionally 
// schedule commands to run after a given delay, or to execute periodically. This class is preferable to 
// Timer when multiple worker threads are needed, or when the additional flexibility or capabilities of 
// ThreadPoolExecutor (which this class extends) are required.