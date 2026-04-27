import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		long[] array = new long[26];
		boolean[] visit = new boolean[26];
		
		
		for(int i=0; i<N; i++)
		{
			String s = br.readLine();
			
			for(int j=s.length()-1; j>=0; j--)
			{
				//System.out.println("s.charAt(i)-'A' : " + (s.charAt(i)-'A'));
				array[s.charAt(j)-'A'] += (long) Math.pow(10,s.length() - j-1);
				
				if(j==0) visit[s.charAt(j)-'A'] = true;
			}
		}
		
		//System.out.println("a : " + array[0]);
		
		//Arrays.sort(array);
		
		PriorityQueue<Long> pq_normal = new PriorityQueue<Long>(Collections.reverseOrder());
		PriorityQueue<Long> pq_first = new PriorityQueue<Long>(Collections.reverseOrder());
		
		for(int i=0; i<26; i++)
		{
			if(visit[i]) pq_first.add(array[i]);
			else pq_normal.add(array[i]);
		}
		
		///System.out.println("a : " + array[25]);
		int c = 25;
		long total =0;
		
		for(int i=9; i>0; i--)
		{
			
			if(!pq_first.isEmpty() && pq_first.peek() >= pq_normal.peek() || pq_first.size() >= i)
			{
				total += pq_first.poll() * i;
			}
			else
			{
				total += pq_normal.poll() * i;
			}
			
			//total += array[c--] * i;
		}
		
		bw.write(Long.toString(total));
		bw.flush();
		bw.close();
		
    }
}