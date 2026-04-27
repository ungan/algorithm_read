import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hash = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			hash.add(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
		{
			if(hash.contains(st.nextToken()))
			{
				bw.write("1 ");
			}
			else
			{
				bw.write("0 ");
			}
		}
		
		bw.flush();
		bw.close();

	}
	
}
