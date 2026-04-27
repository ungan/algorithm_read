import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static int[][] parent_fast;
	static boolean[] visited;
	static int Log = 21;
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[N+1];
        depth = new int[N+1];
        parent = new int[N+1];
        parent_fast = new int[21][N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<=N; i++)
        {
        	tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	tree[a].add(b);
        	tree[b].add(a);
        }
        
        dfs(1,0);
        pedigree();
        
        int m = Integer.parseInt(br.readLine());
        
        for(int i=0; i<m; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	//int r = lca(a,b);
        	int r = lca_fast(a,b);
        	
        	bw.write(Integer.toString(r) + "\n");
        }
        
        
        bw.flush();
        bw.close();
        br.close();
    
    }
    
    static void dfs(int node, int d)
    {
    	visited[node] = true;
    	depth[node] = d;
    	
    	for(int next : tree[node])
    	{
    		if(visited[next]) continue;
    		
    		parent[next] = node;
    		parent_fast[0][next] = node;
    		dfs(next,d+1);
    		
    	}
    }
    
    static void pedigree()
    {
    	for(int k=1; k<Log; k++)
    	{
    		for(int v = 1; v<=N; v++)
    		{
    			if(parent_fast[k-1][v] != 0) parent_fast[k][v] = parent_fast[k-1][parent_fast[k-1][v]];
    		}
    	}
    }
    
    static int lca_fast(int a, int b)
    {
    	if(depth[a] < depth[b])
    	{
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	for(int k=20; k>=0; k--)
    	{
    		int jump = (int)Math.pow(2, k);
    		if(depth[a] - depth[b] >= jump)
    		{
    			a = parent_fast[k][a];
    		}
    	}
    	
    	if(a==b) return a;
    	
    	for(int k=20; k>=0; k--)
    	{
    		 if(parent_fast[k][a] != 0 && parent_fast[k][a] != parent_fast[k][b])
	        {
	            a = parent_fast[k][a];
	            b = parent_fast[k][b];
	        }
    		
    	}
    	
    	return parent[a];
    	
    }
    
    static int lca(int a, int b)
    {
    	if(depth[a] < depth[b])
    	{
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	while(depth[a] != depth[b])
    	{
    		a = parent[a];
    	}
    	
    	while(a != b)
    	{
    		a = parent[a];
    		b = parent[b];
    	}
    	
    	return a;
    }
   
}
