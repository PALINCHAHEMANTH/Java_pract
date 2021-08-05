@FunctionalInterface
interface SimpleFunctionalInterface {
	public void doWork();
//	public void doWork1();										// "Unexpected @FunctionalInterface annotation"
	public String toString();
	public boolean equals(Object o);
}
@FunctionalInterface
interface ComplexFunctionalInterface extends SimpleFunctionalInterface {
   	default public void doSomeWork() {
   		System.out.println("Doing some work in interface impl...");
   	}
   	default public void doSomeOtherWork() {
   		System.out.println("Doing some other work in interface impl...");
   	}
}
public class FIDemo3 implements ComplexFunctionalInterface {
	public void doWork(){
   		System.out.println("Doing work in SimpleFunctionalinterface impl...");
	}
	public static void main(String[] args) {
		ComplexFunctionalInterface cfi1 = new FIDemo3();	// Interface reference CAN HOLD SUB CLASS object
		cfi1.doWork();
		cfi1.doSomeWork();
		cfi1.doSomeOtherWork();
		ComplexFunctionalInterface cfi2 = new FIDemo3();
		System.out.println("Are they EQUAL : "+cfi1.equals(cfi2));
		System.out.println("toString() : "+cfi1.toString());
	}
}
