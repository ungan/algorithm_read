import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		String s = br.readLine();
		int count=0;
		int i=0;
		//System.out.println("s.length : " + s.length());
		while(i< s.length())
		{
			count++;
			String count_s = Integer.toString(count);
			boolean count_b[] = new boolean[count_s.length()];
			
			for(int j=0; j<count_s.length(); j++)
			{
				if(count_b[j]) continue;
				//System.out.println( i + "  " + j);
				if(s.charAt(i) == count_s.charAt(j))
				{
					count_b[j] = true;
					i++;
					if(i>= s.length()) break;
				}
			}
		}
		
		System.out.println(count);

	}
	
}
