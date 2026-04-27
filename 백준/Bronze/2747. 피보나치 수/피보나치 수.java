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
		
		if(n == 0)
		{
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		int array[] = new int[n+1];
		array[1] =1;
		
		for(int i=2; i<=n; i++)
		{
			array[i] = array[i-1] + array[i-2];
		}
		
		bw.write(Integer.toString(array[n]));
		bw.flush();
		bw.close();
		br.close();
	}

}
