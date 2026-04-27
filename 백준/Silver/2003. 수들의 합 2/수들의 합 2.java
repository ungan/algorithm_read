import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int array[] = new int[N];
		int sum_array[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N;i++)
		{
			sum_array[i+1] = array[i] + sum_array[i]; 
		}
		
		int start =0;
		int end =0;
		int count =0;
		
		while(true)
		{
			int sum = sum_array[end] - sum_array[start];
			if(M == sum)
			{
				start++;
				count++;
			}
			else if(M > sum)
			{
				if(end==N) break;
				end++;
			}
			else if(M < sum)
			{
				start++;
			}
			
		}
		
		bw.write(Long.toString(count));
		
        bw.flush();
		bw.close();
		br.close();
	}
	

}
