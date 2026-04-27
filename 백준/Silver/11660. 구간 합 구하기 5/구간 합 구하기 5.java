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
		int [][]array = new int[n][n];
		int s[][] = new int[n+1][n+1];
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
			{
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n;i++)
		{
			for(int j=1; j<=n;j++)
			{
				s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + array[i-1][j-1];
			}
		}
		
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int temp = s[x2][y2] - s[x2][y1-1] - s[x1-1][y2] + s[x1-1][y1-1];
			bw.write(Integer.toString(temp) + "\n");
		}
		bw.flush();
		bw.close();
		
    }
}
