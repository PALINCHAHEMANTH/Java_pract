import java.util.function.*;

@FunctionalInterface
interface Greetings {
    String message(String name);
}

@FunctionalInterface
interface GiveStatement {
	void statement();
}

public class Lambda1
{
	public static void main(String[] args) 
	{
		//Given a number n, returns a boolean indicating if it is odd or even.
		Predicate<Integer> i = (n) -> n%2 != 0; 
		if (i.test(5))
  			System.out.println("is an ODD value.");
		else
			System.out.println("is an EVEN value.");

		//Given a character c, returns a boolean indicating if it is equal to ‘y’.
		Predicate<Character> ch = (Character c) -> c == 'y'; 
		if (ch.test('z'))
  			System.out.println("is the same CHARACTER.");
	  	else
			System.out.println("is a different CHARACTER.");

		//Given two numbers x and y, returns another number with their summation.
 		BinaryOperator<Integer> sum = (x, y) -> x + y;
		Integer sumResult = sum.apply(2, 3);
		System.out.println("Sum of the given values : "+sumResult);

		//Given two integers a and b, returns another integer with the sum of their squares.
 		BinaryOperator<Integer> sumOfSquares = (Integer a, Integer b) -> a * a + b * b;
		Integer result = sumOfSquares.apply(3, 5);
		System.out.println("Sum of the given squares : "+result);

		//Given no parameters returns the integer 42.
		Supplier<Integer> intValue = () -> 42;
		Integer result1 = intValue.get();
		System.out.println("Returns the GIVEN value : "+result1);

		//Given no parameters returns the double 3.14.
		Supplier<Float> floatValue = () -> { return 3.14f; };
		Float result2 = floatValue.get();
		System.out.println("Returns the GIVEN Float value : "+result2);

		//Given a string s, prints the string to the main output and returns void.
		Greetings greet = (String s) -> { return s; };
		String s = greet.message("Hello. Good Morning!!");
		System.out.println("Greetings : "+s);

		Greetings person = (message)-> { String str1 = "I would like to say, ";
										 String str2 = str1 + message;
										 return str2;
							           };
        System.out.println(person.message("time is precious."));

		//Give no parameters, prints Hello World! to the main output and returns void.
		GiveStatement greetings = () -> { System.out.println("Hello World!"); };
		greetings.statement();
	}
}