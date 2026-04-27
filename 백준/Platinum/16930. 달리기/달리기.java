
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node
	{
		int x;
		int y;
		int dist=0;
		int count=0;
		
		Node(int x, int y,int dist, int count)
		{
			this.x = x;
			this.y = y;
			this.dist = dir;
			this.count = count;
		}
	}
	
	static char map[][];
	//static boolean visit[][];
	static int dir;
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int x1,x2,y1,y2;
	static boolean checkin = false; // 도착시 true로 바꿔주고 출력
	static int count =0 ;
	static int N,M,K;
	static int dist[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 이동 가능한 거리
		
		map = new char[N][M];
		//visit = new boolean[N][M];
		dist = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			String s = br.readLine();
			
			for(int j=0; j<M; j++)
			{
				map[i][j] = s.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		st = new StringTokenizer(br.readLine());
		x1= Integer.parseInt(st.nextToken())-1;
		y1= Integer.parseInt(st.nextToken())-1;
		x2= Integer.parseInt(st.nextToken())-1;
		y2= Integer.parseInt(st.nextToken())-1;
		
		if(!(x1==x2 && y1==y2))
		{
			bfs();			
		}
		else
		{
			checkin = true;
		}
		
		if(checkin) bw.write(Integer.toString(count));
		else bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs()
	{
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x1,y1,0,0));
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			//System.out.println(" node.x : " +  node.x  + " node.y : " +  node.y);
			for(int i=0; i<4; i++) // 방향 결정해서 가능한 방향 정하고 갈 수 있는 거리 만큼 이동
			{
				for(int j=1;j<=K;j++)
				{
					//System.out.println("dx :" );
					int dx = node.x + delta[i][0] * j;
					int dy = node.y + delta[i][1] * j;
					
					if(!(dx>=0 && dx < N && dy>=0 && dy<M)) break; // 배열 범위 체크
					//if(visit[dx][dy])continue;
					if(map[dx][dy] != '.' ||  node.count + 1> dist[dx][dy]) break;		// 장애물 및 방문 체크
					if(dist[dx][dy] == node.count + 1) continue;
					if(dx == x2 && dy == y2)
					{
						checkin = true;
						count = node.count +1;
						return;
					}
					//System.out.println(" node.x : " +  node.x  + " node.y : " +  node.y +" dx : " + dx + "dy : " + dy + "node.count : " + node.count);
					q.add(new Node(dx,dy,0,node.count+1));
					dist[dx][dy] = node.count+1;
					//visit[dx][dy] = true;
				
				}
				
			}
				
		}
	}
}
