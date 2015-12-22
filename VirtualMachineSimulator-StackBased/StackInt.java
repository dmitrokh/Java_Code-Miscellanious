
public class StackInt implements StackIntOperations
{
  private int[] stack;
  private int sp;
  
  public StackInt()
  {
    stack = new int[10];
    sp = -1;    
  }
  
  public StackInt( int s )
  {
    stack = new int[s];
    sp = -1;  
  }
  
  public int nextInt()
  {
    int random = (int) ((Math.random() * 10) + 1);
    
  	return random;
  }  

  public void push(int e)
  {
    if ( !isFull() ) // check for stack space
    {
      sp++; // advance stack pointer
      stack[sp] = e; // put element on stack
    }
    else // stack is full
    {
      System.out.println("Attempt to push to a full stack");
      System.exit(0);
    }
  }
  
  public int pop()
  {
    int rv = 0; // return value
    
    if ( !isEmpty() ) // check for data on stack
    {
      rv = stack[sp]; // copy data out of stack
      sp--; // reduce stack pointer
    }
    else  // stack is empty
    {
      System.out.println("Attempt to pop an empty stack");
      System.exit(0);
    }
    
    return rv;
  
  }
  
  public int peek()
  {
    int rv = 0; // return value
    
    if ( !isEmpty() ) // check for data on stack
    {
      rv = stack[sp]; // copy data out of stack
    }
    else
    {
      System.out.println("Attempt to peek an empty stack");
      System.exit(0);
    }
    
    return rv;
   
  }
  
  public boolean isEmpty()
  {
    return sp == -1;
  }

  public boolean isFull()
  {
    return sp == stack.length - 1;
  }

  //returns the number of active elements on the stack
  public int size()
  {
    return sp+1;
  }
  
  public String toString()
  {
    String rv = "sp->";
    
    // top item -> bottom item
    for(int i = sp; i >= 0; i--)
    {
      rv = rv + stack[i] + " ";
	}
	    return rv;
  }
}
