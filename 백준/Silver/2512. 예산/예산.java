import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        long N = Integer.parseInt(br.readLine());
        long array[] = new long[(int) N];
        
        st = new StringTokenizer(br.readLine());
        long k=0;
        for(int i=0; i<N;i++)
        {
        	array[i] = Integer.parseInt(st.nextToken());
        	if(k < array[i]) k = array[i];
        }
        long ans = Long.parseLong(br.readLine());
        
        long min=0;
        long mid=0;
        long high = k;
        long result =0;
        
        while(min<=high)
        {
        	Long total=(long) 0;
        	mid = (high+min)/2;
        	
        	for(int i=0; i<N; i++)
        	{
        		if(mid < array[i]) total += mid;
        		if(mid >= array[i]) total += array[i];
        	}
        	
        	if(ans>=total) // 정해진 예산 내 사용
        	{
        		result = mid;
        		min = mid+1;
        	}
        	else
        	{
        		high = mid -1;
        	}
        }
       
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

   
}
