
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	int dp[] = new int[n+1];
    	
    	for(int i=1; i<=n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int t = Integer.parseInt(st.nextToken());
    		int p = Integer.parseInt(st.nextToken());
    		
    		dp[i] = Math.max(dp[i-1], dp[i]);
    		
    		if(i+t-1 <= n) dp[i+t-1] = Math.max(dp[i+t-1], dp[i-1] + p);
    		//System.out.println(i + " " + dp[i] + " " + (i+t));
    	}
    	
    	
    	bw.write(Integer.toString(dp[n]));
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
}
