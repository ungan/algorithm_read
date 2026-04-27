
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int INF = Integer.MAX_VALUE/2-1;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int dist[][] = new int[N+1][N+1];
		
		for(int i=1 ;i<=N; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N; j++)
			{
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				for(int k=1; k<=N; k++)
				{
					if(dist[j][i] == 1 && dist[i][k] == 1) dist[j][k] = 1;
				}
			}
		}
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				System.out.print(dist[i][j] + " ");
			}
			System.out.println("");
		}
		
    }
}