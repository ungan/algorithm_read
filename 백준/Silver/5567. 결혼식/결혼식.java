import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean value[]; 
	static int visit[]; 
	static int total_cnt =0;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int array[][] = new int[N+1][N+1];
		value = new boolean[N+1];
		visit = new int[N+1];
		
		//map<Integer,Intger>  map = new HashMap<>();
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			array[x][y] = array[y][x] =1;
		}
		int cnt=0;
		value[1] = true;
		//dfs(array,1,cnt);
		bfs(array,1);
		
		bw.write(Integer.toString(total_cnt));
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int [][] array, int n,int cnt)
	{
		if(cnt == 3) return;
		for(int i=1; i<N; i++)
		{
			if(value[i] == false && array[n][i] == 1)
			{
				value[i] = true;
				System.out.println("i : " + i);
				cnt++;
				total_cnt++;
				dfs(array,i,cnt);
			}

		}
	}
	
	static void bfs(int [][]array,int n)
	{
		q.add(n);
		visit[n] = 1;
		while(!q.isEmpty())
		{
			int start = q.poll();
			//System.out.println("start : " + start );
			if(visit[start] >= 3)
			{
				//System.out.println("stop");
				break;
			}
			
			for(int i=1; i<=N;i++)
			{
				if(visit[i] == 0 && 1 == array[i][start])
				{
					total_cnt++;
					visit[i] += visit[start] + 1;
					//System.out.println("i : " + i + "visit[i] : " + visit[i]);
					q.add(i);
				}				
			}
		}
		
	}
}
