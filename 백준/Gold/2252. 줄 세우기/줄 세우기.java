
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    	
    	int array[] = new int[N+1];
    	
    	for(int i=0; i<=N; i++) {
    		arrayList.add(new ArrayList());
    	}
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		arrayList.get(a).add(b);
    		array[b]++;
    	}
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	for(int i=1; i<array.length; i++)
    	{
    		if(array[i] == 0)
    		{
    			q.add(i);
    		}
    	}
    	
    	while(!q.isEmpty())
    	{
    		int now = q.poll();
    		
    		for(int next : arrayList.get(now))
    		{
    			array[next]--;
    			if(array[next] == 0)
    			{
    				q.add(next);
    			}
    		}
    		
    		bw.write(Integer.toString(now) + " ");
    	}
    	
    	//bw.write(state);
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
	
}
