import java.util.*;
import javax.swing.*;

public class VirtualMachine
{
   private StackInt stack = new StackInt(20);
   Scanner sc = new Scanner(System.in);
   private int pc;//program counter
   private int ir;//instruction register
   int d, a, x, y;
   
   //create and initialize an array for memory
   private int[] memory = {20, //read an integer
                           10, 40, //store int in address 40
                           20, //read an integer
                           10, 41, //store int in address 41
                           9, 40, //load int from address 40  
                           9, 41, //load int from address 41
                           13, //multiply top two operands
                           8, 6, //load constant 6
                           11, // add top two operands
                           10, 39, //store int in address 39
                           9, 39, //load int from address 39   
                           8, 20, //load constant 20
                           17, // check if greater 
                           19, 31, //jump if false
                           9, 39, //load int from address 29 
                           8, 4, //load constant 6
                           12, // substract top two operands
                           10, 38, //store int in address 28
                           0, //terminate execution
                           0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//empty cells


   public VirtualMachine()
   {
      pc = 0;
      //fc = new JFileChooser();
      //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
      fetchDecodeExecute();
   }
   

   private void fetchDecodeExecute()
   {
      do 
      {
         ir = memory[pc];
         pc++;
         
         switch (ir)
         {
            case 0://terminate execution
               System.out.println("Execution terminated");
               System.out.println("Result: " + memory[38]);
               System.exit(0);
               break;
               
            case 8://load constant
               d = memory[pc];
               pc++;
               stack.push(d);
               break;
            
            case 9://load variable from address
               d = memory[pc];
               a = memory[d];
               stack.push(a);
               pc++;
               break;
               
            case 10://store variable in address
               d = stack.pop();
               memory[memory[pc]] = d;
               pc++;
               break;
               
            case 11://add top two operands
               y = stack.pop();
               x = stack.pop();
               d = x + y;
               stack.push(d);
               break;
               
            case 12://subtract top two operands
               y = stack.pop();
               x = stack.pop();
               d = x - y;
               stack.push(d);
               break;
               
            case 13://mulitiply top two operands
               y = stack.pop();
               x = stack.pop();
               d = x * y;
               stack.push(d);
               break;
               
            case 14://divide top two operands
               y = stack.pop();
               x = stack.pop();
               d = x / y;
               stack.push(d);
               break;

            case 15://check if equal
               y = stack.pop();
               x = stack.pop();
               if (x == y)
               {
                  stack.push(1);
               }
               else
               {
                  stack.push(0);
               }
               break;
               
            case 16://check if less 
               y = stack.pop();
               x = stack.pop();
               if (x < y)
               {
                  stack.push(1);
               }
               else
               {
                  stack.push(0);
               }
               break;
          
            case 17://check if greater
               y = stack.pop();
               x = stack.pop();
               if (x > y)
               {
                  stack.push(1);
               }
               else
               {
                  stack.push(0);
               }
               break;
               
            case 18://jump to address
               a = stack.pop();
               pc = a;
               break;
               
            case 19://jump if false
               d = stack.pop();
               if (d == 0)
               {
                  pc = d;
               }
               else
               {
                  pc++;
               }   
               break;
               
            case 20://read an int
               System.out.println("Input an integer");
               d = sc.nextInt();
               stack.push(d);
               break;
               
            case 21://write an integer
               System.out.println(stack.pop());
               break;
               
            case 22://call subprogram
               stack.push(pc+1);
               pc = memory[pc];
               break;
               
            case 23://return from subprogram
               pc = stack.pop();
           
            default: 
               System.exit(0);
               System.out.println("Error at " + pc + " given instruction " + ir);              
         }
         
      }while(true);
   }
   public static void main (String args[])
   {
      VirtualMachine vm = new VirtualMachine();
      vm.fetchDecodeExecute();
   }
}