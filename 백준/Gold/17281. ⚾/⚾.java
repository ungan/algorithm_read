import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static boolean[] visit;
	static int array [][];
	static int N;
	static int score_max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		result = new int[9];			// 고를것 의 개수
		visit = new boolean[9];		// 
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][9];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9;j++)
			{
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit[0] = true;
		depth(0);
		bw.write(Integer.toString(score_max));
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void depth(int depth)
	{
		if(depth == 9)
		{
			//System.out.println(Arrays.toString(result));
			calculator();
			return;
		}
		
		if(depth == 3)
		{
			result[depth] = 0;
			depth(depth+1);
			return;
		}
		
		for(int i=0; i<9; i++)
		{
			if(visit[i]) continue;
			
			visit[i] = true;
			result[depth] = i;
			depth(depth+1);
			visit[i] = false;
			
		}
	}
	
	static void calculator()
	{
		int out_count =0;
		int innings = 1;
		int number_hitter =1;
		//int r[] = new int[4];
		Queue<Integer> q = new LinkedList<>();
		int score = 0;
		
		while(true)
		{
			if(out_count ==3)
			{
				innings++;
				out_count=0;
				q.clear();
			}
			if(innings > N) break;
			if(number_hitter == 10) number_hitter = 1;
			
			//System.out.println("innings " + innings);
			
			int a = array[innings-1][result[number_hitter-1]];

			if(a == 0)
			{
				out_count++;
			}
			else
			{
				int size = q.size();
				for(int i=0; i<size; i++)
				{
					int num = q.poll() + a;
					
					if(num > 3)
					{
						score++;
					}
					else
					{
						q.add(num);
					}
				}
				
				if(a > 3)
				{
					score++;
				}
				else
				{
					q.add(a);
				}
			}
			
			number_hitter++;
			
		}
		
		if(score > score_max) score_max = score;
	}
	
	
	
}
