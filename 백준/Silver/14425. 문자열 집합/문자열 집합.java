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
		
		HashSet<String> hash_n = new HashSet<>();
		HashMap<String,Integer> hash_m = new HashMap<>();
		
		//st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			hash_n.add(br.readLine());
		}
		
		//st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
		{
			String  s = br.readLine();
			hash_m.put(s,hash_m.getOrDefault(s, 0) + 1);
		}
		
		int count=0;
		//System.out.println(hash_m.size() + " " + m);
		for(Entry<String, Integer> entry : hash_m.entrySet())
		{
			//System.out.println(s);
			if(hash_n.contains(entry.getKey())) count+= entry.getValue();
		}
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();

	}
	
}
