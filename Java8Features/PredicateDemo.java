// A simple program to demonstrate the use of predicate interface 
import java.util.*; 
import java.util.function.Predicate;

public class PredicateDemo
{ 
    public static void main(String args[]) 
	{ 
		List<String> names = Arrays.asList("CTS","CTSQuiz","g1","QA","CTS2");		// create a list of strings

		// Declare the predicate type as string and use lambda expression to create object 
		Predicate<String> p = (s) -> s.startsWith("C"); 

		for (String st : names)  {													// Iterate through the list
			if (p.test(st)) 														// call the test method
				System.out.print(st+"\t"); 
       	}
    }
}