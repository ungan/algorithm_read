
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean dp[][];
	static int array[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(br.readLine());
        int number = (100000-1)*10+6;
        array = new int[n+1];
        
        dp = new boolean[n+1][n+1];
        
        st=new StringTokenizer(br.readLine());
        
        for(int i=1; i<=n; i++)
        {
        	array[i] = Integer.parseInt(st.nextToken());
        }
        solve(array,n);
        
        int testcase = Integer.parseInt(br.readLine());
        
        for(int i=0; i < testcase; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if(dp[start][end]) bw.write("1\n");
        	else bw.write("0\n");
        }
       
        //bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

 
    public static void solve(int []array, int n)
    {
    	for(int i=1; i<=n; i++)
    	{
    		dp[i][i] = true;
    	}
    	
    	for(int i=1; i<=n-1;i++)
    	{
    		if(array[i] == array[i+1]) dp[i][i+1] = true;
    	}
    	
    	for(int i=2; i<n;i++)
    	{
    		for(int j=1; j<= n-i;j++) {
    			if(array[j] == array[j+i] && dp[j+1][j+i-1]) {
    				dp[j][j+i] = true;
    			}
    		}
    	}
    }
}
