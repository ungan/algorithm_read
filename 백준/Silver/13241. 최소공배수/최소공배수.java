import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a= Long.parseLong(st.nextToken());
		long b= Long.parseLong(st.nextToken());
		
		
		bw.write(Long.toString(a*b/gong(a,b)));
        bw.flush();
		bw.close();
		br.close();
	}
	
	static long gong(long a, long b)
	{
		while(b != 0)
		{
			long r = a%b;
			a=b;
			b=r;
		}
		
		return a;
	}
}
