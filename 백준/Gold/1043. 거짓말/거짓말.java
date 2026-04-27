import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int size[];
	static int find(int x)
	{
		if(parent[x] != x)
		{
			parent[x] =  find(parent[x]);
		}
		
		return parent[x];
	}
	
	static void union(int x, int y)
	{
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return;
		
		if(size[rootX] > size[rootY])
		{
			size[rootX] += size[rootY];
			parent[rootY] = rootX;
		}
		else
		{
			size[rootY] += size[rootX];
			parent[rootX] = rootY;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		size = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		int t_count = Integer.parseInt(st.nextToken());
		int trust_p[] = new int[t_count];
		
		
		for(int i=0; i<=N; i++)
		{
			parent[i] = i;
			size[i] = 1;
		}
		
		for(int i=0; i < t_count; i++)
		{
			trust_p[i] = Integer.parseInt(st.nextToken());
		}
		
		//st = new StringTokenizer(br.readLine());
		List<int[]> partys = new ArrayList<>();
		
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			//System.out.println("i : " + i);
			int party_mem = Integer.parseInt(st.nextToken());
			int member[] = new int[party_mem];
			
			for(int j=0; j<party_mem; j++)
			{
				member[j] = Integer.parseInt(st.nextToken());
			}
			partys.add(member);
			
			for(int j=1; j<party_mem; j++)
			{
				union(member[0],member[j]);
			}
		}
		
		boolean truth[] = new boolean[N+1];
		
		for(int tp : trust_p)
		{
			truth[find(tp)] = true;
		}
		
		int count=0;
		
		for(int[] party : partys)
		{
			boolean trust_party = false;
			
			for(int p : party)
			{
				if(truth[find(p)]) 
				{
					trust_party = true;
					break;
				}
			}
			if(trust_party) continue;
			count++;
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
