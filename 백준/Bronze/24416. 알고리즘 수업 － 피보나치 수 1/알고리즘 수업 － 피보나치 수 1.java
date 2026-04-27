import java.io.*;
import java.util.*;

class Main {
	static int code1_count = 0;
	static int code2_count = 0;
	static int f[] = new int[41];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        code1(n);
        code2(n);
       
        String s =  code1_count + " " + code2_count; 
        bw.write(s);
        bw.flush();
        bw.close();
        br.close();

    }
    
    public static int code1(int n)
    {
    	
    	if(n == 1 || n == 2)
    	{
    		code1_count++;
    		return 1;
    	}
    	else
		{
    		//code1_count++;
    		return(code1(n-1) + code1(n-2));
		}
    	
    }
    
    public static void code2(int n)
    {
    	f[1] = f[2] = 1;
    	
    	for(int i=3; i<=n; i++)
    	{
    		code2_count++;
    		f[i] = f[i-1] + f[i-2];
    	}
    }
    
}