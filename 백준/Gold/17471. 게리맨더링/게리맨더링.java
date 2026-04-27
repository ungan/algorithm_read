import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int r;
	static boolean visit[];
	static int[] comb;
	static List<List<Integer>> list;
	static int count=0;
	static int min =0;
	static int total_poeple =0;
	static int cur_poeple=0;
	static int people[];
	static boolean check= false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		list = new ArrayList<>();
		
		for(int i=0; i<=N; i++)
		{
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
		{
			people[i] = Integer.parseInt(st.nextToken());
			total_poeple += people[i];
		}
		min = total_poeple;
		
		for(int i=1; i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
	
			for(int j=0; j<n;j++)
			{
				int b = Integer.parseInt(st.nextToken());
				list.get(i).add(b);
				list.get(b).add(i);
			}
			
		}
		comb = new int[N];
		for(int i=1; i<=N/2; i++)
		{
			r=i;
			depth(1,0);
		}
	
		//depth(0,0);
		
		if(check) System.out.println(min);
		else System.out.println("-1");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	static void depth(int start ,int d)
	{
		if(r == d)
		{
			cur_poeple=0;
			if(!call_dfs()) return;// dfs 로 연결됨 확인
			//System.out.println("r : " +r +" " + Arrays.toString(comb) + " cur_poeple : " + cur_poeple + " total_poeple : " + total_poeple);
			//System.out.println("");
			
			int num = Math.abs(total_poeple - (cur_poeple*2));
			if(num < min) min = num;
			check = true;
			return;
		}
		
		for(int i=start; i<=N; i++)
		{
			//System.out.println("start : " + start);
			
			comb[d] = i;
			depth(i+1, d+1);
		}
	
	}
	static boolean call_dfs()
	{
		boolean visit_a[] = new boolean[N+1];		// 콤브가 들렸던곳 true 해서 콤브 이외 지역 탐색
		boolean visit_b[] = new boolean[N+1];		// 콤브가 안들린곳 true 해서 코브 지역 탐색
		
		int count=0;
		
		for(int i=1; i<=N; i++)
		{
			if(count < r && comb[count] == i)	// 배열 범위 벗어나는거 막아주기
			{
				visit_a[i] = true;
				visit_b[i] = false;
				
				//System.out.println("i : " + i);
				if(r==1) {
					//System.out.println("i : " + i + "people[comb[count]] : " + people[comb[count]]);
					//System.out.println("comb[count] : " + comb[0]);
					//System.out.println("");
				}
				cur_poeple += people[comb[count]];
				count++;
				continue;
			}
			
			visit_a[i] = false;
			visit_b[i] = true;
		}
		
		int dfs_count=0;
		
		for(int i=1; i<=N; i++)
		{
			if(visit_a[i]) continue;
			dfs_count++;
			visit_a[i] = true;
			dfs(i,comb,visit_a);
			//System.out.println("dfs_count " + dfs_count);
			if(dfs_count>1)
			{
				//System.out.println("콤브 이외 2지역 이상 카운트"); 
				return false;
			}
		}
		
		dfs_count=0;
		
		for(int i=1; i<=N; i++)
		{
			if(visit_b[i]) continue;
			dfs_count++;
			dfs(i,comb,visit_b);
			
			if(dfs_count>1) 
			{
				//System.out.println("콤브 지역 2지역 이상 카운트"); 
				return false;
			}
		}
		
		
		//System.out.println("??");
		return true;
		
		
	}
	
	static void dfs(int n,int comb[],boolean visit[])
	{
		
		
		for(int i : list.get(n))
		{
			if(visit[i]) continue;
			visit[i] = true;
			//System.out.println("intput n : " + n + " i : " + i);
			dfs(i,comb,visit);
			
			
		}
		
		
	}
}
