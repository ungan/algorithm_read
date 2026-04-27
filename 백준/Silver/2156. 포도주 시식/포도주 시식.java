import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int array[] = new int[10001];
		int dp[] = new int[10001];
		
		//st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
		{
			array[i] = Integer.parseInt(br.readLine());
		}
		//dp[0] = (long) 0;
		//dp[2] = (long) 1;
		
		
		dp[0] = array[0];
		dp[1] = array[1] + array[0];
		dp[2] = Math.max(array[1] + array[0],array[2] + array[1]);
		dp[2] = Math.max(dp[2], array[0] + array[2]);
		
		for(int i=3; i<N; i++)
		{
			dp[i] = Math.max(dp[i-1], array[i] + array[i-1] + dp[i-3]);
			dp[i] = Math.max(dp[i], array[i]+dp[i-2]);
		}
		
		bw.write(Integer.toString(dp[N-1]));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
