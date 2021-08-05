import java.util.*;
import java.util.function.Consumer;

public class ForEachExample 
{
	public static void main(String[] args) 
	{
		List<Integer> myList = new ArrayList<Integer>();		      					// creating sample Collection
		
		for(int i=0; i<10; i++) 
			myList.add(i);

//		Iterator<Integer> it = myList.iterator();			        	                // traversing using Iterator
//		while(it.hasNext()){
//			Integer i = it.next();
//			System.out.println("Iterator Value::"+i);
//		}
	
//		myList.forEach(new Consumer<Integer>() {         								// traversing through forEach method of Iterable 
//			public void accept(Integer t) {												// with anonymous class
//				System.out.println("forEach anonymous class Value: "+t);
//			}
//		});

		MyConsumer action = new MyConsumer();  											// traversing with Consumer interface implementation
		myList.forEach(action);
	}
}

class MyConsumer implements Consumer<Integer> {											// Consumer implementation that can be reused
	public void accept(Integer t) {
		System.out.println("Consumer impl Value: "+t);
	}
}
