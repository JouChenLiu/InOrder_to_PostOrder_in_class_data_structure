//資結程式作業_108403501_劉柔辰
//jdk版本: jdk-12.0.2
package main;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
    	// TODO Auto-generated method stub
    	
    	Scanner input = new Scanner(System.in);
   
    	try
    	{
    		while(true)
    		{
    			String iInfix = "";
    		
    			System.out.print("請輸入數學算式: ");
    			iInfix = input.nextLine();
        
    			System.out.println("中序轉後序為: " + toPostfix(iInfix));
    		}
    		
    	}
    	finally
    	{
    		input.close();
    	}
    	
    }
    
	private static int priority(char o)
	{
        return ( o == '+' || o == '-' ) ? 1 : ( ( o == '*' || o == '/' ) ? 2 : 0 );
    }
    
    public static String toPostfix(String infix)
    {
    	LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder output = new StringBuilder();
        
        for(char c : infix.toCharArray())
        {
            if(c == '(')
            {
            	stack.add(c);
            }
            else if("+-*/".indexOf(c) != -1)
            {
                while(!stack.isEmpty() && priority(stack.getLast()) >= priority(c))
                { 
                    output.append(stack.removeLast());
                }
                
                stack.add(c);
            }
            else if(c == ')')
            {
                while(stack.getLast() != '(')
                { 
                    output.append(stack.removeLast());
                }
                
                stack.removeLast();
            }
            else
            {
            	output.append(c);
            }
            
        }
        
        while(!stack.isEmpty())
        {
        	output.append(stack.removeLast());
        }
        
        return output.toString();
    }
    
}