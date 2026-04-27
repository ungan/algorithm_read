import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> hash = new  HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			hash.add(Integer.parseInt(st.nextToken()));
		}
		
		int n2 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n2; i++)
		{
			if(hash.contains(Integer.parseInt(st.nextToken())))
			{
				bw.write("1\n");
			}
			else
			{
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
