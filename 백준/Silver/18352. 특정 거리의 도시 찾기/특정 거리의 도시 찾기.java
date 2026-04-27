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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 개수
		int M = Integer.parseInt(st.nextToken()); // 도로 개수
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		List<Node>[] list = new List[N+1]; 
		int distances[] = new int[N+1];
	
		for(int i=1; i<=N; i++)
		{
			distances[i] = INF;
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = 1; 
			
			list[a].add(new Node(b,c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distances[X] = 0;
		pq.add(new Node(X,0));
		
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			
			if(node.distance > distances[node.end])
			{
				continue;
			}
			
			for(Node next : list[node.end])
			{
				if(distances[next.end] > next.distance + distances[node.end])
				{
					distances[next.end] = next.distance + distances[node.end];
					pq.add(new Node(next.end,distances[next.end]));
				}
			}
		}
		int count=0;
		for(int i=1; i<distances.length;i++)
		{
			if(distances[i] == K)
			{
				count++;
				bw.write(Integer.toString(i)+"\n");
			}
			//System.out.println(distances[i]);
		}
		
		if(count == 0)
		{
			bw.write("-1" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
