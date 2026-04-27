import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>
	{
		int end;
		int distance;
		
		public Node(int end, int distance)
		{
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
		
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;//= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		list = new List[N+1];
		int[] distance_A = new int[N+1];
		int[] distance_B = new int[N+1];
		int[] distance_C = new int[N+1];
		
		for(int i=1; i<=N; i++)
		{
			distance_A[i] = INF;
			distance_B[i] = INF;
			distance_C[i] = INF;
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		da(distance_A,A);
		da(distance_B,B);
		da(distance_C,C);
		int max=0;
		int max_node=0;
		for(int i=1; i<=N; i++)
		{
			int min = INF;
			
			if(distance_A[i] < min) min = distance_A[i];
			if(distance_B[i] < min) min = distance_B[i];
			if(distance_C[i] < min) min = distance_C[i];
			
			if(max < min) 
			{
				max = min;
				max_node = i;
			}
		}
		
		bw.write(Integer.toString(max_node));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void da(int[] distance, int start_node)
	{
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start_node,0));
		distance[start_node] = 0;
		
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			
			if(node.distance > distance[node.end])
			{
				continue;
			}
			
			for(Node next : list[node.end])
			{
				if(distance[next.end] > distance[node.end] + next.distance)
				{
					distance[next.end] = distance[node.end] + next.distance;
					pq.add(new Node(next.end,distance[next.end]));
				}
			}
		}
		
	}
}
