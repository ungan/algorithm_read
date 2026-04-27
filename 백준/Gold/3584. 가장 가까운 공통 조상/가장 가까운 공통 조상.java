import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] tree;
	static int[][] parent;
	static int[] depth;
	static boolean[] visit;
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int t= Integer.parseInt(br.readLine());
        
        for(int T=0; T<t; T++)
        {
        	
        	N = Integer.parseInt(br.readLine());
        	
        	tree = new ArrayList[N+1];
        	parent = new int[21][N+1];
        	depth = new int[N+1];
        	visit = new boolean[N+1];
        	
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
        		parent[0][b] = a;
        		//tree[b].add(a);
        	}
        	int root=0;
        	for(int i=1 ; i<=N; i++)
        	{
        		root = i;
				//System.out.println("i in : " + i + " " + parent[0][i]);
        		if(parent[0][i]==0)
				{
					//System.out.println("root in : " + root + " " + parent[0][root]);
					break; 
				} 
					
        	}
        	
        	//System.out.println("root : " + root + " " + parent[0][root]);
        	dfs(root,0); 
        	dp();
        	
//        int m = Integer.parseInt(br.readLine());
//        for(int i=0; i<m; i++)
//        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int r = lca(a,b);
        	
        	bw.write(Integer.toString(r) + "\n");
        	//}
        }
        
        bw.flush();
        bw.close();
        br.close();
    
    }
    
    static void dfs(int node, int d)
    {
    	visit[node] = true;
    	depth[node] = d;
    	//System.out.println("dfs : "+ node + " " + d);
    	for(int next : tree[node])
    	{
    		if(visit[next]) continue;
    		//System.out.println(node + " " + d + "naxt : " + next);
    		parent[0][next] = node;
    		dfs(next, d+1);
    	}
    }
    
    static void dp()
    {
    	for(int k=1 ; k<=20; k++)
    	{
    		for(int v=1; v<=N; v++)
    		{
    			if(parent[k-1][v] != 0) parent[k][v] = parent[k-1][parent[k-1][v]];
    		}
    		
    	}
    }
    
    static int lca(int a , int b)
    {
    	if(depth[a] < depth[b])
    	{
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	for(int k=20 ; k>=0; k--)
    	{
    		int jump = (int) Math.pow(2, k);
    		
    		if(depth[a]- depth[b] >= jump)
    		{
    			a = parent[k][a];
    		}
    	}
    	//System.out.println("중간");
    	if(a == b) return a;
    	
    	//System.out.println(depth[a] + " " + depth[b]  +" " + a +" " + b);
    	for(int k=20; k>=0; k--)
    	{
    		//System.out.println(" "  + parent[k-1][a]+ " " + parent[k][a]  +" " +  parent[k][b]);
    		if(parent[k][a] != 0 && parent[k][a] != parent[k][b])
    		{
    			a = parent[k][a];
    			b = parent[k][b];
    		}
    	}
    	//System.out.println("끝");
    	return parent[0][a];
    	
    }
    
    
 
   
   
}
