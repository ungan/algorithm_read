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
		
		int array[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i=1; i<=n; i++)
		{
			int a = Integer.parseInt(br.readLine());
			array[i] = a;
		}
		
		
		if(n == 0)
		{
			bw.write("0");
			//bw.write(Integer.toString(i)));
		}
		else if(n == 1)
		{
			bw.write(Integer.toString(array[1]));
			bw.flush();
			return;
		}
		else if(n == 2)
		{
			bw.write(Integer.toString(array[2] + array[1]));
			bw.flush();
			return;
		}
		
		dp[0] = 0;
		dp[1] = array[1];
		dp[2] = array[1]+array[2];
		
		for(int i=3; i<=n; i++)
		{
			dp[i] = array[i] + dp[i-2] > array[i] + array[i-1] + dp[i-3]  ? array[i] + dp[i-2] :  array[i] + array[i-1] + dp[i-3]; 
		}
		
		if(n>1)
		{
			bw.write(Integer.toString(dp[n]));			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
