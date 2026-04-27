import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int array[] = new int[n];
		int sum[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i< n; i++)
		{
			//System.out.println(" i  : " + i);
			array[i] = Integer.parseInt(st.nextToken());
			
			if(i == 0) sum[i] = array[i] ;
			else
			{
				sum[i] = array[i] + sum[i-1];
			}
			
		}
		
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			int s2=0;  
			
			if(a-2 < 0)
			{
				s2=0;
			}
			else if(a-2 >=0)
			{
				s2 = sum[a-2];
			}
			
			int s = sum[z-1] - s2;
			
			//System.out.println("sum[z-1] :" + sum[z-1] + "sum[a-1] : " + sum[a-2]);
			
			
			bw.write(Integer.toString(s) + "\n");
		}
		
		bw.flush();
		bw.close();
	}	

}


/*

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][]array = new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
			{
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for()
		
*/