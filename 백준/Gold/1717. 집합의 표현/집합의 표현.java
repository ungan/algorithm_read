import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] rank;
	
	/*
	public UnionFind(int n)
	{
		parent = new int[n];
		rank = new int[n];
		for(int i=0; i<n; i++)
		{
			parent[i] =i;		// 자기 자신이 루트
			rank[i] = 1;		// 집합의 크기는 1
		}
		
	}*/
	
	public static int find(int x) {
		if(parent[x] != x)
		{
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return;
		
		if(rank[rootA] < rank[rootB]) {
			parent[rootA] = rootB;
		}
		else if(rank[rootA] > rank[rootB])
		{
			parent[rootB] = rootA;
		}
		else
		{
			parent[rootB] = rootA;
			rank[rootA]++;
		}
	}
	
	public boolean isConnected(int a, int b)
	{
		return find(a) == find(b);
	}
		
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		rank = new int[N+1];
		
		for(int i=0; i<=N; i++)
		{
			parent[i] = i;
			rank[i] = 1;
			//System.out.println(parent[i] + " " +  rank[i] );
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==0)
			{
				union(b,c);
			}
			else
			{
				//System.out.println(find(a) + " " +  find(b));
				
				if(find(b) == find(c))
				{
					bw.write("YES\n");
				}
				else
				{
					bw.write("NO\n");
				}
			}
			
					
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
