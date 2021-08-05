// Java program to demonstrate lambda expressions to implement a user defined functional interface. 
@FunctionalInterface
interface Square 
{  
	int calculate(int x);
} 

public class FIDemo2 
{
	public static void main(String args[])  { 
		int a = 5; 
		Square s = (int x) -> x*x; 		// lambda expression to define the calculate method
		int ans = s.calculate(a); 		// parameter passed and return type must be same as defined in the prototype
		System.out.println(ans); 
	} 
}
