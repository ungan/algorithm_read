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
		
		int tile[] = new int[n+1];
		
		if(n==1)
		{
			bw.write(Integer.toString(1));
			bw.flush();
			return;
		}
		else if(n==2)
		{
			bw.write(Integer.toString(2));
			bw.flush();
			return;
		}
		
		 
		tile[0] = 0;
		tile[1] = 1;
		tile[2] = 2;
		
		for(int i=3; i<=n;i++)
		{
			tile[i] = (tile[i-1] + tile[i-2])% 10007;;
		}
		
		
		
		bw.write(Integer.toString(tile[n]%10007));
		bw.flush();
		bw.close();
		br.close();
	}

}
