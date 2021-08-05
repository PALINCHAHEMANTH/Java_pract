public class InstanceMethodReference2
{
    public void printnMsg()													// Instance Method
	{
        System.out.println("Hello, this is instance method");  
    }

    public static void main(String[] args) 
	{
	    Thread t2 = new Thread(new InstanceMethodReference2()::printnMsg);
        t2.start();
    }
}