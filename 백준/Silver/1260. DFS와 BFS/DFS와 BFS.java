import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int size=0;
	static int N=0;
	static int m=0;
	static Queue<Integer> q = new LinkedList<>();
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws Exception
    {

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int V = Integer.parseInt(st.nextToken());
    	
    	int array[][] = new int[N+1][N+1];
    	boolean value[] = new boolean[N+1];
    	
    	for(int i=0; i<M; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		int a =  Integer.parseInt(st.nextToken());
    		int b =  Integer.parseInt(st.nextToken());
    		
    		array[a][b] = array[b][a] = 1;
    	}
    	
    	dfs(array,value,V);
    	bw.write("\n");
    	value = new boolean[N+1];
    	bfs(V,value,array);
    	bw.write("\n");
    	bw.flush();
    	bw.close();
    	
    }
    
    static void dfs(int[][] array,boolean[] value,int w) throws IOException
    {
    	bw.write(Integer.toString(w) + " ");
    	value[w] = true;
    	
    	for(int i=1; i <= N;i++)
    	{
    		if(value[i] == false && array[w][i] == 1)
    		{
    			dfs(array,value,i);
    		}
    	}
    }
    
    static void bfs(int start,boolean[] value,int[][] array) throws IOException
    {
    	q.add(start);
    	value[start] = true;
    	
    	while(!q.isEmpty())
    	{
    		start = q.poll();
    		bw.write(Integer.toString(start) + " ");
    		
    		for(int i=1; i<=N;i++)
    		{
    			if(array[start][i] == 1 && value[i] == false)
    			{
    				q.add(i);
    				value[i] = true;
    			}
    		}
    	}
    	
    }
}
