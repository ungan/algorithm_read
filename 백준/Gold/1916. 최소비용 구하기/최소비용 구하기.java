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
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>
	{
		int end;
		int cost;
		
		public Node (int end, int cost)
		{
			this.end = end;
			this.cost =cost;
		}

		@Override
		public int compareTo(Node o1) {
			// TODO Auto-generated method stub
			return this.cost - o1.cost;
		}
	}
	
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int [] distance = new int[N+1];
		List<List<Node>> list = new ArrayList<>();
		
		for(int i=0; i <=N; i++)
		{
			list.add(new ArrayList<>());
			distance[i] = INF;
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(v).add(new Node(e,c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		int start_node = Integer.parseInt(st.nextToken());
		int end_node = Integer.parseInt(st.nextToken());
		distance[start_node] = 0;
		
		pq.add(new Node(start_node, distance[start_node]));
		
		while(!pq.isEmpty())
		{
			Node curNode = pq.poll();
			
			if(curNode.cost > distance[curNode.end])
			{
				continue;
			}
			
			for(Node next : list.get(curNode.end))
			{
				if(distance[curNode.end] + next.cost < distance[next.end])
				{
					distance[next.end] = distance[curNode.end] + next.cost;
					pq.add(new Node(next.end,distance[next.end]));
				}
			}
		}
		
		bw.write(distance[end_node] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
