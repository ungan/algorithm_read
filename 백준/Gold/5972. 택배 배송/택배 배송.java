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
		int cost;
		
		public Node(int end, int cost)
		{
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Node>[] list = new List[N+1];
		int[] costList = new int[N+1];
		
		for(int i=1; i<=N; i++)
		{
			list[i] = new ArrayList<>();
			costList[i] = INF;
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
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		costList[1] = 0;
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			
			if(node.cost > costList[node.end])
			{
				continue;
			}
			
			for(Node next_node : list[node.end])
			{
				if(costList[next_node.end] > next_node.cost + costList[node.end])
				{
					costList[next_node.end] = next_node.cost + costList[node.end];
					pq.add(new Node(next_node.end,costList[next_node.end]));
				}
			}
		}
		
		bw.write(Integer.toString(costList[N]));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
