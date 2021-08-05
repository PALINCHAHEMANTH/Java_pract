@FunctionalInterface  
interface Sayable
{  
    void say(String msg);						// ONLY ONE abstract method  

	// It can contain any number of Object class methods.  
    int hashCode();
    String toString();
    boolean equals(Object obj);
}  

public class FunctionalInterfaceExample2 implements Sayable
{  
    public void say(String msg) {  
        System.out.println("Out put : "+msg);  
    }  
	public static void main(String[] args) 
	{
        FunctionalInterfaceExample2 fie1 = new FunctionalInterfaceExample2();  
        fie1.say("Hello, Cognizant!!!!");
		System.out.println("fie1 HashCode value : "+fie1.hashCode());

		Sayable fie2 = new FunctionalInterfaceExample2();
		System.out.println("fie2 HashCode value : "+fie2.hashCode());
    }  
}  