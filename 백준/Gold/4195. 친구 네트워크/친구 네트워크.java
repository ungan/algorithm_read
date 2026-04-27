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
	static HashMap<String,Integer> map;
	
	public static int find(int x)
	{
		if(parents[x]!=x)
		{
			parents[x] = find(parents[x]); // 경로 압축
		}
		return parents[x];
	}
	
	public static void union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return;
		
		if(size[rootA] < size[rootB]) {
			parents[rootA] = rootB;
			size[rootB] += size[rootA];
		}
		else
		{
			parents[rootB] = rootA;
			size[rootA] += size[rootB];
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;
		
		int F = Integer.parseInt(br.readLine());
		
		for(int f=0; f<F; f++)
		{
			
			int N = Integer.parseInt(br.readLine());
			size = new int[N*2+1];
			parents = new int[N*2+1];
			
			int index=0;
			map = new HashMap<>();
			
			for(int i=0; i<parents.length; i++)
			{
				parents[i] = i;
				size[i] = 1;
			}
			
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String s2 = st.nextToken();
				
				if(!map.containsKey(s)) map.put(s, index++);
				if(!map.containsKey(s2)) map.put(s2, index++);
				
				int aIndex = map.get(s);
				int bIndex = map.get(s2);
				
				union(aIndex,bIndex);
				System.out.println(size[find(aIndex)]);
				
				
			}
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
