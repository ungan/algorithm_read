import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] visit;
	static List<Integer>[] list;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int T=0; T<t; T++)
    	{
    		st = new StringTokenizer(br.readLine());
    		int v = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		
    		list = new List[v+1];
    		visit = new int[v+1];
    		
    		for(int i=0; i<=v; i++)
    		{
    			list[i] = new LinkedList<Integer>();
    		}
    		
    		for(int i=0; i<e; i++)
    		{
    			st = new StringTokenizer(br.readLine());
    			
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			
    			list[a].add(b);
    			list[b].add(a);
    			
    		}
    		
    		boolean ans=true;
    		
    		for(int i=1; i<=v; i++)
    		{
    			if(visit[i] == 0) 
    			{
    				ans = bfs(i);
    				//System.out.println("ans : " + ans);
    				if(!ans) break;
    			}
    		}
    		
    		if(ans)
    		{
    			bw.write("YES\n");
    		}
    		else
    		{
    			bw.write("NO\n");
    		}
    	}
    	
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
    static boolean bfs(int n)
    {
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(n);
    	visit[n] = 1;
    	
    	while(!q.isEmpty())
    	{
    		int cur_q = q.poll();
    		
    		for(int i : list[cur_q])
    		{
    			if(visit[i] == 0)
    			{
    				q.add(i);
    				visit[i] = visit[cur_q] == 2 ? 1 : 2;
    			}
    			else if(visit[i] == visit[cur_q])
    			{
    				//System.out.println("ans : "+ i + " " + cur_q + " " + visit[i] + " " + visit[cur_q]);
    				return false;
    			}
    		}
    		
    	}
    	
    	return true;
    	
    }
}
