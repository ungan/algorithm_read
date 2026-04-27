import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int array[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int lis[] = new int[N];
		int lis_reverse[] = new int[N];
		
		List<Integer> list  = new ArrayList<>();
		
		
		for(int i=0; i<array.length ;i++)
		{
			int x = array[i];
			if(list.isEmpty() || list.get(list.size()-1) < x) list.add(x);
			else
			{
				int idx = Collections.binarySearch(list, x);
				
				if(idx<0) idx = -(idx+1);
				
				list.set(idx, x);
			}
			lis[i] = list.size();
		}
		
		list.clear();
		
		
		for(int i=array.length-1; i>=0 ;i--)
		{
			int x = array[i];
			if(list.isEmpty() || list.get(list.size()-1) < x) list.add(x);
			else
			{
				int idx = Collections.binarySearch(list, x);
				
				if(idx<0) idx = -(idx+1);
				
				list.set(idx, x);
			}
			lis_reverse[i] = list.size();
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++)
		{
			//System.out.println(lis[i] + " " +lis_reverse[i]);
			pq.add(lis[i] + lis_reverse[i]-1);
		}
		
		bw.write(Integer.toString(pq.poll()));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
