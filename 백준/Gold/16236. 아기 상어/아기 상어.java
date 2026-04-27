import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>
	{
		int x;
		int y;
		int count;
		
		Node(int x, int y, int count)
		{
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			if(this.x == o.x)
				return this.y - o.y;
			
			return this.x - o.x;
		}
	}
	
	static Node shark;
	static int count=0;
	static int delta[][] = {{-1,0},{0,-1},{0,1},{1,0}};
	static int n;
	static int shark_size=2;
	static int eat_count=0;
	static int map[][];
	static PriorityQueue<Node> pq  = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9)
				{
					map[i][j] = 0;
					shark = new Node(i,j,0);
				}
			}
		}
		
		
		while(true)
		{
			//System.out.println("a");
			int temp =count;
			bfs();
			
			if(pq.isEmpty()) break;
			else
			{
				Node node = pq.poll();
				eat_count++;
				count += node.count;
				grow_shark();
				int dx = node.x;
				int dy = node.y;
				shark = new Node(dx,dy,0);
				map[dx][dy] = 0;
				//System.out.println(dx + " " + dy);
				pq.clear();
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
	
	static void bfs()
	{
		int min= Integer.MAX_VALUE-1;
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[n][n];
		q.add(shark);
		visit[shark.x][shark.y] = true;
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			//System.out.println("b");
			for(int i=0; i<4; i++)
			{
				int dx = node.x + delta[i][0];
				int dy = node.y + delta[i][1];
				
				if(!(dx>=0 && dx<n && dy>=0 && dy<n)) continue;
				if(visit[dx][dy] || shark_size < map[dx][dy]) continue;
				if(min <= node.count) continue;
				
				visit[dx][dy] = true;
				
//				if(node.x == 1 && node.y == 5) 
//				{
//					System.out.println("dx " + dx + " dy : "+dy + " " + (node.count+1));
//					
//				}
				
				if(map[dx][dy]>=1 && shark_size > map[dx][dy])
				{
					
					pq.add(new Node(dx,dy,node.count+1));
					min = node.count+1;

				}
				else
				{
					q.add(new Node(dx,dy,node.count+1));
				}
			}
		}
		
	}
	
	static void grow_shark()
	{
		if(eat_count == shark_size) 
		{
			shark_size++;
			eat_count=0;
		}
	}

}
