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
	static int delta[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int H;
	static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++)
		{
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			char c[][] = new char[H][W];
			
			for(int i=0; i<H ; i++)
			{
				String s = br.readLine();
				for(int j=0; j<W; j++)
				{
					c[i][j] =s.charAt(j);
				}
			}
			
			int count=0;
			
			for(int i=0; i<H ; i++)
			{
				for(int j=0; j<W; j++)
				{
					if(c[i][j] == '#')
					{
						dfs(c,i,j);
						count++;
					}
				}
				
			}
			
			
			bw.write(count + "\n");
			
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(char c[][], int x, int y)
	{
		c[x][y] = '.';
		
		for(int i=0; i<4; i++)
		{
			int dx = x+delta[i][0];
			int dy = y+delta[i][1];
			
			if(dx >=0 && dx<H && dy>=0 && dy <W && c[dx][dy] == '#')
			{
				dfs(c,dx,dy);
			}
		}
	}

}
