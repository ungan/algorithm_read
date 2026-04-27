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
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st; 
    	Stack<Integer> s = new Stack<Integer>();
    	
    	for(int i=0; i<N; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		//String s1 = br.readLine();
    		int n = Integer.parseInt(st.nextToken());
        	
        	
        	
        	switch(n)
        	{
        		case 1:
        			int num = Integer.parseInt(st.nextToken());
        			//System.out.println("11 " + num);
        			s.push(num);
        			break;
        		case 2:
        			if(s.isEmpty())
        			{
        				bw.write(String.valueOf("-1") + "\n");
        				//System.out.println("21 -1");
        			}
        			else
        			{
        				//System.out.println("22 " + s.peek());
        				bw.write(String.valueOf(s.pop()) + "\n");
        			}
        			break;
        		case 3:
        			//System.out.println("3 " + s.size());
        			bw.write(String.valueOf(s.size()) + "\n");
        			break;
        		case 4:
        			if(s.isEmpty())
        			{
        				//System.out.println("41 ");
        				bw.write(String.valueOf("1") + "\n");
        			}
        			else
        			{
        				//System.out.println("42 ");
        				bw.write(String.valueOf("0") + "\n");
        			}
        			break;
        		case 5:
        			if(s.isEmpty())
        			{
        				//System.out.println("51 ");
        				bw.write(String.valueOf("-1") + "\n");
        			}
        			else
        			{
        				//System.out.println("52 ");
        				bw.write(String.valueOf(s.peek()) + "\n");
        			}
        			break;
        	}
    	}
    	
    	bw.flush();
    	bw.close();
    	
    	
    }
    
}
