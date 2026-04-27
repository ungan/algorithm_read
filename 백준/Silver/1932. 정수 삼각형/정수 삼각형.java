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
		
		int tri[][] = new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<(i+1);j++)
			{
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int i=n-2; i>=0; i--)
		{
			for(int j=0; j<i+1;j++)
			{
				//System.out.println(i + " "+ j);
				tri[i][j] += Math.max(tri[i+1][j],tri[i+1][j+1]);
				//System.out.println(i + " "+ j + " " + tri[i][j]);
			}
		}
		
		bw.write(Integer.toString(tri[0][0]));
		bw.flush();
		bw.close();
		br.close();
	}

}
