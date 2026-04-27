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
		
		int home[][] = new int[n][3];
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3;j++)
			{
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<n; i++)
		{
			home[i][0] += Math.min(home[i-1][1], home[i-1][2]);
			home[i][1] += Math.min(home[i-1][0], home[i-1][2]);
			home[i][2] += Math.min(home[i-1][0], home[i-1][1]);
		}
		
		int min =  Math.min(home[n-1][0],home[n-1][1]);
	
		 min =  Math.min(home[n-1][2],min);
		
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
		br.close();
	}

}
