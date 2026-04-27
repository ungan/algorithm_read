
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean value[];
	static int n;
	static int count = 0;
	static Queue<Integer> q =  new LinkedList<>();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws Exception
    {
    	
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	int[][] array = new int[n+1][n+1];
    	value = new boolean[n+1];
    	
    	for(int i=0; i<m; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		int x= Integer.parseInt(st.nextToken());
    		int y= Integer.parseInt(st.nextToken());
    		
    		array[x][y] = array[y][x] = 1;
    		
    	}

    	//dfs(array, 1);
    	//bw.write(Integer.toString(count)+"\n");
    	value = new boolean[n+1];

    	//count=0;
    	bfs(array, 1);
    	if(m==0) count=0;
    	bw.write(Integer.toString(count));
    	bw.flush();
    	bw.close();
    	
    }
    
    static void dfs(int [][]array,int a)
    {
    	value[a] = true;
    	
    	for(int i=0; i<n; i++)
    	{
    		
    		if(array[a][i] == 1 && value[i] == false)
    		{
    			count++;
    			value[i] = true;
    			dfs(array,i);
    		}
    	}
    }
    
    static void bfs(int [][]array, int a)
    {
    	value[a] = true;
    	q.add(a);
    	count=1;
    	
    	while(q.isEmpty() == false)
    	{
    		int start = q.poll();
    		//count++;
    		for(int i=1; i<=n; i++)
    		{
    			if(value[i] == false && array[start][i] == 1)
    			{
    				count++;
    				q.add(i);
    				value[i] = true;
    			}
    		}
    	}
    	
    	if(count >1) count--;
    }
    
}
