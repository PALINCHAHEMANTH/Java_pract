import java.util.List;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public class BODemo1
{
	public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) 
	{
        T result = init;
        for (T t : list) {
            result = accumulator.apply(result, t);
        }
        return result;
    }
	public static void main(String[] args) 
	{
		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer result = math(Arrays.asList(numbers), 0, (a, b) -> a + b);
        System.out.println("\nSum of the Integers : "+result);

		System.out.println("----------------------------------------------------------");
        
		Integer result2 = math(Arrays.asList(numbers), 0, Integer::sum);
        System.out.println("Sum of the Integers : "+result2);
	}
}
