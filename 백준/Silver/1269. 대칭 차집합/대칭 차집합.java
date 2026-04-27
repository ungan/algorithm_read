import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> hash_n = new HashSet<>();
		HashSet<String> hash_m = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			hash_n.add(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
		{
			hash_m.add(st.nextToken());
		}
		
		int count=0;
		
		for(String s : hash_n)
		{
			if(hash_m.contains(s)) count++;
		}
		
		bw.write(Integer.toString(hash_n.size() + hash_m.size() -count*2));
		bw.flush();
		bw.close();

	}
	
}
