class MyThread extends Thread {
   public void run() {
	  System.out.println("----"+Thread.currentThread());		// Thread[Thread-0, 5, main]
	  for(int count=1,row=1; row<20; row++,count++)
      {
           for(int i=0; i<count; i++)
                System.out.print ('*');

           System.out.print ('\n');
      }
   }
}
//------------------------------------------------------------------------------
class ThreadDemo1 {
   public static void main (String [] args) {
	  System.out.println("main : "+Thread.currentThread());		// Thread[main, 5, main]

	  MyThread mt = new MyThread();
	  System.out.println(""+mt);
      mt.start();
      for(int i=0; i<10; i++)
           System.out.println ("i = " + i + ", i * i = " + (i * i));
   }
}