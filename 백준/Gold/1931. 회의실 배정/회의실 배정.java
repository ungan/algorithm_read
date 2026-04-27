
import java.io.*;
import java.util.*;

public class Main {
   
	static class node implements Comparable<node>
	{
		int x;
		int y;
		
		public node(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(node o) {
			if(this.y == o.y)
			{
				return this.x - o.x;
			}
			return this.y - o.y;
		}
		
		
	}
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<node> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	pq.add(new node(a,b));
        	
        }
        
        int meeting_end=0;
        int count=0;
        
        //meeting_end = pq.peek().y;
        
        while(!pq.isEmpty())
        {
        	node cur_node = pq.poll();
        	//System.out.println(meeting_end + " " + cur_node.x);
        	if(meeting_end <= cur_node.x)
        	{
        		meeting_end = cur_node.y;
        		count++;
        	}
        }
        
        bw.write(Long.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
 
    
 
   
}
