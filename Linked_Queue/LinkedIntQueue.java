import java.lang.Runtime;

public class LinkedIntQueue
{
   private Node front, rear;//references for the ends of the queue
   private int count;//Node count, number of items in queue
   Runtime runtime = Runtime.getRuntime();//instance of Runtime class, used for getting information about memory
   
   public LinkedIntQueue()
   {
      front = null;
      rear = null;
      count = 0;
   }
   
   public int deque()
   {
      int rv = 0; //return value
      
      rv = front.data;
      front = front.next;
      
      if (front == null)
      { rear = null; }
      
      count--;
      return rv;
   }
   
   public void enque(int d)
   {
      Node newNode = new Node(d);
      newNode.next = null;
      
      if (!isEmpty())
      {
         rear.next = newNode;
         rear = newNode; 
      }   
      else
      {
         front = rear = newNode;
      } 
      
      count++; 
   }
   
   public void clear()
   {
      front = null;
      rear = null;
      count = 0;
   }
   
   public int size()
   { return count; }
   
   public Node peek()
   {
      return front;
   }
   
   public boolean isEmpty()
   {
      return front == null;
   }
   
   public boolean isFull()
   {
      System.out.println("\nThe maximum amount of memory JVM will use:  " + runtime.maxMemory());
      System.out.println("The amount of allocated memory: " + runtime.totalMemory());
      System.out.println("The amount of free memory: " + runtime.freeMemory());
      
      return false;
   }
   
   //inner class Node
   public class Node
   {
      int data;
      Node next;
      
      public Node(int d)
      {
         data = d;
      }
      
      public String toString()
      {
         return "(" + data + ", -->" + next + " )";
      }
   }
         
   public static void main(String[] args)
   {
      //create a queue
      LinkedIntQueue iq = new LinkedIntQueue();
      System.out.println("Adding elements to queue:");
      iq.enque(22);
      System.out.println("Element #" + iq.size() + " has been added, Queue's size: " + iq.size() + ", first element: " + iq.peek());
      iq.enque(1);
      System.out.println("Element #" + iq.size() + " has been added, Queue's size: " + iq.size() + ", first element: " + iq.peek());
      iq.enque(94);
      System.out.println("Element #" + iq.size() + " has been added, Queue's size: " + iq.size() + ", first element: " + iq.peek());
      
      System.out.println("\nRemoving elements from queue:");
      System.out.println("Element removed - " + iq.deque() + ", Queue's size: " + iq.size() + ", first element: " + iq.peek());
      System.out.println("Element removed - " + iq.deque() + ", Queue's size: " + iq.size() + ", first element: " + iq.peek());
      System.out.println("Element removed - " + iq.deque() + ", Queue's size: " + iq.size() + ", first element: " + iq.peek());

      System.out.println("\nAdding some elements again...");
      iq.enque(100);
      iq.enque(101);
      iq.enque(102);
      iq.enque(103);
      System.out.println("Queue's size: " + iq.size() + ", first element: " + iq.peek());
      
      System.out.println("Is there a lack of memory?..." + iq.isFull());
      
      System.out.println("\nClearing the queue...");
      iq.clear();
      System.out.println("Checking if the queue is empty..." + iq.isEmpty());
      System.out.println("Queue's size: " + iq.size() + ", first element: " + iq.peek());     

   }
   
}
   