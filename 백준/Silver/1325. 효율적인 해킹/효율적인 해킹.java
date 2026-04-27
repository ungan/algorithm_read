import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N=0;
	
	static boolean[] value;
	static boolean total_value[];
	
	static int count=0;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		int count_array[] = new int[N+1];
		total_value = new boolean[N+1];
		
		int max_count=0;
		Queue<Integer> computer = new LinkedList<>();
		
		for(int i=0; i<=N; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			
			graph[y].add(x);
		}
		value = new boolean[N+1];
		
		for(int i=1; i<=N; i++) // bfs
		{
			if(total_value[i] == false)
			{
				
				for(int j =1 ; j<=N;j++)
				{
					value[j] = false;
				}
				
				count=0;
				bfs(graph,i);
				//count_array[i] = count;
				//System.out.println("count : "  + count);
				if(max_count < count) 
				{
					computer.clear();
					computer.add(i);
					max_count = count;
					
				}
				else if(max_count == count)
				{
					computer.add(i);
				}
			}
			
		}
		
		for(int c : computer)
		{
			bw.write(Integer.toString(c) + " ");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int[][] array, int num)
	{
		value[num] = true;
		count++;
		for(int i=1; i<=N; i++)
		{
			if(array[num][i] == 1 && value[i] == false)
			{
				
				dfs(array,i);
				
			}
		}
	}
	
	static void bfs(ArrayList<Integer>[] graph,int num)
	{
		value[num] = true;
		total_value[num] = true;
		count++;
		q.add(num);
		
		while(!q.isEmpty())
		{
			int start = q.poll();
			for(int n : graph[start]) {
				if(value[n] == false)
				{
					value[n] = true;
					count++;
					q.add(n);
				}
			}
		}
	}

}
