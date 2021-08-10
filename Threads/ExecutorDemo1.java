import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo1 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		Executor executor = Executors.newCachedThreadPool();
		executor.execute(new Task());
		ThreadPoolExecutor pool = (ThreadPoolExecutor)executor;
		pool.shutdown();
	}

	static class Task implements Runnable 
	{
		public void run() 
		{
			try {
				Long duration = (long) (Math.random() * 5);
				System.out.println("Running Task!");
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("Task Completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// An object that executes submitted Runnable tasks. This interface provides a way of decoupling task 
// submission from the mechanics of how each task will be run, including details of thread use, scheduling, 
// etc. An Executor is normally used instead of explicitly creating threads. 

// newCachedThreadPool() : Creates a thread pool that creates new threads as needed, but will reuse 
//						   previously constructed threads when they are available.