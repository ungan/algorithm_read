import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int rank[];
	
	static int find(int x)
	{
		if(parent[x] != x)
		{
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int x, int y)
	{
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return;
		
		if(rank[rootX] < rank[rootY])
		{
			parent[rootX] = rootY;
		}
		else if(rank[rootX] > rank[rootY])
		{
			parent[rootY] = rootX;
		}
		else
		{
			parent[rootY] = rootX;
			rank[rootX]++;
		}
	}
	
	public static boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}
		
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		rank = new int[N+1];
		
		for(int i=0; i<=N; i++)
		{
			parent[i] = i;
			rank[i] = 0;
		}
		
		
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++)
			{
				int n =Integer.parseInt(st.nextToken());
				if(n == 1) union(i,j);
				//System.out.println("i : " + i + "n : " + n);
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		
		int start = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens())
		{
			int b = Integer.parseInt(st.nextToken());
			if(!isConnected(start, b))
			{
				System.out.println("NO");
				return;
			}
			//start = b;
		}
		
		System.out.println("YES");
		/*
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));  // 첫 도시의 루트

		while(st.hasMoreTokens()){
		    int city = Integer.parseInt(st.nextToken());
		    if(find(city) != root){
		        System.out.println("NO");
		        return;
		    }
		}
		System.out.println("YES");
		*/
		bw.flush();
		bw.close();
		br.close();
		
	}

}
