import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(br.readLine());
    	int b = Integer.parseInt(br.readLine());
    	int c = Integer.parseInt(br.readLine());
    	
    	bw.write(Integer.toString(a+b-c)+"\n");
    	
    	int ab = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
    	
    	bw.write(Integer.toString(ab-c));
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
}
