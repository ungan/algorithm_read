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
		HashMap<String,String> hash_s = new HashMap<>();
		HashMap<String,String> hash_i = new HashMap<>();
		
		for(int i=1; i<=n; i++)
		{
			String s = br.readLine();
			
			hash_s.put(Integer.toString(i), s);
			hash_i.put(s, Integer.toString(i));
		}
		
		for(int i=0; i<m; i++)
		{
			String s = br.readLine();
			
			if(hash_s.containsKey(s))
			{
				bw.write(hash_s.get(s) + "\n");
			}
			
			if(hash_i.containsKey(s))
			{
				bw.write(hash_i.get(s) + "\n");
			}
		}
		
		//bw.write(Integer.toString(count));
		bw.flush();
		bw.close();

	}
	
}
