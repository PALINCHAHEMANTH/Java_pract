import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Creating ThreadPoolExecutor through newCachedThreadPool method of Executors
public class TPDemo5 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		//Stats before tasks execution
		System.out.println("Largest executions: " + executor.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + executor.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + executor.getPoolSize());
		System.out.println("Currently executing threads: " + executor.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + executor.getTaskCount());

		executor.submit(new Task());
		executor.submit(new Task());

		//Stats after tasks execution
		System.out.println("Core threads: " + executor.getCorePoolSize());
		System.out.println("Largest executions: " + executor.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + executor.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + executor.getPoolSize());
		System.out.println("Currently executing threads: " + executor.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + executor.getTaskCount());

		executor.shutdown();
	}  
	static class Task implements Runnable 
	{
		public void run() 
		{
			try {
				Long duration = (long) (Math.random() * 5);
				System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("Task Completed! Thread Name: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


// java.util.concurrent.ThreadPoolExecutor is an ExecutorService to execute each submitted task using one 
// of possibly several pooled threads, normally configured using Executors factory methods. It also 
// provides various utility methods to check current threads statistics and control them.

// Thread pools address two different problems: 
//	- they usually provide improved performance when executing large numbers of asynchronous tasks, due 
//    to reduced per-task invocation overhead, and 
//  - they provide a means of bounding and managing the resources, including threads, consumed when executing 
//    a collection of tasks. 
//  Each ThreadPoolExecutor also maintains some basic statistics, such as the number of completed tasks.