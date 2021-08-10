import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberDemo 
{
	public static void main(final String[] arguments) 
	{
		System.out.println("Random Integer: " + new Random().nextInt());  
		System.out.println("Seeded Random Integer: " + new Random(15).nextInt());  
		System.out.println("Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());
      
		final ThreadLocalRandom random = ThreadLocalRandom.current();  
		//random.setSeed(15);							//exception will come as seeding is not allowed in ThreadLocalRandom.
		System.out.println("Seeded Thread Local Random Integer: " + random.nextInt());  
   }
}












// An instance of this class is used to generate a stream of pseudorandom numbers. The class uses a 48-bit 
// seed, which is modified using a linear congruential formula.

// If two instances of Random are created with the same seed, and the same sequence of method calls is made 
// for each, they will generate and return identical sequences of numbers. In order to guarantee this 
// property, particular algorithms are specified for the class Random. Java implementations must use all 
// the algorithms for the class Random, for the sake of absolute portability of Java code. However, 
// subclasses of class Random are permitted to use other algorithms, so long as they adhere to the general 
// contracts for all the methods.

// The algorithms implemented by class Random use a protected utility method that on each invocation can 
// supply up to 32 pseudorandomly generated bits.

// Instances of java.util.Random are threadsafe and are not cryptographically secure.