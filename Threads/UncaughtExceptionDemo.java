import java.io.*;

public class UncaughtExceptionDemo
{
   public static void main (String [] args)
   {
      MyGroup mg = new MyGroup("My Group");

      Worker w = new Worker();

      new Thread(mg, w).start ();
   }
}

class MyGroup extends ThreadGroup
{
   MyGroup (String name)
   {
      super (name);
   }

   public void uncaughtException(Thread t, Throwable e)
   {
      if (e instanceof ArithmeticException)
          System.out.println ("Problems with arithmetic.");
      else
          super.uncaughtException (t, e);
   }
}

class Worker implements Runnable
{
	int a, b;
	Worker(){
		a = 10;
		b = 0;
	}
   public void run() // throws IOException
   {
      	System.out.println("Inside run... : "+(a/b));
	    //throw new ArrayIndexOutOfBoundsException();
   }
}