class ThreadExtThd extends Thread
{
	ThreadExtThd()
	{
		// Create a new, second thread
		super("Demo Thread");
		System.out.println("Child thread : "+ this);
		start();
	}

	public void run()
	{
		try
		{
			for(int i = 5; i > 0; i--)
			{
				System.out.println("Child thread : "+ i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println("Child Interrupted...");
		}
		System.out.println("Exiting Child Thread");
	}

	public static void main(String[] args) 
	{
		new ThreadExtThd();					// create a new thread
		try
		{
			for(int i=1; i<=5; i++)
			{
				System.out.println("Main thread : "	+ i);
				Thread.sleep(5000);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println("Main thread Interrupted...");
		}
		System.out.println("Exiting Main Thread");
	}
}