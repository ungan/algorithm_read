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
	static int[] path; // 경로를 저장하기 위한 배열
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean visit[] = new boolean[n+1];
		List<Node>[] list = new List[n+1];
		int[] costList = new int[n+1];
		path = new int[n + 1];
		
		for(int i=1; i<=n; i++)
		{
			costList[i] = INF;
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start_node = Integer.parseInt(st.nextToken());
		int target_node = Integer.parseInt(st.nextToken());
		costList[start_node] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		/*
		for(Node node : list[start_node])
		{
			pq.add(node);
		}*/
		pq.add(new Node(start_node, 0));
		
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			
			if(node.cost > costList[node.end])
			{
				continue;
			}
			
			for(Node next : list[node.end])
			{
				if(next.cost + costList[node.end] <  costList[next.end])
				{
					costList[next.end] = next.cost + costList[node.end];
					//System.out.println("node.cost :" + node.cost + "costList[node.end] : " + costList[node.end]);
					pq.add(new Node(next.end, costList[next.end]));
					path[next.end] = node.end; // 경로 저장
				}

			}
			
		}
		
		// 최단 비용 출력
		for(int i=0; i<costList.length; i++)
		{
			//bw.write(String.valueOf(costList[i]) + "\n");
		}
        bw.write(String.valueOf(costList[target_node]) + "\n");

        // 최단 경로 출력
        Stack<Integer> route = new Stack<>();
        int currentNode = target_node;
        while (currentNode != 0) {
            route.push(currentNode);
            currentNode = path[currentNode];
        }
        
        bw.write(String.valueOf(route.size()) + "\n");
        while (!route.isEmpty()) {
            bw.write(route.pop() + " ");
        }
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void depth(boolean visit[],int start_node,List<Node>[] list,int[] costList)
	{
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(Node node : list[start_node])
		{
			pq.add(node);
			visit[node.end] = true;
		}
		
		Node node = pq.poll();
		
		for(Node next : list[node.end])
		{
			if(!visit[next.end])
			{
				visit[next.end] = true;
				pq.add(new Node(next.end, costList[next.end]));
			}

		}
	}
}
