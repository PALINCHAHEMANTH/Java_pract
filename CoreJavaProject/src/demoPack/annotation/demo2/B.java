package demoPack.annotation.demo2;

public class B 
{
	int x;
	float y;
	
	public B()
	{
		System.out.println("Inside B's Constructor...");
		x = 10;
		y = 5.5f;
	}
	
	public void display()
	{
		System.out.println("Product is : "+(x*y));
	}
}