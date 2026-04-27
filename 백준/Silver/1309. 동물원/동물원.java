import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count=0;
        int n = Integer.parseInt(br.readLine());
        long a = 1;
        long b= 2;
        
        for(int i=1; i<n; i++)
        {
        	long new_b = (a*2 + b)%9901;
        	long new_a = (a + b)%9901;
			a = new_a;
			b = new_b;
			//System.out.println(a + " " + b);
        }
        
        System.out.println((a+b)%9901);
        //bw.write(Integer.toString(a+b));
        bw.flush();
        bw.close();
        br.close();

    }
    
    
}