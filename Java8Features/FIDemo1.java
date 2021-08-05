// Java program to demonstrate functional interface 
public class FIDemo1 
{ 
	public static void main(String args[])  
	{ 
 		new Thread(new Runnable()  { 		           		        // create anonymous inner class object
            				@Override
            				public void run()  { 
                				System.out.println("FIDemo1 : New thread created"); 
            				} 
        		}).start(); 
    	} 
}

//------------------------------------------------------------------------------------------------------------
// Java program to demonstrate Implementation of functional interface using lambda expressions 
class Test
{
	public static void main(String args[]) 
	{
		new Thread(() -> {System.out.println("Test : New thread created");}).start(); // lambda expression to create the object
//		main(null);
	} 
}