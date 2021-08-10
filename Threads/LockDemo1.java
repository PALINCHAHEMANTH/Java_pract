import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintDemo 
{
	private final Lock queueLock = new ReentrantLock();

	public void print() 
	{
		queueLock.lock();					// Acquires the lock.

		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + "  Time Taken " + (duration / 1000) + " seconds.");
			Thread.sleep(duration);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally {
			System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
			queueLock.unlock();				// Attempts to release this lock.
		}
	}
}

class ThreadDemo extends Thread 
{
	PrintDemo  printDemo;

	ThreadDemo(String name, PrintDemo printDemo) {
		super(name);
		this.printDemo = printDemo;
	}   

	@Override
	public void run() {
		System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
		printDemo.print();
	}
}

public class LockDemo1 
{
	public static void main(String args[]) 
	{
		PrintDemo PD = new PrintDemo();

		ThreadDemo t1 = new ThreadDemo("Thread - 1 ", PD);
		ThreadDemo t2 = new ThreadDemo("Thread - 2 ", PD);
		ThreadDemo t3 = new ThreadDemo("Thread - 3 ", PD);
		ThreadDemo t4 = new ThreadDemo("Thread - 4 ", PD);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

// A java.util.concurrent.locks.Lock interface is used to as a thread synchronization mechanism 
// similar to synchronized blocks

// Lock implementations provide more extensive locking operations than can be obtained using synchronized 
// methods and statements. 

// They allow more flexible structuring, may have quite different properties, and may support multiple 
// associated Condition objects.

// A lock is a tool for controlling access to a shared resource by multiple threads. Commonly, a lock 
// provides exclusive access to a shared resource: only one thread at a time can acquire the lock and all 
// access to the shared resource requires that the lock be acquired first. However, some locks may allow 
// concurrent access to a shared resource, such as the read lock of a ReadWriteLock.

// The use of synchronized methods or statements provides access to the implicit monitor lock associated 
// with every object, but forces all lock acquisition and release to occur in a block-structured way: when 
// multiple locks are acquired they must be released in the opposite order, and all locks must be released 
// in the same lexical scope in which they were acquired.

// A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor 
// lock accessed using synchronized methods and statements, but with extended capabilities.
// A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread 
// invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread. 
// The method will return immediately if the current thread already owns the lock. This can be checked using
// methods isHeldByCurrentThread(), and getHoldCount().

// Main differences between a Lock and a synchronized block are following -

// Guarantee of sequence	- Synchronized block does not provide any guarantee of sequence in which 
//							  waiting thread will be given access. 
//							  Lock interface handles it.
// No timeout				- Synchronized block has no option of timeout if lock is not granted. 
//							  Lock interface provides such option.
// Single method			- Synchronized block must be fully contained within a single method whereas a 
//							  lock interface's methods lock() and unlock() can be called in different methods.