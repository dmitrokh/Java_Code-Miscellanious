public interface CqueueInterface
{
   public void enque(char c);   
   public Character deque();  
   public char peekFront();
   public char peekRear();
   public boolean isEmpty(); 
   public boolean isFull();
   public int size();
}