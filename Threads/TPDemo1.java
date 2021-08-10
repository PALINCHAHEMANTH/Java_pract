import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Creating ThreadPool through newFixedThreadPool method
public class TPDemo1 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Cast the object to its class type
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

		// Statistics before tasks execution
		System.out.println("\nLargest executions : " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads : " + pool.getMaximumPoolSize());
		System.out.println("Current threads in pool : " + pool.getPoolSize());
		System.out.println("Currently executing threads : " + pool.getActiveCount());
		System.out.println("Total number of threads (ever scheduled) : " + pool.getTaskCount());

		executor.submit(new Task());
		executor.submit(new Task());
		System.out.println("-------------------------------------------------------------");

		// Statistics after tasks execution
		System.out.println("Core threads : " + pool.getCorePoolSize());
		System.out.println("Largest executions : " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads : " + pool.getMaximumPoolSize());
		System.out.println("Current threads in pool : " + pool.getPoolSize());
		System.out.println("Currently executing threads : " + pool.getActiveCount());
		System.out.println("Total number of threads (ever scheduled) : " + pool.getTaskCount());

		executor.shutdown();
	}  
	static class Task implements Runnable 
	{
		public void run() {
			try 
			{
				Long duration = (long) (Math.random() * 5);
				System.out.println("\t\tRunning Task! Thread Name : " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("\n\t\tTask Completed! Thread Name : " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


// A fixed thread pool can be obtainted by calling the static newFixedThreadPool() method of Executors class.
// ExecutorService fixedPool = Executors.newFixedThreadPool(2);
// where
// Maximum 2 threads will be active to process tasks.
// If more than 2 threads are submitted then they are held in a queue until threads become available.
// A new thread is created to take its place if a thread terminates due to failure during execution shutdown on executor is not yet called.
// Any thread exists till the pool is shutdown.