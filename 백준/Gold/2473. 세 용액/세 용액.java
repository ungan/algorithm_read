import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String ans="";
		long[] array = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		long min=Long.MAX_VALUE;
		
		for(int i=0; i<n; i++)
		{
			int start = i+1;
			int end = n-1;
			
			
			while(start < end)
			{
				long sum = array[start] + array[end] + array[i];
				//System.out.println(array[i] + " " + array[start] + " " +array[end] + " " + sum);
				//System.out.println("min : " + min);
				if(Math.abs(sum) < min)
				{
					min = Math.abs(sum);
					ans = array[i] + " " + array[start] + " " +array[end]; 
				}
				
				if(sum == 0)
				{
					
					break;
				}
				else if(sum < 0)
				{
					start++;
				}
				else if(sum > 0)
				{
					end--;
				}
			}
			if(min == 0) break;
		}
		
		System.out.println(ans);

	}
	
}
