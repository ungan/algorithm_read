import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int parents[];
	static int size[];
	
	static int find(int x)
	{
		if(parents[x] != x)
		{
			parents[x] = find(parents[x]);
		}
		
		return parents[x];
	}
	
	static void union(int x, int y)
	{
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return;
		
		if(size[rootX] < size[rootY]) {
			parents[rootX] = rootY;
			size[rootX] += size[rootY]; 
		}
		else if(size[rootX] >= size[rootY]) {
			parents[rootY] = rootX;
			size[rootX] += size[rootY];
		}

		
	}
	
	static boolean islinked(int x, int y)
	{
		return find(x) == find(y);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		size = new int[N];
		int count=0;
		
		for(int i=0; i<N; i++)
		{
			parents[i]=i;
			size[i]=1;
		}
		
		for(int i=1; i<=M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(islinked(a, b) && count == 0)
			{
				count=i; 
			}
			union(a,b);
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
