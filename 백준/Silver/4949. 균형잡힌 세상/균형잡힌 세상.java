import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws Exception
    {
    	Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		//System.out.println(s);
		int num=0;
		
		while ((s = br.readLine()) != null && !s.equals("."))
		{
			for(int i=0; i<s.length(); i++)
			{
				//System.out.println(s.charAt(i));
				char c = s.charAt(i);
				
				if(c == '(')
				{
					stack.push('(');
				}
				else if(c == '[')
				{
					stack.push('[');
				}
				
				if(c == ')')
				{
					if(stack.isEmpty())
					{
						System.out.println("no");
						break;
					}
					else if(stack.pop() != '(')
					{
						System.out.println("no");
						break;
					}
				}
				else if(c == ']')
				{
					if(stack.isEmpty())
					{
						System.out.println("no");
						break;
					}
					else if(stack.pop() != '[')
					{
						System.out.println("no");
						break;
					}
				}
				
				if(c == '.')
				{
					if(stack.isEmpty())
					{
						System.out.println("yes");
					}
					else
					{
						System.out.println("no");
					}
					
				}
				
			}
			stack.clear();
		}
    }
}