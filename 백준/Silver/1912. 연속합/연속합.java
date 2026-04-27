import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n];
        int max=0;
        
        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        max = dp[0];
        if(dp[0] < 0) dp[0] = 0;
        
        for(int i=1; i<n; i++)
        {
        	int temp = Integer.parseInt(st.nextToken());
        	dp[i] = temp + dp[i-1];
        	max = Math.max(dp[i], max);
        	if(dp[i] < 0) dp[i] = 0;
        }
        
        
        
        
        System.out.println(max);
        //bw.write();
//        bw.flush();
//        bw.close();
//        br.close();

    }
    
}