@FunctionalInterface
interface Sayable {
	void say();
}

public class MethodReference 
{
	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}
	
	public static void main(String[] args) 
	{
	    // Referring NON STATIC method
//	    Sayable sayable = new MethodReference()::saySomething;

	    // Referring STATIC method
	    Sayable sayable = MethodReference::saySomething;
	
		// Calling interface method
	    sayable.say();
	}
}