package demoPack.annotation.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class A 
{
	int x;
	float y;
	
	public A()
	{
		System.out.println("Inside A's Constructor...");
		x = 10;
		y = 5.5f;
	}
	
	public void display()
	{
		System.out.println("Sum is : "+(x+y));
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("Initializing the Bean...");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Destroying the Bean...");		
	}
	
}