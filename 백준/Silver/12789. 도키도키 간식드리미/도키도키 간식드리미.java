import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int[] array = new int[n];
    	int min=0;
    	for(int i=0; i<n;i++)
    	{
    	
    		array[i] = Integer.parseInt(st.nextToken());
    		if(i == 0) min = array[i];
    		else if(min > array[i]) min = array[i];
    	}
    	
    	int c=min;
    	
    	Stack<Integer> s = new Stack<Integer>();
    	for(int i=0; i<n; i++)
    	{
    		if(array[i] == c)
    		{
    			//System.out.println("array[i] : "  + array[i]);
    			c++;
    		}
    		else
    		{
    			boolean check = true;
    			while(true)
    			{
    				
    				if(s.isEmpty())
    				{
    					//System.out.println("in1 c: " + c);
    					s.push(array[i]);
    					break;
    				}
    				
    				if(s.peek()!=c && array[i] !=c)
    				{
    					if(check) 
    					{
    						s.push(array[i]);
    						check =false;
    					}
    					//System.out.println("in c: " + c);
    					break;
    				}
    				
    				if(s.peek() == c)
    				{
    					//System.out.println("in3 c: " + c);
    					c++;
    					s.pop();
    				}
    				if(array[i] == c)
    	    		{
    	    			//System.out.println("array[i] : "  + array[i]);
    					check = false;
    	    			c++;
    	    		}
    				
    				//System.out.println("in c: " + c + "s.peek() : " + s.peek());
    			}
    			//s.push(array[i]);
    		}
    			
    	}
    	
    	int size = s.size();
    	
    	for(int i=0; i < size; i++)
    	{
    		if(s.pop() == c)
    		{
    			//System.out.println("c : "  + c);
    			c++;
    		}
    		else
    		{
    			break;
    		}
    	}
    	Arrays.sort(array);
    	
    			
		
    	if(c == array[array.length-1]+1)
    	{
    		wr.write("Nice");
    	}
    	else
    	{
    		wr.write("Sad");
    	}
    	
    	wr.flush();
    	wr.close();
    	
    }
    
}
