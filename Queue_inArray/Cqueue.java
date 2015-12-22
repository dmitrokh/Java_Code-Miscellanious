public class Cqueue implements CqueueInterface
{
   private char[] q;
   private int front, rear, counter;
   
   public Cqueue()
   {
      front = rear = 0;
      counter = 0;
      q = new char[5];
   }
   
   public void enque(char c) //removes the element at the front of the queue and returns it
   {
      if (!isFull())
         {
         q[rear] = c;
         counter++;
         if (!isFull())
            { rear = (rear + 1) % q.length; }
         System.out.println("Character " + c + " has been enqued.");
         }
         else
            {
               System.out.println("The queue is full! Character " + c + " cannot be enqued.");
            }
   }
   
   public Character deque() //inserts the element at the rear of the queue
   {
      Character returnChar; 
      
      if (!isEmpty())
         {
         returnChar = q[front];
         front = (front + 1) % q.length;
         counter--;
         }
         else
            {
               returnChar = null;
               System.out.print("The queue is empty! The returning value is ");
            }
      return returnChar;
   }
   
   public char peekFront()
   {
      if (isEmpty())
         { front = 0; }
      return q[front];
   }
   
   public char peekRear()
   {
      if (isEmpty())
         { rear = 0; }
      return q[rear];
   }

   
   public boolean isEmpty() //returns true if the queue is empty, false otherwise
   {
      return (counter == 0);
   }
   
   public boolean isFull()//returns true if the queue is full, false otherwise
   {
      return (counter == q.length); 
   }
   
   public int size() //returns the number of elements in a queue
   {
      return counter;
   }
}