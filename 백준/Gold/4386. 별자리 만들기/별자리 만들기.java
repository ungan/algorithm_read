import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

import org.omg.CORBA.INTERNAL;

public class Main {
	static class Edge implements Comparable<Edge>
	{
		int to;
		double weight;
		
		Edge(int to, double weight)
		{
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight,o.weight);
		}
		
		
	}
	static int N;
	static ArrayList<Edge>[] graph;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		double array[][] = new double[N+1][2];
		
		for(int i=1; i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			array[i][0] = Double.parseDouble(st.nextToken());
			array[i][1] = Double.parseDouble(st.nextToken());
		}
		
		graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++)
		{
			for(int j=i+1; j<=N; j++)
			{
				double x = Math.abs(array[i][0] - array[j][0]);
				double y = Math.abs(array[i][1] - array[j][1]);
				
				double distance = Math.sqrt(x*x+y*y);
				//System.out.println("distnace : " + distance);
				graph[i].add(new Edge(j,distance));
				graph[j].add(new Edge(i,distance));
			}
		}
		
		double result = prim(1);
		DecimalFormat df = new DecimalFormat("0.00");
		
		//bw.write(result + "\n");
		bw.write(df.format(result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static double prim(int start)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start,0));
		int count=0;
		double result_sum=0;
		visited = new boolean[N+1];
		
		while(!pq.isEmpty() && count < N)
		{
			Edge cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			count++;
			//System.out.println("cur : " + cur.to + "Math.sqrt(cur.weight) " +cur.weight);
			result_sum += cur.weight;
			
			for(Edge e : graph[cur.to])
			{
				if(visited[e.to]) continue;
				pq.add(e);
			}
			
		}
		
		return result_sum;
	}
	
}

