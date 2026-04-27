import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;


public class Main {
	
	static final int INF = Integer.MAX_VALUE/2-1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dist[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1;j<=N; j++)
			{
				if(i==j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for(int i=0; i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = c;
		}
		
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				for(int k=1; k<=N; k++)
				{
					if(dist[j][i] + dist[i][k] < dist[j][k])
					{
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
		}
		
//		for(int i=1; i<=N; i++)
//		{
//			for(int j=1; j<=N; j++)
//			{
//				System.out.print(dist[i][j] + " ");
//			}
//			System.out.println("");
//		}
		
		int min = Integer.MAX_VALUE-1;
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				if(i==j) continue;
				if(dist[i][j] == INF || dist[j][i]==INF) continue;
				if(min > dist[i][j] + dist[j][i]) 
				{
					//System.out.println(i + " "+ j +" dist[i][j] + dist[j][i] : " + dist[i][j] + dist[j][i]);
					min = dist[i][j] + dist[j][i];
				}
			}
		}
		
		if(min == Integer.MAX_VALUE-1) min = -1;
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
