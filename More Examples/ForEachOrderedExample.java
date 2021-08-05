import java.util.ArrayList;  
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class ForEachOrderedExample 
{
    public static void main(String[] args) 
	{
//        List<String> gamesList = new ArrayList<String>();		// No ORDER maintained
//        Set<String> gamesList  = new HashSet<String>();			// No ORDER maintained
        Set<String> gamesList  = new TreeSet<String>();			// ORDER maintained

		gamesList.add("Football");  
        gamesList.add("Cricket");  
        gamesList.add("Chess");
        gamesList.add("Chess");
        gamesList.add("Hockey");  
     
//		System.out.println("------------Iterating by passing lambda expression---------------");  
//      gamesList.stream().forEachOrdered(games -> System.out.println(games));  
        
		System.out.println("------------Iterating by passing method reference---------------");  
        gamesList.stream().forEachOrdered(System.out::println);  
    }
}