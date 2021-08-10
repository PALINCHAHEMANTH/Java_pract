import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Creating ThreadPool through newCachedThreadPool method
public class TPDemo2 
{
	public static void main(final String[] arguments) throws InterruptedException 
	{
		ExecutorService executor = Executors.newCachedThreadPool();

		// Cast the object to its class type
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

		// Statistics before tasks execution
		System.out.println("\nLargest executions : " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads : " + pool.getMaximumPoolSize());		// 2,14,74,83,647
		System.out.println("Current threads in pool : " + pool.getPoolSize());
		System.out.println("Currently executing threads : " + pool.getActiveCount());
		System.out.println("Total number of threads (ever scheduled) : " + pool.getTaskCount());

		executor.submit(new Task());
		executor.submit(new Task());
		System.out.println("-------------------------------------------------------------");

		// Statistics after tasks execution
		System.out.println("Core threads : " + pool.getCorePoolSize());
		System.out.println("Largest executions : " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads : " + pool.getMaximumPoolSize());		// 2,14,74,83,647
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
				System.out.println("\t\tRunning Task! Thread Name: " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("\t\tTask Completed! Thread Name: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}





//A cached thread pool can be obtainted by calling the static newCachedThreadPool() method of Executors class.
// Syntax : ExecutorService executor = Executors.newCachedThreadPool();
// where
// newCachedThreadPool method creates an executor having an expandable thread pool.
// Such an executor is suitable for applications that launch many short-lived tasks.