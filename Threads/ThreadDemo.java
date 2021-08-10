class MyThread extends Thread 
{
   public void run()
   {
	  for(int count=1,row=1; row<20; row++,count++)
      {
           for(int i=0; i<count; i++)
                System.out.print ('*');
           System.out.print ('\n');
      }
   }
}
//------------------------------------------------------------------------------
class ThreadDemo
{
   public static void main (String [] args)
   {
	  System.out.println(""+Thread.currentThread());
	  MyThread mt = new MyThread();
	  System.out.println(""+mt);
      mt.start();
      for(int i=0; i<10; i++)
           System.out.println ("i = " + i + ", i * i = " + i * i);
   }
}