import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hash_n = new HashMap<String, Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
		{
			int a = Integer.parseInt(st.nextToken());
			hash_n.put(Integer.toString(a), hash_n.getOrDefault(Integer.toString(a), 0) + 1);
			
			//System.out.println(a + " " + hash_n.get(Integer.toString(a)));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
		{
			int a = Integer.parseInt(st.nextToken());
			if(hash_n.containsKey(Integer.toString(a)))
			{
				bw.write(Integer.toString(hash_n.get(Integer.toString(a))) + " ");
			}
			else
			{
				bw.write("0 ");
			}
		}
		//bw.write(Long.toString(count));
		
        bw.flush();
		bw.close();
		br.close();
	}
	

}
