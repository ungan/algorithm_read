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
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<n; i++)
    	{
    		String s = br.readLine();
    		Stack<Integer> stacks = new Stack<Integer>();
    		String ans = "";
    		for(int j=0; j<s.length(); j++)
    		{
    			if(s.charAt(j) == '(')
    			{
    				stacks.push(1);
    			}
    			else
    			{
    				if(stacks.isEmpty())
    				{
    					ans = "NO";
    					break;
    				}
    				else
    				{
    					stacks.pop();
    				}
    			}
    		}
    		
    		if(!ans.equals("NO"))
    		{
    			if(stacks.isEmpty())
    			{
    				ans = "YES";
    			}
    			else
    			{
    				ans = "NO";
    			}
    		}
    		bw.write(ans + "\n");
    		
    	}
    	
    	bw.flush();
    	bw.close();
    	
    }
    
}
