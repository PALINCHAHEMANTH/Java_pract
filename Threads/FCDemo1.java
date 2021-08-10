import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Future and Callable
public class FCDemo1 
{
	public static void main(final String[] arguments) throws InterruptedException, ExecutionException 
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();

		System.out.println("Factorial Service called for 10!");
		Future<Long> result10 = executor.submit(new FactorialService(10));

		System.out.println("Factorial Service called for 20!");
		Future<Long> result20 = executor.submit(new FactorialService(20));

		Long factorial10 = result10.get();
		System.out.println("10! = " + factorial10);

		Long factorial20 = result20.get();
		System.out.println("20! = " + factorial20);

		executor.shutdown();
	}  

	static class FactorialService implements Callable<Long> 
	{
		private int number;

		public FactorialService(int number) {
			this.number = number;
		}

		@Override
		public Long call() throws Exception {
			return factorial();
		}

		private Long factorial() throws InterruptedException {
			long result = 1; 
			while (number != 0) { 
				result = number * result; 
				number--; 
				Thread.sleep(100); 
			}
			return result;	
		}
	}
}



// java.util.concurrent.Callable object can return the computed result done by a thread in contrast to runnable interface which can only run the thread. The Callable object returns Future object which provides methods to monitor the progress of a task being executed by a thread. Future object can be used to check the status of a Callable and then retrieve the result from the Callable once the thread is done. It also provides timeout functionality.

// submit the callable using ThreadExecutor and get the result as a Future object
// Future<Long> result10 = executor.submit(new FactorialService(10));
 
// get the result using get method of the Future object get method waits till the thread execution and then return the result of the execution.
// Long factorial10 = result10.get();