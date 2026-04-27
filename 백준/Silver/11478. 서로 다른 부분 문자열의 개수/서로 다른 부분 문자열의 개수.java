import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static HashSet<String> hash = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		sub(s);
		bw.write(Integer.toString(hash.size()));
		bw.flush();
		bw.close();

	}
	
	static public void sub(String s)
	{
		for(int i=0; i<s.length(); i++) //
		{

			for(int j=i+1; j<=s.length(); j++) //
			{
				hash.add(s.substring(i,j));
			}

		}
		
	}
	
}
