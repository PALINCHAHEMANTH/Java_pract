@FunctionalInterface
interface Interface1
{
	void method1(String str);								// Abstract Method

	default void log(String str) {
		System.out.println("I1 logging:: "+str);
	}
	static void print(String str) {
		System.out.println("Printing "+str);
	}
	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"
	//default String toString() {
	//	return "i1";
	//}
}

@FunctionalInterface
interface Interface2 
{
	void method2();											// Abstract Method

	default void log(String str) {
		System.out.println("I2 logging:: "+str);
	}
}

public class MyClass implements Interface1, Interface2
{
	@Override
	public void method1(String str) {
		System.out.println("Inside method1..."+str);
	}

	@Override
	public void method2() {
		System.out.println("Inside method2...");
	}
	
	// MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str) {
		System.out.println("MyClass logging:: "+str);
		Interface1.print("Cognizant…");
	}

	public static void main(String[] args) 
	{
		MyClass mc = new MyClass();
		mc.log("Vinay Kumar");

		mc.method1("Java 8 Features....");
		mc.method2();
	}
}
