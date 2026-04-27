import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String string = br.readLine();
		
		Queue<Character> q = new LinkedList<>();
		int charact[] = new int['Z'];
		
		st = new StringTokenizer(br.readLine());
		
		int A =Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int count=0;
		
		for(int i=0; i<s; i++)
		{
			if(q.size()>=p)
			{
				char poll = q.poll();
				charact[poll]--;
			}
			
			char c = string.charAt(i);
			charact[c]++;
			q.add(c);
			
			if(q.size()==p && charact['A'] >= A && charact['C'] >= C && charact['G'] >= G && charact['T'] >= T)
			{
				count++;
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
