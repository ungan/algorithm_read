import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main{
	static int N;
	static int M;
	static int output[];
	static boolean visit[];
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[N];
		visit = new boolean[N+1];
			
		dfs(0,1);
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int depth,int num) throws IOException
	{
		if(depth == M)
		{
			for(int i=0; i<M;i++)
			{
				bw.write(Integer.toString(output[i]) + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=num; i<=N;i++)
		{
			if(visit[i]) continue;
			
			output[depth] = i;
			visit[i] = true;
			dfs(depth+1,i+1);
			visit[i] = false;
		}
	}

}