import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	Deque<Integer> q= new LinkedList<Integer>();
    	
    	for(int i=0; i<n; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		String s = st.nextToken();
    		
    		switch(s)
    		{
    			case "push":
    				int p = Integer.parseInt(st.nextToken());
    				q.add(p);
    				break;
    			case "front":
    				if(q.isEmpty()) sb.append("-1\n");
    				else sb.append(q.getFirst()+"\n");
    				break;
    			case "back":
    				if(q.isEmpty()) sb.append("-1\n");
    				else sb.append(q.getLast()+"\n");
    				break;
    			case "size":
    				sb.append(q.size()+"\n");
    				break;
    			case "empty":
    				if(q.isEmpty()) sb.append("1\n");
    				else sb.append("0\n");
    				break;
    			case "pop":
    				if(q.isEmpty()) sb.append("-1\n");
    				else sb.append(q.pop()+"\n");
    				break;

    		}
    		
    	}
    	
    	System.out.println(sb);
    	bw.flush();
    	bw.close();
    	br.close();
    }
    

}
