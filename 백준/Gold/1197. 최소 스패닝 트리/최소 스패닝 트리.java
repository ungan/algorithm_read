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
	
	static int V,E;
	static ArrayList<Edge>[] graph;
	static boolean visited[];
	static int totalweight=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v,w));
			graph[v].add(new Edge(u,w));
		}
		
		long result = prim(1);
		
		bw.write(Long.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long prim(int start)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited = new boolean[V+1];
		pq.add(new Edge(start,0));
		//visited[start] = true;
		int count=0;
		
		while(!pq.isEmpty() && count < V)
		{
			Edge cur = pq.poll();

			if(visited[cur.to]) continue;
			
			visited[cur.to] = true;
			totalweight += cur.weight;
			count++;
			
			for(Edge next :graph[cur.to])
			{
				if(!visited[next.to]) {
					pq.add(next);
				}
			}
		}
		return totalweight;
	}
	

}
