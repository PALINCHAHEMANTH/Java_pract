public class MethodReference2 
{  
    public static void ThreadStatus() {										// Static Method
        System.out.println("Thread is running...");  
    }  

	public static void main(String[] args) 
	{
        Thread t2 = new Thread(MethodReference2::ThreadStatus);  
        t2.start();       
    }  
}  