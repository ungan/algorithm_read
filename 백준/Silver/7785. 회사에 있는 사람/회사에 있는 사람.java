import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hash = new HashSet<>();
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String s2 = st.nextToken();
			
			if(s2.equals("enter"))
			{
				hash.add(s);
			}
			else
			{
				hash.remove(s);
			}
		}
		
	
		Set<String> reverseSet = new TreeSet<>(Collections.reverseOrder());
		reverseSet.addAll(hash);
		
		for(String s : reverseSet)
		{
			bw.write(s+"\n");
		}
		
		
		//bw.write(Integer.toString(count));
		bw.flush();
		bw.close();

	}
	
}
