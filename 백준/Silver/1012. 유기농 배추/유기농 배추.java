import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int delta[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int M=0;
	static int N =0;
    public static void main(String[] args) throws Exception
    {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int T=0; T<t;T++)
    	{
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		M=Integer.parseInt(st.nextToken());
    		N=Integer.parseInt(st.nextToken());
    		int K=Integer.parseInt(st.nextToken());
    		int array[][] = new int[M][N];
    		
    		for(int i=0; i<K; i++)
    		{
    			st = new StringTokenizer(br.readLine()); 
    			int x=Integer.parseInt(st.nextToken());
    			int y=Integer.parseInt(st.nextToken());
    			
    			array[x][y] = 1;
    		}
    		int count=0;
    		for(int i=0; i<M; i++)
    		{
    			for(int j=0; j<N; j++)
    			{
    				if(array[i][j] == 1)
    				{
    					
    					dfs(array,i,j);
    					count++;
    				}
    			}
    		}
    		
    		bw.write(Integer.toString(count)+"\n");
    	}
    	bw.flush();
    	bw.close();
    }
    
    static void dfs(int array[][],int x, int y)
    {
    	array[x][y] =0;
    	
    	for(int i=0; i<delta.length;i++)
    	{
    		int dx = x + delta[i][0];
    		int dy = y + delta[i][1];
    		
    		if(dx>=0 && dx <M && dy>=0 && dy<N && array[dx][dy] == 1)
    		{
    			dfs(array,dx,dy);
    		}
    	}
    }
    
}
