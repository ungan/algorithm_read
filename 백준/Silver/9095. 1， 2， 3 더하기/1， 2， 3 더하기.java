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
		
		int dp[] = new int[13];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=12; i++)
		{
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int i=0; i<n;i++)
		{
			int a = Integer.parseInt(br.readLine());
			bw.write(Integer.toString(dp[a]) + "\n");			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
