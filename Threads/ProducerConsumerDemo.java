class Goods
{
	private int data;
	private boolean flag = true;

	synchronized void put(int value)
	{
		data = value;
		System.out.println("PUT : " + data);
	}

	synchronized int get()
	{
		System.out.println("\tGET : " + data);
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
		{
			g.put(i++);
		}
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
		{
			g.get();
		}
	}
}

class ProducerConsumerDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		Goods g = new Goods();

		Producer p = new Producer(g);
		Consumer c = new Consumer(g);

		p.start();
		c.start();

		p.join();
		c.join();
	}
}