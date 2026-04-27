import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int delta[][] = {{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
	static int W;
	static int H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true)
		{
			
			st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W==0 && H ==0) break;
			
			int array[][] =new int[H][W];
			
			for(int i=0; i <H; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++)
				{
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			
			for(int i=0; i <H; i++)
			{
				for(int j=0; j<W; j++)
				{
					if(array[i][j] == 1)
					{
						array[i][j]=0;
						cnt++;
						dfs(array,i,j);
					}
				}
				
			}
			bw.write(Integer.toString(cnt) + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int [][]array,int x,int y)
	{
		for(int i=0; i<delta.length; i++)
		{
			int dx = x+ delta[i][0];
			int dy = y+ delta[i][1];
			
			if(dx>=0&&dx<H && dy>=0 && dy<W && array[dx][dy] == 1)
			{
				array[dx][dy] =0;
				dfs(array,dx,dy);
			}
		}
	}
}

