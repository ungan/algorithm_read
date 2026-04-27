
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[n+1];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=n; i++)
        {
        	arr[i] += arr[i-1] + Integer.parseInt(st.nextToken());
        	//System.out.println("arr[i] : " + arr[i]);
        }
        
        long count = 0;
        long[] cnt = new long[m];
        
        for(int i=1; i<=n; i++) {
        	
    		int currentSum = (int) (arr[i] % m);
    		
    		if( currentSum == 0) count ++;
    		
    		cnt[currentSum]++;
        	
        	
        	//System.out.println("count : " + count);
        }
        
        for(int i=0; i<m; i++) {
        	if(cnt[i] > 1) {
        		count += (cnt[i] * (cnt[i] - 1)) /2;
        	}
        }
        
        bw.write(Long.toString(count));
        bw.flush();
        bw.close();
        
        
    }
}