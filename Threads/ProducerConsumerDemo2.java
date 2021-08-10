class Goods
{
	private int data;
	private boolean flag = true;

	synchronized void put(int a)
	{
		if(!flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e){}
		}
		data = a;
		System.out.println("PUT " + data);
		flag = false;
		notify();
	}

	synchronized int get()
	{
		if(flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e){}
		}
		System.out.println("\tGET " + data);
		flag = true;
		notify();
		return data;
	}
}

class Producer extends Thread
{
	Goods g;
	
	Producer(Goods g)
	{
		this.g = g;
	}
	public void run()
	{
		int i = 1;
		while(true)
			g.put(i++);
	}
}

class Consumer extends Thread
{
	Goods g;

	Consumer(Goods g)
	{
		this.g = g;
	}

	public void run()
	{
		while(true)
			g.get();
	}
}

class ProducerConsumerDemo2
{
	public static void main(String[] args) 
	{
		Goods gd = new Goods();

		Producer p = new Producer(gd);
		Consumer c = new Consumer(gd);

		p.start();
		c.start();
	}
}