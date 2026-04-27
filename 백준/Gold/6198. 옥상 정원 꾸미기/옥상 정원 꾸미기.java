import java.io.*;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(br.readLine());
        long count=0;
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=0; i<n; i++)
        {
        	int a = Integer.parseInt(br.readLine());
        	while(!stack.isEmpty() && stack.peek() <= a)
        	{
        		stack.pop();
        	}
        	
        	count += stack.size();
        	stack.push(a);
        }
        
        bw.write(Long.toString(count));
        bw.flush();
        bw.close();
        br.close();
    
    }

 
   
}
