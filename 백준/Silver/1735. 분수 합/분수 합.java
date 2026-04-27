import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x2= Integer.parseInt(st.nextToken());
		int y2= Integer.parseInt(st.nextToken());
		
		int child = x*y2 + x2*y;
		int parent = y*y2;
		
		
		int go = gcd(child,parent);
		
		//System.out.println(x + " " + x2 + " " + y + " " + y2);
		System.out.println(child/go + " " + parent/go);
		//bw.write(Integer.toString(x*go + x2*go) +" "+ Integer.toString(y*y2/go));
        bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcd(int a, int b)
	{
		while(b!=0)
		{
			int r = a%b;
			a = b;
			b = r;
			
		}
		
		return a;
	}
}
