import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
			
		}
		long count=0;

		
		long[] ab = new long[n*n];
		long[] cd = new long[n*n];
		count=0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				ab[i*n+j] = a[i]+b[j];
				cd[i*n+j] = c[i]+d[j];
			}
		}
		
		Arrays.sort(ab);
		Arrays.sort(cd);
//		for(int i=0; i<n; i++)
//		{
//			for(int j=0; j<n; j++)
//			{
//				
//				System.out.println(ab[i*n+j] + " " + cd[i*n+j]);
//			}
//		}
//		
		int start=0;
		int end = n*n-1;
		count=0;
		
		
		while(true)
		{ 
			//System.out.println(start + " " + end);
			long sum = ab[start] + cd[end];
			//System.out.println(start + " " + end  + " " + ab[start] + " " + cd[end]);
			if(sum == 0)
			{
				//System.out.println(sum + " " + ab[start] + " " + cd[end]);
				
				long ab_count=1;
				long cd_count=1;
				
				//System.out.println(start + " " + end);
				while(n*n-1 >start && ab[start+1] == ab[start])
				{
					start++;
					ab_count++;
				}
				
				while(end>0 && cd[end-1] == cd[end])
				{
					end--;
					cd_count++;
					
				}
//				System.out.println("두번쨰" + start + " " + end);
//				System.out.println(ab[start+1] + " " + cd[end-1]);
				count += ab_count * cd_count;
				start++;
				if(n*n-1 <start) break;
			}
			else if(sum < 0)
			{
				start++;
				if(n*n-1 <start) break;
			}
			else if(sum > 0)
			{
				end--;
				if(end<0) break;
			}
		}
		
		System.out.println(count);

	}
	
}
