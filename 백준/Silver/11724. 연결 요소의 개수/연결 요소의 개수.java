import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[] value;
	static Queue<Integer> q = new LinkedList<>();
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int array[][] = new int[N+1][N+1];
    	value = new boolean[N+1];
    	
    	
    	for(int i=0; i<M; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		int x=Integer.parseInt(st.nextToken());
    		int y=0;
    		if(N != 1) y=Integer.parseInt(st.nextToken());
    		array[x][y] = array[y][x] = 1;
    	}
    	
    	int count=0;
    	
    	/*
    	for(int i=0; i<=N; i++)
    	{
    		for(int j=0; j<=N; j++)
    		{
    			if(value[i] == false && array[i][j] ==1)
    			{
    				count++;
    				value[i] = true;
    				dfx(array,i);
    			}
    			
    		}
    	}*/
    	
    	//bw.write(Integer.toString(count));
    	//count=0;
    	value = new boolean[N+1];
    	
    	for(int i=1; i<=N; i++)
    	{
    		
			if(value[i] == false)
			{
				count++;
				//System.out.println("i : " + i);
				bfs(array,i);
			}
    	}
    	
    	//if(M ==0) count = N;
    	
    	bw.write(Integer.toString(count));
    	
    	
    	bw.flush();
    	bw.close();
    	
    }
    
    static void dfx(int [][]array,int n)
    {
    	value[n] = true;
		for(int i=0; i<=N; i++)
		{
			if(value[i] == false && array[n][i] ==1)
			{
				value[i] = true;
				dfx(array,i);
			}
		}
	
    }
    
    static void bfs(int [][]array,int n)
    {
    	value[n] = true;
    	q.add(n);
    	
    	while(q.isEmpty() == false)
    	{
    		int start = q.poll();
    		
    		for(int i=0; i<=N;i++)
    		{
    			if(value[i] == false && array[start][i]==1)
    			{
    				value[i] = true;
    				q.add(i);
    			}
    		}
    	}
    }
    
   
}
