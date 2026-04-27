import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static class Edge implements Comparable<Edge>
	{
		int to;
		int cost;
		
		Edge(int to, int cost)
		{
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static ArrayList<Edge> list[];
	static int distance[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list= new ArrayList[N+1];
		
		for(int i=0; i<=N; i++)
		{
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//System.out.println("a");
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
			//System.out.println(a + " " + b + " " + c);
		}
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int a = da(1,v);
		int b = da(v,e);
		int c = da(e,N);
		
		int a2 = da(1,e);
		int b2 = da(e,v);
		int c2 = da(v,N);
		
		//System.out.println(a + " " + b + " " + c);
		
		if(a==-1 || b==-1 || c==-1 || a2==-1 || b2==-1 || c2==-1) bw.write("-1");
		else bw.write(Integer.toString(Math.min(a+b+c, a2+b2+c2)));
		
		bw.flush();
		bw.close();
		br.close();
			
	}
	
	public static int da (int start, int end)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE-1);
		//System.out.println("start : " + start + " end " + end);
		pq.add(new Edge(start,0));
		distance[start] =0;
		
		if(start == end) return 0;
		
		while(!pq.isEmpty())
		{
			Edge edge = pq.poll();
			//System.out.println("edge : " + edge.to);
			
			for(Edge next : list[edge.to])
			{
				if(distance[next.to] > distance[edge.to] + next.cost) {
				    distance[next.to] = distance[edge.to] + next.cost;
				    pq.add(new Edge(next.to, distance[next.to]));
				}

				/*
				if(distance[next.to] <= distance[edge.to] + next.cost) continue;
				//System.out.println("edge : " + next.to);
				
				distance[next.to] = distance[edge.to] + next.cost;
				pq.add(new Edge(next.to,distance[next.to]));
				//pq.add(new Edge(0,0));
				//if(next.to == end) return distance[next.to];*/
			}
		}
		
		if(distance[end] == Integer.MAX_VALUE-1) return -1;
		else return distance[end];
	}
}
