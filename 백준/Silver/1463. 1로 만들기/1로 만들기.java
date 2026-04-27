import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n+1];
		int count=0;
		
		if(n == 1)
		{
			bw.write(Integer.toString(0));
			bw.flush();
			return;
		}
		else if(n==2)
		{
			bw.write(Integer.toString(1));
			bw.flush();
			return;
		}
		else if(n==3)
		{
			bw.write(Integer.toString(1));
			bw.flush();
			return;
		}
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		
		for(int i=4; i<=n;i++)
		{
			dp[i] = dp[i-1] + 1;
			if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3 == 0) dp[i] = Math.min(dp[i],dp[i/3]+1);
			
		}
		
		bw.write(Integer.toString(dp[n]));
		
		bw.flush();
		bw.close();
		br.close();
	}

}
