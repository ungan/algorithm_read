import java.util.*;
import java.io.*;

public class Main{
	
    public static void main(String[] args)throws IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
        
        int depth[] = new int[N+1];
        int build_time[] = new int[N+1];
        int total_time[] = new int[N+1];
        
        for(int i=0; i<=N ; i++)
        {
        	arraylist.add(new ArrayList());
        }
        
        for(int i=1; i<=N ; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	build_time[i] = Integer.parseInt(st.nextToken());
        			
        	while(true)
        	{
        		int b = Integer.parseInt(st.nextToken());
        		
        		if(b==-1) break;
        		
        		arraylist.get(b).add(i);
        		depth[i]++;
        		
        	}
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=1; i<=N; i++)
        {
        	if(depth[i] == 0)
        	{
        		q.add(i);
        		total_time[i] = build_time[i];
        	}
        }
        
        while(!q.isEmpty())
        {
        	int now = q.poll();
        	
        	for(int next : arraylist.get(now))
        	{
        		depth[next]--;
        		
        		if(total_time[next] < build_time[next] + total_time[now])
        		{
        			total_time[next] = build_time[next] + total_time[now];        			
        		}
        		
        		if(depth[next] == 0)
        		{
        			q.add(next);
        		}
        	}
        }
        
        for(int i=1; i<=N; i++)
        {
        	bw.write(Integer.toString(total_time[i]) + "\n");
        }
        
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    
    
}