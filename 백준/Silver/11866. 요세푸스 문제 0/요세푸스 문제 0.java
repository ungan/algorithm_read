import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	for(int i=1; i<=n; i++)
    	{
    		q.add(i);
    	}
    	System.out.print("<");
    	int count=0;
    	
    	while(true)
    	{
    		count++;
    		
    		if(q.size() == 1)
			{
    			System.out.println(q.peek() + ">");
    			break;
			}
    		
    		if(count%k == 0) System.out.print(q.poll() + ", ");
    		else q.add(q.poll());
    		
    	}
    	
    	//bw.write(Integer.toString(ans));
    	bw.flush();
    	bw.close();
    	br.close();
    }
    

}
