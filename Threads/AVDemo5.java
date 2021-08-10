import java.util.concurrent.atomic.AtomicReferenceArray;

public class AVDemo5
{
   private static String[] source = new String[5];
   private static AtomicReferenceArray<String> atomicReferenceArray = new AtomicReferenceArray<String>(source);

   public static void main(final String[] arguments) throws InterruptedException {

      for (int i = 0; i<atomicReferenceArray.length(); i++) {
         atomicReferenceArray.set(i, "item-2");
      }

      Thread t1 = new Thread(new Increment());
      Thread t2 = new Thread(new Compare());
      t1.start();
      t2.start();

      t1.join();
      t2.join();		
   }  

   static class Increment implements Runnable {
      
      public void run() {
         
         for(int i = 0; i<atomicReferenceArray.length(); i++) {
            String add = atomicReferenceArray.getAndSet(i,"item-"+ (i+1));
            System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: "+ add);
         }
      }
   }

	static class Compare implements Runnable 
	{
		public void run() 
		{
			for(int i = 0; i<atomicReferenceArray.length(); i++) 
			{
				System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", value: "+ atomicReferenceArray.get(i));
				boolean swapped = atomicReferenceArray.compareAndSet(i, "item-2", "updated-item-2");
				System.out.println("Item swapped: " + swapped);
				if(swapped) {
					System.out.println("Thread " + Thread.currentThread().getId() + ", index " +i + ", updated-item-2");
				}
			}
		}
	}
}

// A java.util.concurrent.atomic.AtomicReferenceArray class provides operations on underlying reference 
// array that can be read and written atomically, and also contains advanced atomic operations. 
// AtomicReferenceArray supports atomic operations on underlying reference array variable. It have get and 
// set methods that work like reads and writes on volatile variables. That is, a set has a happens-before 
// relationship with any subsequent get on the same variable. The atomic compareAndSet method also has 
// these memory consistency features.