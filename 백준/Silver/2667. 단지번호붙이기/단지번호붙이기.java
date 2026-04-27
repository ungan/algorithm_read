import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	static int n;
	static int[][]delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int count=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		int array[][] = new int[n][n];
		ArrayList<Integer> a = new ArrayList<>();

		for(int i=0; i<n; i++)
		{
			String s = br.readLine();
			for(int j=0; j<n; j++)
			{
				array[i][j] = s.charAt(j)-'0';
			}
		}
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				count =0;
				dfs(array,i,j);
				
				if(count > 0) a.add(count);
			}
		}
		
		Collections.sort(a);
		
		bw.write(Integer.toString(a.size()) + "\n");
		
		for(int num : a)
		{
			bw.write(Integer.toString(num) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void dfs(int [][]array,int i,int j)
	{
		
		if(array[i][j] == 1)
		{
			count++;
			array[i][j] = 0;
			for(int d =0; d < delta.length; d++)
			{
				int x = i + delta[d][0];
				int y = j + delta[d][1];
				if(x>=0&& x<n && y>=0 && y<n && array[x][y] == 1)
				{
					
					//count++;
					dfs(array,x,y);
				}
			}
			
		}
		
	}

}
