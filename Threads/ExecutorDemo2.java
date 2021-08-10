import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo2 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();

		try {
			executor.submit(new Task());
			System.out.println("Shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} 
		catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} 
		finally {
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
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// A java.util.concurrent.ExecutorService interface is a subinterface of Executor interface, and adds 
// features to manage the lifecycle, both of the individual tasks and of the executor itself.

// newSingleThreadExecutor()	: Creates an Executor that uses a single worker thread operating off an 
//								  unbounded queue.

// void shutdown()	: Initiates an orderly shutdown in which previously submitted tasks are executed, but 
//					  no new tasks will be accepted. Invocation has no additional effect if already shut down.
//					  This method does not wait for previously submitted tasks to complete execution. 
//					  Use awaitTermination to do that.

// boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException
// - Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or 
//   the current thread is interrupted, whichever happens first.

