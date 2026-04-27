

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int count =0;
		
		st = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int max=0;
		for(int i=0; i<n; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
			if(array[i] > max) max = array[i];
		}
		
		int b = Integer.parseInt(br.readLine());
		boolean[] bucket = new boolean[2000000+1];
		
		for(int i=0; i<n;i++)
		{
			int complement = b - array[i];
			
			if(complement >0 && complement <= max & bucket[complement])
			{
				count++;
			}
			
			bucket[array[i]] = true;
		}
		
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
