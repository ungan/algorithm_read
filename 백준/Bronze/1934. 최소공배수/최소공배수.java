import java.io.*;
import java.util.*;

public class Main {
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(Integer.toString(a*b/gong(a,b)) + "\n");
			
		}
		
		//bw.write(Integer.toString(count));
        bw.flush();
		bw.close();
		br.close();
	}
	
	static int gong(int a, int b)
	{
		while(b!=0) {
			int r = a%b;
			
			a=b;
			b=r;
			
		}
		return a;
	}
}
