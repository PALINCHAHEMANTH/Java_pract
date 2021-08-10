import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Creating ExecutorService through newSingleThreadExecutor method of Executors
public class TPDemo4 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(new Task());
			System.out.println("Shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
			System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}
	static class Task implements Runnable 
	{
		public void run()
		{
			try {
				Long duration = (long) (Math.random() * 20);
				System.out.println("Running Task!");
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



// A single thread pool can be obtainted by calling the static newSingleThreadExecutor() method of Executors class.
// Syntax : ExecutorService executor = Executors.newSingleThreadExecutor();
// Where newSingleThreadExecutor method creates an executor that executes a single task at a time.

// public static ExecutorService newSingleThreadExecutor()
// Creates an Executor that uses a single worker thread operating off an unbounded queue. (Note however that 
// if this single thread terminates due to a failure during execution prior to shutdown, a new one will take 
// its place if needed to execute subsequent tasks.) Tasks are guaranteed to execute sequentially, and no 
// more than one task will be active at any given time. Unlike the otherwise equivalent newFixedThreadPool(1)
// the returned executor is guaranteed not to be reconfigurable to use additional threads.