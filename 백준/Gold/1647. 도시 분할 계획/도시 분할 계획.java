import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>
{
	int u;
	int v;
	int cost;
	
	public Edge(int u, int v, int cost)
	{
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
	
}

public class Main {
	static int parents[];
	static int size[];
	
	static int find(int x)
	{
		if(parents[x] != x) parents[x] = find(parents[x]);
		return parents[x];
	}
	
	static boolean union(int x,int y)
	{
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return true;
		
		if(size[rootX] > size[rootY])
		{
			size[rootX] += size[rootY];
			parents[rootY] = rootX;
			
		}
		else
		{
			size[rootY] += size[rootX];
			parents[rootX] = rootY;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> edge = new ArrayList<>();
		parents = new int[N+1];
		size = new int[N+1];
		
		for(int i=0; i<=N;i++) parents[i] = i;
		
		for(int i=0; i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge.add(new Edge(a,b,c));
		}
		Collections.sort(edge);
		List<Edge> mst = new ArrayList<>();
		int mst_cost=0;
		
		for(Edge e : edge)
		{
			if(union(e.u,e.v)) continue;
			
			mst_cost+= e.cost;
			mst.add(e);
			//System.out.println("e.cost : " + e.cost);
			if(N-2 == mst.size()) break;
		}
		
		if(N==2) mst_cost =0;
		
		bw.write(Long.toString(mst_cost));
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
