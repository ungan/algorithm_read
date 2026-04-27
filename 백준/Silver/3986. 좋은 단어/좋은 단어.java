import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        int count=0;
        int n = Integer.parseInt(br.readLine());
        
        for(int N = 0; N<n; N++)
        {
        	
        	String S = br.readLine();
        	
        	int a_count=0;
        	int b_count=0;
        	Stack<Character> c = new Stack<>();
        	
        	for(int i=0; i<S.length(); i++)
        	{
        		//c.push(S.charAt(i));
        		//System.out.println("S.charAt(i) : " + S.charAt(i));
        		if(c.isEmpty()) c.push(S.charAt(i));
        		else if(c.peek() == S.charAt(i)) 
    			{
        			//c.push(S.charAt(i));
        			c.pop();
    			}
        		else if(c.peek() != S.charAt(i))
        		{
        			c.push(S.charAt(i));
        		}
        		
        	}
        	//System.out.println(a_count + " " + b_count);
        	if((a_count<2 && b_count<2) && c.isEmpty())
        	{
        		count++;
        	}
        }
        
        
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    
    }

 
   
}
