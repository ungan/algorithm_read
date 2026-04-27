import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static class Node
	{
		int x;
		int y;
		int dir;
		
		Node(int x , int y,int dir)
		{
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int row[][] = {{0,1},{0,0},{1,1}};				// 가로 일때 움직일 수 있음
	static int col[][] = {{0,0},{1,0},{1,1}};				// 세로 일때 움직일 수 있움
	static int diagonal[][] = {{0,1},{1,0},{1,1}};	// 대각일 때 움직임
	
	static int dir[][][] = {row,col,diagonal};
	
	static int N;
	static int count=0;
	static int map[][];
	static int dp[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;//=  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];		// 0은 가로 1은 세로 2는 대각
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp[1][2] = 
		dp();
		int sum = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dp(){
		dp[0][1][0] = 1;
		
		for(int i=0; i<N; i++)
		{
			for(int j=1; j<N;j++)
			{
				if(map[i][j] == 1) continue;
				if(i==0) 
				{
					//System.out.println("adsf : " + dp[i][j-1][0]);
					dp[i][j][0] += dp[i][j-1][0]; // 가로가 가로
					//System.out.println(" dp[i][j-1][0] : " +  dp[i][j-1][0]);
					continue;
				}
				
				
				
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];	// 세로가 세로
				//System.out.println(i + " " + j + " dp[i-1][j-1][0] : " +  dp[i-1][j-1][0]);
				
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				
				dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				//System.out.println(i + " " + j + "dp[i][j][2]  : " + dp[i-1][j-1][0] +" " +   dp[i-1][j-1][1] + " " + dp[i-1][j-1][2]);
				//System.out.println(i + " " + j + " dp[i-1][j][1] : " +  dp[i-1][j][1] + " "+ dp[1][2][2]);
			}
		}
		
	}
	
	
}
