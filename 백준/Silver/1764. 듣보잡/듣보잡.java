import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> hash_n = new HashSet<String>();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		for(int i=0; i<n; i++)
		{
			hash_n.add(br.readLine());
		}
		

		HashSet<String> hash_m = new HashSet<String>();
		
		for(int i=0; i<m; i++)
		{
			hash_m.add(br.readLine());
		}
		
		
		for(String s : hash_n)
		{
			if(hash_m.contains(s)) pq.add(s);
		}
		
		bw.write(Integer.toString(pq.size())+"\n");
		while(!pq.isEmpty())
		{
			bw.write(pq.poll() + "\n");
		}
		//bw.write(Long.toString(count));
		
        bw.flush();
		bw.close();
		br.close();
	}
	

}
