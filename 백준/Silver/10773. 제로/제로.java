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
    	
    	Stack<Integer> s = new Stack<Integer>();
    	
    	for(int i=0; i<n; i++)	
    	{
    		int N = Integer.parseInt(br.readLine());
    		
    		if(N == 0)
    		{
    			s.pop();
    		}
    		else
    		{
    			s.push(N);
    		}
    	}
    	long temp=0;
    	int size = s.size();
    	if(s.size() == 0)
    	{
    		//bw.write("0");
    	}
    	else
    	{
        	for(int i=0; i<size;i++)
        	{
        		temp += s.pop();
        	}
        	
    	}
    	bw.write(String.valueOf(temp));
    	
    	bw.flush();
    	bw.close();
    	
    }
    
}
