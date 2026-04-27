import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] dist = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++)
        {
        	Arrays.fill(dist[i], Integer.MAX_VALUE/2-1);
        }
        
        for(int i=0; i<m; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	dist[a][b] = 1;

        	
        }
        
        for(int k=1; k<=n; k++)
        {
        	for(int i=1; i<=n; i++)
        	{
        		for(int j=1; j<=n; j++) 
        		{
        			if(dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
        		}
        	}
        }
        
        int count = n;
        
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=n; j++) {
        		
        		if(i == j) continue;
        		
        		if(dist[i][j] == Integer.MAX_VALUE/2-1 && dist[j][i] == Integer.MAX_VALUE/2-1)
        		{
        			count--;
        			break;
        		}
        	}
        }
        
        bw.write(Long.toString(count));
        bw.flush();
        bw.close();
        
        
    }
}