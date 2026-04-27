import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

import org.omg.CORBA.INTERNAL;

public class Main {
	static class Edge implements Comparable<Edge>
	{
		int to;
		int weight;
		
		Edge(int to, int weight)
		{
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static boolean visited[];
	static int N,M;
	static ArrayList<Edge>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v,w));
			graph[v].add(new Edge(u,w));
		}
		
		long result = prim(1);
		
		bw.write(Long.toString(result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long prim(int start)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		pq.add(new Edge(start,0));
		
		int total_weight = 0;
		int count=0;
		
		while(!pq.isEmpty() && count < N)
		{
			Edge e = pq.poll();
			//System.out.println("a");
			if(visited[e.to]) continue;
			
			visited[e.to] = true;
			count++;
			total_weight += e.weight;
			
			for(Edge i : graph[e.to])
			{
				if(visited[i.to]) continue;
				
				pq.add(i);
			}
		}
		
		return total_weight;
	}


}
