import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int N=0;
	static int total=0;
	static int min=0;
	static int min_n=0;
	static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		
		for(int i=0; i<=N; i++)
		{
			
			arrayList.add(new ArrayList());
		}
		
		for(int i=0; i<M; i++)
		{
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 arrayList.get(a).add(b);
			 arrayList.get(b).add(a);
		}
		bfs(1);
		min = total;
		min_n = 1;
		for(int i=2; i<=N;i++)
		{
			total=0;
			bfs(i);
			if(min > total) 
			{
				min_n = i;
				min = total;
			}
		}
		bw.write(min_n+"\n");
		bw.flush();
		bw.close();
	}
	
	static void bfs(int num)
	{
		Queue<SimpleEntry<Integer,Integer>> queue = new LinkedList<>();
		boolean visit[] = new boolean[N+1];
		queue.add(new SimpleEntry(num,0));
		visit[num] = true;
		while(!queue.isEmpty())
		{
			SimpleEntry se = queue.poll();
			int start_key = (int) se.getKey();
			int d = (int) se.getValue();
			for(int n : arrayList.get(start_key))
			{
				if(!visit[n]) {
					visit[n] = true;
					total += d+1;
					queue.add(new SimpleEntry(n,d+1));
				}
			}
		}
		
	}

}
	
	 


