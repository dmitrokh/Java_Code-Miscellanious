public class CqueueTest
{
   public static void main(String[] args)
   {
      Cqueue myQueue = new Cqueue();
      
      System.out.println("Check if the queue is full: " + myQueue.isFull());
      System.out.println("Check if the queue is empty: " + myQueue.isEmpty());
      System.out.println("Current size of the queue: " + myQueue.size());

      
      System.out.println(myQueue.deque());
      
      System.out.println("Enqueing...");
      
      myQueue.enque('a');
      myQueue.enque('b');
      myQueue.enque('c');
      myQueue.enque('d');
      myQueue.enque('e');
      myQueue.enque('f');
      
      System.out.println("The Current size of the queue: " + myQueue.size());
      System.out.println("The current first element of the queue: " + myQueue.peekFront());
      System.out.println("The current last element of the queue: " + myQueue.peekRear());
      
      System.out.println("Dequeing... ");
      System.out.println(myQueue.deque());
      System.out.println(myQueue.deque());
      System.out.println(myQueue.deque());
      
      System.out.println("The Current size of the queue: " + myQueue.size());
      System.out.println("The current first element of the queue: " + myQueue.peekFront());
      System.out.println("The current last element of the queue: " + myQueue.peekRear());
      
      System.out.println("Dequeing... ");
      System.out.println(myQueue.deque());
      System.out.println(myQueue.deque());
      
      System.out.println("The Current size of the queue: " + myQueue.size());
      System.out.println("The current first element of the queue: " + myQueue.peekFront());
      System.out.println("The current last element of the queue: " + myQueue.peekRear());
   }
}