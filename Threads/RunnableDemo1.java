class RunnableDemo1
{
	public static void main(String[] args) 
	{
		Runnable r = new Runnable()
					{
						public void run()
						{
							while(true)
							{
								System.out.println("in run");
							}
						}
					};

		Thread t = new Thread( r );
		t.start();	
	}
}