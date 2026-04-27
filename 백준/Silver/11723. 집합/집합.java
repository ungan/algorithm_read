import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	
    	int mask=0;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<N; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		String s = st.nextToken();
    		int n =0;
    		
    		switch (s) {
				case "add": 
					int add = Integer.parseInt(st.nextToken());
					mask = mask | (1 << add);
					break;
					
				case "check":
					n = Integer.parseInt(st.nextToken());
					if((mask & (1 << n)) != 0) {
						bw.write("1\n");
					}
					else
					{
						bw.write("0\n");
					}
					break;
				
				case "remove":
					n = Integer.parseInt(st.nextToken());
					if((mask & (1 << n)) != 0) {
						mask = mask & ~(1 << n);
					}		
					break;
				
				case "all":
					for(int j = 1; j<=20; j++) {
						mask = mask | (1 << j);
					}
					break;
				
				case "empty":
					mask = 0;
					break;
					
				case "toggle":
					n = Integer.parseInt(st.nextToken());
					
					if((mask & (1 << n)) != 0) {
						mask = mask & ~(1 << n);
					}
					else
					{
						mask = mask | (1 << n);
					}
					break;
				
	    	}
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
	
}
