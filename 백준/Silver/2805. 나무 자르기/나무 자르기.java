import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k=0;
        
        int array[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++)
        {
        	array[i] = Integer.parseInt(st.nextToken());
        	if(k<array[i]) k = array[i];
        }
       int low=0;
       int high = k;
       int result = 0;
       
       while(low <= high)
       {
    	   int mid = (low + high)/2;
    	   long total = 0;
    	   
    	   for(int i=0; i<N; i++)
    	   {
    		   if(array[i] > mid) total += array[i] - mid;
    	   }
    	   
    	   if(total>= M) {
    		   result = mid;
    		   low = mid+1;
    	   }else
    	   {
    		   high = mid-1;
    	   }
       }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

   
}
