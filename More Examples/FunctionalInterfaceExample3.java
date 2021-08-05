// A functional interface can extends another interface only when it does not have 
// any abstract method.

//interface sayable {
//    void say(String msg);					// abstract method
//}

//@FunctionalInterface						// Unexpected / Invalid '@FunctionalInterface' annotation; Doable is not a functional interface
//interface Doable extends sayable {			// Multiple non-overriding abstract methods found in interface Doable
//    void doIt();  
//}

//-----------------------------------------------------------------------------
interface Doable {
	default void doIt() {
        System.out.println("Do it now");
    }
}

@FunctionalInterface
interface Sayable extends Doable {
    void say(String msg);											// ONLY ONE abstract method
}  

public class FunctionalInterfaceExample3 implements Sayable 
{
    public void say(String msg) {
        System.out.println("Out Put : "+msg);  
    }  

	public static void main(String[] args) {
        FunctionalInterfaceExample3 fie = new FunctionalInterfaceExample3();  
        fie.say("Hello Cognizant!!!");
        fie.doIt();
    }
}