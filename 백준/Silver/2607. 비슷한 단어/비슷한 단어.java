import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		String origin = br.readLine();
		int[] c = new int[26];
		int[] copy = new int[26];
		
		for(int i =0; i<origin.length(); i++)
		{
			c[origin.charAt(i)-'A']++;
		}
		
		int count=0;
		
		int temp;
		
		for(int i=0; i<n-1; i++)
		{
			temp=0;
			String s = br.readLine();
			Arrays.fill(copy, 0);
			
			for(int j =0; j<s.length(); j++)
			{
				copy[s.charAt(j)-'A']++;
			}
		
			
			for(int j=0; j<26; j++)
			{
				//if(i==2)System.out.println(Math.abs(c[j]-copy[j]));
				temp += Math.abs(c[j]-copy[j]);
			}
			if(temp < 2 || (temp == 2 && origin.length() == s.length())) 
			{
				//System.out.println(s + " " + temp);
				count++;
			}

		}
		
		for(int a=0; a<26; a++)
		{
			//System.out.println(copy[a]);
		}
		
		bw.write(Integer.toString(count));
        bw.flush();
		bw.close();
		br.close();
	}
	

}
