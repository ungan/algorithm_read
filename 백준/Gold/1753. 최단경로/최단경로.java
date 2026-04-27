import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight)
		{
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[] distance = new int[V+1];
		List<Node>[] list = new List[V+1];
		
		// 연결 정보 저장 배열 최단 경로 값 저장 배열 초기화
		for(int i=1; i<=V; i++)
		{
			list[i] = new ArrayList<>();
			distance[i] = INF;
		}
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[v].add(new Node(e,w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[K] = 0;
		pq.add(new Node(K,0));
		
		while(!pq.isEmpty())
		{
			Node now = pq.poll();
			
			if(now.weight > distance[now.end])
			{
				continue;
			}
			
			for(Node next : list[now.end])
			{
				if(distance[now.end] + next.weight < distance[next.end]) {
					distance[next.end] = distance[now.end] + next.weight;
					pq.add(new Node(next.end, distance[next.end]));
				}
			}
		}
		
		for(int i=1; i<=V; i++)
		{
			if(distance[i] == INF)
			{
				System.out.println("INF");
			}
			else
			{
				System.out.println(distance[i]);
			}
		}
		
	}

}
